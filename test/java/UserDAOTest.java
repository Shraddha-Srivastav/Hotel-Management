import org.junit.jupiter.api.*;

import com.user.dao.UserDAO;
import com.user.dao.UserDAO.EmployeeDAO;
import com.user.dao.UserDAO.GuestDAO;
import com.user.dao.UserDAO.ReservationDAO;
import com.user.dao.UserDAO.RoomDAO;
import com.user.model.User.Employee;
import com.user.model.User.Guest;
import com.user.model.User.Reservation;
import com.user.model.User.Room;

import static org.junit.jupiter.api.Assertions.*;


import java.sql.SQLException;


public class UserDAOTest {

    private GuestDAO guestDAO;
    private RoomDAO roomDAO;
    private EmployeeDAO employeeDAO;
    private ReservationDAO reservationDAO;

    @BeforeEach
    void setUp() throws SQLException {
        // Initialize DAO instances
        guestDAO = new GuestDAO();
        roomDAO = new RoomDAO();
        employeeDAO = new EmployeeDAO();
        reservationDAO = new ReservationDAO();
        
        // Optional: Set up in-memory database schema here if needed
    }

    @Test
    void testAddGuest() throws SQLException {
    	UserDAO.GuestDAO guestDAO = new UserDAO.GuestDAO();

        Guest guest = null;
		assertDoesNotThrow(() -> guestDAO.addGuest(guest));
    }

    @Test
    void testAddRoom() throws SQLException {
    	UserDAO.RoomDAO roomDAO = new UserDAO.RoomDAO();
        Room room = null;
		assertDoesNotThrow(() -> roomDAO.addRoom(room));
    }

    @Test
    void testGetRoomById() throws SQLException {
    	UserDAO.RoomDAO roomDAO = new UserDAO.RoomDAO();
        Room room = null;
		roomDAO.addRoom(room);

        Room retrievedRoom = roomDAO.getRoomById(1);
        assertNotNull(retrievedRoom);
        assertEquals("101", retrievedRoom.getRoomNumber());
    }

    @Test
    void testAddEmployee() throws SQLException {
    	 UserDAO.EmployeeDAO employeeDAO = new UserDAO.EmployeeDAO();
        Employee employee = null;
		assertDoesNotThrow(() -> employeeDAO.addEmployee(employee));
    }

    @Test
    void testAddAndRetrieveReservation() {
    	UserDAO.ReservationDAO reservationDAO = new UserDAO.ReservationDAO();
        Reservation reservation = null;
		assertTrue(reservationDAO.addReservation(reservation));

        Reservation retrievedReservation = reservationDAO.getReservationById(1);
        assertNotNull(retrievedReservation);
        assertEquals("Confirmed", retrievedReservation.getStatus());
    }

    @AfterEach
    void tearDown() {
        // Optional: Clean up the in-memory database or resources if necessary
    }
}

	