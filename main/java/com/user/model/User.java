package com.user.model;

import java.math.BigDecimal;
import java.sql.Date;

public class User {
	public class Guest {
	    private int guestId;
	    private String name;
	    private String email;
	    private String phone;
		public Guest() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Guest(int guestId, String name, String email, String phone) {
			super();
			this.guestId = guestId;
			this.name = name;
			this.email = email;
			this.phone = phone;
		}
		public int getGuestId() {
			return guestId;
		}
		public void setGuestId(int guestId) {
			this.guestId = guestId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		@Override
		public String toString() {
			return "Guest [guestId=" + guestId + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
		}
	   
	}

	public class Room {
	    private int roomId;
	    private String roomNumber;
	    private String type;
	    private double price;
	    private boolean availability;
		public Room() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Room(int roomId, String roomNumber, String type, double price, boolean availability) {
			super();
			this.roomId = roomId;
			this.roomNumber = roomNumber;
			this.type = type;
			this.price = price;
			this.availability = availability;
		}
		public int getRoomId() {
			return roomId;
		}
		public void setRoomId(int roomId) {
			this.roomId = roomId;
		}
		public String getRoomNumber() {
			return roomNumber;
		}
		public void setRoomNumber(String roomNumber) {
			this.roomNumber = roomNumber;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double bigDecimal) {
			this.price = bigDecimal;
		}
		public boolean isAvailability() {
			return availability;
		}
		public void setAvailability(boolean availability) {
			this.availability = availability;
		}
		@Override
		public String toString() {
			return "Room [roomId=" + roomId + ", roomNumber=" + roomNumber + ", type=" + type + ", price=" + price
					+ ", availability=" + availability + "]";
		}
		public void setPrice1(BigDecimal bigDecimal) {
			
		}
		public void setPrice(BigDecimal bigDecimal) {
			// TODO Auto-generated method stub
			
		}
	    
	}

	public class Reservation {
	    private int reservationId;
	    private int guestId;
	    private int roomId;
	    private Date checkIn;
	    private Date checkOut;
		public Reservation() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Reservation(int reservationId, int guestId, int roomId, Date checkIn, Date checkOut) {
			super();
			this.reservationId = reservationId;
			this.guestId = guestId;
			this.roomId = roomId;
			this.checkIn = checkIn;
			this.checkOut = checkOut;
		}
		public int getReservationId() {
			return reservationId;
		}
		public void setReservationId(int reservationId) {
			this.reservationId = reservationId;
		}
		public int getGuestId() {
			return guestId;
		}
		public void setGuestId(int guestId) {
			this.guestId = guestId;
		}
		public int getRoomId() {
			return roomId;
		}
		public void setRoomId(int roomId) {
			this.roomId = roomId;
		}
		public Date getCheckIn() {
			return checkIn;
		}
		public void setCheckIn(Date checkIn) {
			this.checkIn = checkIn;
		}
		public Date getCheckOut() {
			return checkOut;
		}
		public void setCheckOut(Date checkOut) {
			this.checkOut = checkOut;
		}
		public String getStatus() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String toString() {
			return "Reservation [reservationId=" + reservationId + ", guestId=" + guestId + ", roomId=" + roomId
					+ ", checkIn=" + checkIn + ", checkOut=" + checkOut + "]";
		}
	   
	}
	public class Employee {
	    private int employeeId;
	    private String name;
	    private String role;
	    private String phone;
	    private String email;
	    private double salary;
	    private Date hireDate;
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Employee(int employeeId, String name, String role, String phone, String email, double salary,
				Date hireDate) {
			super();
			this.employeeId = employeeId;
			this.name = name;
			this.role = role;
			this.phone = phone;
			this.email = email;
			this.salary = salary;
			this.hireDate = hireDate;
		}
		public int getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public Date getHireDate() {
			return hireDate;
		}
		public void setHireDate(Date hireDate) {
			this.hireDate = hireDate;
		}
		@Override
		public String toString() {
			return "Employee [employeeId=" + employeeId + ", name=" + name + ", role=" + role + ", phone=" + phone
					+ ", email=" + email + ", salary=" + salary + ", hireDate=" + hireDate + "]";
		}

	    
	}
	public class Payment {
	    private int paymentId;
	    private int reservationId;
	    private double amount;
	    private Date paymentDate;
	    private String paymentMethod;
	    private String status;
		public Payment() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Payment(int paymentId, int reservationId, double amount, Date paymentDate, String paymentMethod,
				String status) {
			super();
			this.paymentId = paymentId;
			this.reservationId = reservationId;
			this.amount = amount;
			this.paymentDate = paymentDate;
			this.paymentMethod = paymentMethod;
			this.status = status;
		}
		public int getPaymentId() {
			return paymentId;
		}
		public void setPaymentId(int paymentId) {
			this.paymentId = paymentId;
		}
		public int getReservationId() {
			return reservationId;
		}
		public void setReservationId(int reservationId) {
			this.reservationId = reservationId;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public Date getPaymentDate() {
			return paymentDate;
		}
		public void setPaymentDate(Date paymentDate) {
			this.paymentDate = paymentDate;
		}
		public String getPaymentMethod() {
			return paymentMethod;
		}
		public void setPaymentMethod(String paymentMethod) {
			this.paymentMethod = paymentMethod;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "Payment [paymentId=" + paymentId + ", reservationId=" + reservationId + ", amount=" + amount
					+ ", paymentDate=" + paymentDate + ", paymentMethod=" + paymentMethod + ", status=" + status + "]";
		}

	    
	}
	public class Service {
	    private int serviceId;
	    private String name;
	    private String description;
	    private double price;
		public Service() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Service(int serviceId, String name, String description, double price) {
			super();
			this.serviceId = serviceId;
			this.name = name;
			this.description = description;
			this.price = price;
		}
		public int getServiceId() {
			return serviceId;
		}
		public void setServiceId(int serviceId) {
			this.serviceId = serviceId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "Service [serviceId=" + serviceId + ", name=" + name + ", description=" + description + ", price="
					+ price + "]";
		}

	    
	}
	public class RoomMaintenance {
	    private int maintenanceId;
	    private int roomId;
	    private String maintenanceType;
	    private Date maintenanceDate;
	    private String status;
	    private String notes;
		public RoomMaintenance() {
			super();
			// TODO Auto-generated constructor stub
		}
		public RoomMaintenance(int maintenanceId, int roomId, String maintenanceType, Date maintenanceDate,
				String status, String notes) {
			super();
			this.maintenanceId = maintenanceId;
			this.roomId = roomId;
			this.maintenanceType = maintenanceType;
			this.maintenanceDate = maintenanceDate;
			this.status = status;
			this.notes = notes;
		}
		public int getMaintenanceId() {
			return maintenanceId;
		}
		public void setMaintenanceId(int maintenanceId) {
			this.maintenanceId = maintenanceId;
		}
		public int getRoomId() {
			return roomId;
		}
		public void setRoomId(int roomId) {
			this.roomId = roomId;
		}
		public String getMaintenanceType() {
			return maintenanceType;
		}
		public void setMaintenanceType(String maintenanceType) {
			this.maintenanceType = maintenanceType;
		}
		public Date getMaintenanceDate() {
			return maintenanceDate;
		}
		public void setMaintenanceDate(Date maintenanceDate) {
			this.maintenanceDate = maintenanceDate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getNotes() {
			return notes;
		}
		public void setNotes(String notes) {
			this.notes = notes;
		}
		@Override
		public String toString() {
			return "RoomMaintenance [maintenanceId=" + maintenanceId + ", roomId=" + roomId + ", maintenanceType="
					+ maintenanceType + ", maintenanceDate=" + maintenanceDate + ", status=" + status + ", notes="
					+ notes + "]";
		}

	    
	}
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
