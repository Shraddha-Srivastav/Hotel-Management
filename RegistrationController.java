package controller;



import java.io.IOException;

import com.user.dao.UserDAO;
import com.user.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        if (userDAO.registerUser(user)) {
            response.sendRedirect("login.html");
        } else {
            request.setAttribute("errorMessage", "Registration failed. Try again.");
            request.getRequestDispatcher("register.html").forward(request, response);
        }
    }
}
