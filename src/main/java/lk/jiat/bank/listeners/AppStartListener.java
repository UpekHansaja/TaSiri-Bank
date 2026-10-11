package lk.jiat.bank.listeners;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import lk.jiat.bank.model.Account;
import lk.jiat.bank.model.Transaction;
import lk.jiat.bank.model.User;

import java.util.HashMap;
import java.util.Map;

@WebListener
public class AppStartListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext context = sce.getServletContext();

        Map<String, User> users = new HashMap<>();
        Map<String, Account> accounts = new HashMap<>();
        Map<String, Transaction> transactions = new HashMap<>();

        users.put("upek", new User("upek", "123", "USER", "1111222233334444"));
        users.put("siri", new User("siri", "123", "USER", "5555666677778888"));
        users.put("admin", new User("admin", "123", "ADMIN", "0"));

        accounts.put("1111222233334444", new Account("1111222233334444", "upek", 1000));
        accounts.put("5555666677778888", new Account("5555666677778888", "siri", 1000));

        context.setAttribute("users", users);
        context.setAttribute("accounts", accounts);
        context.setAttribute("transactions", transactions);

        context.setAttribute("activeUsers", 0);

        System.out.println("TaSiri Banking Application deployed successfully..!");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("ServletContext Destroyed..!");

    }
}
