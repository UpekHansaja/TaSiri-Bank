package lk.jiat.bank.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lk.jiat.bank.model.User;

import java.io.IOException;
import java.util.Map;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        ServletContext context = getServletContext();

        Map<String, User> userMap = (Map<String, User>) context.getAttribute("users");

        User user = userMap.get(username);

        if (user != null && user.getPassword().equals(password)) {

            HttpSession session = req.getSession();
            session.setAttribute("loggedUser", user);

            if (user.getRole().equals("ADMIN")) {
                resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
            } else {
                resp.sendRedirect(req.getContextPath()+"/dashboard");
            }

        } else {
            req.setAttribute("error","Invalid username or password..!");

            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }
}
