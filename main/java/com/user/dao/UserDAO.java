package com.user.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Service;
import com.user.model.User;
import com.user.model.User.Employee;
import com.user.model.User.Guest;
import com.user.model.User.Payment;
import com.user.model.User.Reservation;
import com.user.model.User.Room;
import com.user.model.User.RoomMaintenance;

public class UserDAO {
	public static class DatabaseConnection {
	    private static final String URL = "jdbc:mysql://localhost:3306/users";
	    private static final String USER = "root";
	    private static final String PASSWORD = "your_password";

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }
	}
	public static class GuestDAO {
	    private Connection connection;

	    public GuestDAO() throws SQLException {
	        connection = DatabaseConnection.getConnection();
	    }

	    public void addGuest(Guest guest) {
	        String query = "INSERT INTO guests(name, email, phone) VALUES (?, ?, ?)";
	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setString(1, guest.getName());
	            statement.setString(2, guest.getEmail());
	            statement.setString(3, guest.getPhone());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	public static class RoomDAO {
	    private Connection connection;
		private Room room;

	    public RoomDAO() throws SQLException {
	        connection = DatabaseConnection.getConnection();
	    }

	    public Room getRoomById(int roomId) {
	        String query = "SELECT * FROM rooms WHERE room_id = ?";
	        room = null;
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setInt(1, roomId);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                
	                room.setRoomId(rs.getInt("room_id"));
	                room.setRoomNumber(rs.getString("room_number"));
	                room.setType(rs.getString("type"));
	                room.setPrice(rs.getBigDecimal("price"));
	                room.setAvailability(rs.getBoolean("availability"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return room;
	    }

	    public void addRoom(Room room) {
	        String query = "INSERT INTO rooms (room_number, type, price, availability) VALUES (?, ?, ?, ?)";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setString(1, room.getRoomNumber());
	            stmt.setString(2, room.getType());
	            
	            stmt.setBoolean(4, room.isAvailability());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	public static class EmployeeDAO {
	    private Connection connection;
		private Employee employee;

	    public EmployeeDAO() throws SQLException {
	        this.connection = DatabaseConnection.getConnection();
	    }

	    public void addEmployee(Employee employee) {
	        String query = "INSERT INTO employees (name, role, phone, email, salary, hire_date) VALUES (?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setString(1, employee.getName());
	            stmt.setString(2, employee.getRole());
	            stmt.setString(3, employee.getPhone());
	            stmt.setString(4, employee.getEmail());
	            stmt.setDouble(5, employee.getSalary());
	            stmt.setDate(6, new java.sql.Date(employee.getHireDate().getTime()));
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public Employee getEmployeeById(int employeeId) {
	        employee = null;
	        String query = "SELECT * FROM employees WHERE employee_id = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setInt(1, employeeId);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                
	                employee.setEmployeeId(rs.getInt("employee_id"));
	                employee.setName(rs.getString("name"));
	                employee.setRole(rs.getString("role"));
	                employee.setPhone(rs.getString("phone"));
	                employee.setEmail(rs.getString("email"));
	                employee.setSalary(rs.getDouble("salary"));
	                employee.setHireDate(rs.getDate("hire_date"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return employee;
	    }
	}
	public static  class PaymentDAO {
	    private Connection connection;
		private Payment payment;

	    public PaymentDAO() throws SQLException {
	        this.connection = DatabaseConnection.getConnection();
	    }

	    public void addPayment(Payment payment) {
	        String query = "INSERT INTO payments (reservation_id, amount, payment_date, payment_method, status) VALUES (?, ?, ?, ?, ?)";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setInt(1, payment.getReservationId());
	            stmt.setDouble(2, payment.getAmount());
	            stmt.setDate(3, new java.sql.Date(payment.getPaymentDate().getTime()));
	            stmt.setString(4, payment.getPaymentMethod());
	            stmt.setString(5, payment.getStatus());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public Payment getPaymentById(int paymentId) {
	        payment = null;
	        String query = "SELECT * FROM payments WHERE payment_id = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setInt(1, paymentId);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                
	                payment.setPaymentId(rs.getInt("payment_id"));
	                payment.setReservationId(rs.getInt("reservation_id"));
	                payment.setAmount(rs.getDouble("amount"));
	                payment.setPaymentDate(rs.getDate("payment_date"));
	                payment.setPaymentMethod(rs.getString("payment_method"));
	                payment.setStatus(rs.getString("status"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return payment;
	    }
	}
	public static  class ServiceDAO {
	    private Connection connection;
		private Service service;

	    public ServiceDAO() throws SQLException {
	        this.connection = DatabaseConnection.getConnection();
	    }

	    public void addService(Service service) {
	        String query = "INSERT INTO services (name, description, price) VALUES (?, ?, ?)";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setString(1, ((Employee) service).getName());
	            
	            stmt.setDouble(3, ((Room) service).getPrice());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public Service getServiceById(int serviceId) {
	        service = null;
	        String query = "SELECT * FROM services WHERE service_id = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setInt(1, serviceId);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	               
	                
	                ((Employee) service).setName(rs.getString("name"));
	               
	                ((Room) service).setPrice(rs.getDouble("price"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return service;
	    }
	}
	public static class RoomMaintenanceDAO {
	    private Connection connection;
		private RoomMaintenance maintenance;

	    public RoomMaintenanceDAO() throws SQLException {
	        this.connection = DatabaseConnection.getConnection();
	    }

	    public void addRoomMaintenance(RoomMaintenance maintenance) {
	        String query = "INSERT INTO room_maintenance (room_id, maintenance_type, maintenance_date, status, notes) VALUES (?, ?, ?, ?, ?)";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setInt(1, maintenance.getRoomId());
	            stmt.setString(2, maintenance.getMaintenanceType());
	            stmt.setDate(3, new java.sql.Date(maintenance.getMaintenanceDate().getTime()));
	            stmt.setString(4, maintenance.getStatus());
	            stmt.setString(5, maintenance.getNotes());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public RoomMaintenance getRoomMaintenanceById(int maintenanceId) {
	        maintenance = null;
	        String query = "SELECT * FROM room_maintenance WHERE maintenance_id = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setInt(1, maintenanceId);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	              
	                maintenance.setMaintenanceId(rs.getInt("maintenance_id"));
	                maintenance.setRoomId(rs.getInt("room_id"));
	                maintenance.setMaintenanceType(rs.getString("maintenance_type"));
	                maintenance.setMaintenanceDate(rs.getDate("maintenance_date"));
	                maintenance.setStatus(rs.getString("status"));
	                maintenance.setNotes(rs.getString("notes"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return maintenance;
	    }
	}
	public static class ReservationDAO {

	    // Method to add a new reservation
	    public boolean addReservation(Reservation reservation) {
	        String query = "INSERT INTO reservations (guestId, roomId, checkInDate, checkOutDate, status) VALUES (?, ?, ?, ?, ?)";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query)) {
	            stmt.setInt(1, reservation.getGuestId());
	            stmt.setInt(2, reservation.getRoomId());
	            stmt.setDate(3, new Date(reservation.getCheckIn().getTime()));
	            stmt.setDate(4, new Date(reservation.getCheckIn().getTime()));
	            stmt.setString(5, reservation.getStatus());
	            return stmt.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    // Method to retrieve a reservation by ID
	    public Reservation getReservationById(int reservationId) {
	        String query = "SELECT * FROM reservations WHERE reservationId = ?";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query)) {
	            stmt.setInt(1, reservationId);
	           
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    // Method to retrieve all reservations
	    public List<Reservation> getAllReservations() {
	        List<Reservation> reservations = new ArrayList<>();
	        String query = "SELECT * FROM reservations";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query);
	             ResultSet rs = stmt.executeQuery()) {
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return reservations;
	    }

	    // Method to update a reservation's details
	    public boolean updateReservation(Reservation reservation) {
	        String query = "UPDATE reservations SET guestId = ?, roomId = ?, checkInDate = ?, checkOutDate = ?, status = ? WHERE reservationId = ?";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query)) {
	            stmt.setInt(1, reservation.getGuestId());
	            stmt.setInt(2, reservation.getRoomId());
	            stmt.setDate(3, new Date(reservation.getCheckIn().getTime()));
	            stmt.setDate(4, new Date(reservation.getCheckIn().getTime()));
	            stmt.setString(5, reservation.getStatus());
	            stmt.setInt(6, reservation.getReservationId());
	            return stmt.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    // Method to delete a reservation
	    public boolean deleteReservation(int reservationId) {
	        String query = "DELETE FROM reservations WHERE reservationId = ?";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query)) {
	            stmt.setInt(1, reservationId);
	            return stmt.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	}
	public User validateUser1(String email, String password) {
		
		return null;
	}
	public boolean registerUser(User user) {
		
		return false;
	}
	public static List<User> getAllUsers() {
		
		return null;
	}
	public static void addUser(User newUser) {
	
		
	}
	public void insertUser(User newUser) {
		
		
	}
	public static User selectUser(int id) {
		
		return null;
	}
	public static void updateUser(User updatedUser) {
		
		
	}
	public static void deleteUser(int id) {
		
		
	}
	
}
