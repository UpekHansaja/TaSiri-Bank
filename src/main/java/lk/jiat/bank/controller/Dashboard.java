package lk.jiat.bank.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lk.jiat.bank.model.Account;
import lk.jiat.bank.model.User;

import java.io.IOException;
import java.util.Map;

@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        User user = (User) session.getAttribute("loggedUser");

        if (user != null) {

            Map<String, Account> accountMap = (Map<String, Account>) getServletContext().getAttribute("accounts");

            Account userAccount = accountMap.get(user.getAccNo());

            req.setAttribute("userAccount", userAccount);

            req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);

        } else {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }

    }
}
