package controller;


import java.io.IOException;

import com.user.dao.UserDAO;
import com.user.dao.UserDAO.ReservationDAO;
import com.user.model.User;
import com.user.model.User.Reservation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/reserve")
public class ReservationController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReservationDAO reservationDAO;

    @Override
    public void init() {
        reservationDAO = new ReservationDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            String roomType = request.getParameter("roomType");
            String checkInDate = request.getParameter("checkInDate");
            String checkOutDate = request.getParameter("checkOutDate");
            int userId = ((User) session.getAttribute("user")).getId();

            UserDAO.ReservationDAO reservationDAO = new UserDAO.ReservationDAO();
            Reservation reservation = null;
			if (reservationDAO.addReservation(reservation)) {
                response.sendRedirect("reservation-success.jsp");
            } else {
                request.setAttribute("errorMessage", "Failed to reserve. Try again.");
                request.getRequestDispatcher("reservation.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("login.html");
        }
    }
}
