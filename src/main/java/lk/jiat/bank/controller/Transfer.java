package lk.jiat.bank.controller;

import jakarta.servlet.ServletContext;
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

@WebServlet("/transfer")
public class Transfer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/transfer.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String receiverAccNo = req.getParameter("receiverAccNo");

        double amount = Double.parseDouble(req.getParameter("amount"));

        ServletContext context = getServletContext();

//        Map<String, User> userMap = (Map<String, User>) context.getAttribute("users");

        Map<String, Account> accountMap = (Map<String, Account>) context.getAttribute("accounts");

        User loggedUser = (User) req.getSession(false).getAttribute("loggedUser");

        String sender = loggedUser.getAccNo();
        Account senderAcc = accountMap.getOrDefault(sender, null);

        if (senderAcc != null) {
            double senderAccBalance = senderAcc.getAccountBalance();

            if (amount >= senderAccBalance) {
                System.out.println("Insufficient Account Balance..!");

                req.setAttribute("error", "Insufficient Account Balance..!");
                req.getRequestDispatcher("/transfer.jsp").forward(req, resp);
            } else {

                Account receiverAccount = accountMap.getOrDefault(receiverAccNo, null);

                if (receiverAccount != null) {

                    if (sender.equals(receiverAccount.getAccountNo())) {
                        req.setAttribute("error", "You can not transfer money to your own account..!");
                        req.getRequestDispatcher("/transfer.jsp").forward(req, resp);
                        return;
                    }

                    senderAcc.setAccountBalance(senderAcc.getAccountBalance() - amount);

                    receiverAccount.setAccountBalance(receiverAccount.getAccountBalance() + amount);

                    System.out.println("Transfer Successful..!");

                    resp.sendRedirect(req.getContextPath() + "/dashboard");

                } else {
                    req.setAttribute("error", "Receiver Account could not found..!");
                    req.getRequestDispatcher("/transfer.jsp").forward(req, resp);
                }

            }

        } else {
            System.out.println("Your Account Could not found..!");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }

    }
}
