package controller;


import jakarta.servlet.*;
import com.user.model.User.Reservation;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.user.dao.ReservationDAO;
import com.user.model.Reservation;
import com.user.model.User;

import java.io.IOException;

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

            Reservation reservation = new Reservation();
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
