CREATE database users;
use users;
CREATE TABLE guests (
    guest_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50),
    phone VARCHAR(15)
);

CREATE TABLE rooms (
    room_id INT PRIMARY KEY AUTO_INCREMENT,
    room_number VARCHAR(10) NOT NULL,
    type VARCHAR(20),
    price DECIMAL(10, 2),
    availability BOOLEAN DEFAULT TRUE
);

CREATE TABLE reservations (
    reservation_id INT PRIMARY KEY AUTO_INCREMENT,
    guest_id INT,
    room_id INT,
    check_in DATE,
    check_out DATE,
    FOREIGN KEY (guest_id) REFERENCES guests(guest_id),
    FOREIGN KEY (room_id) REFERENCES rooms(room_id)
);
CREATE TABLE employees (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    role ENUM('Manager', 'Receptionist', 'Housekeeping', 'Chef', 'Waitstaff', 'Security') NOT NULL,
    phone VARCHAR(15),
    email VARCHAR(50) UNIQUE,
    salary DECIMAL(10, 2) NOT NULL,
    hire_date DATE
);
CREATE TABLE payments (
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    reservation_id INT NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    payment_date DATE NOT NULL,
    payment_method ENUM('Cash', 'Credit Card', 'Debit Card', 'Online') NOT NULL,
    status ENUM('Paid', 'Pending', 'Failed') DEFAULT 'Pending',
    FOREIGN KEY (reservation_id) REFERENCES reservations(reservation_id)
);
CREATE TABLE services (
    service_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL
);
CREATE TABLE room_maintenance (
    maintenance_id INT PRIMARY KEY AUTO_INCREMENT,
    room_id INT NOT NULL,
    maintenance_type ENUM('Plumbing', 'Electrical', 'Cleaning', 'Furniture Repair') NOT NULL,
    maintenance_date DATE NOT NULL,
    status ENUM('Pending', 'In Progress', 'Completed') DEFAULT 'Pending',
    notes TEXT,
    FOREIGN KEY (room_id) REFERENCES rooms(room_id)
);
