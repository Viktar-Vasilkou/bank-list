package by.devincubator.banklist;

import by.devincubator.banklist.builder.impl.AccountBuilder;
import by.devincubator.banklist.builder.impl.UserBuilder;
import by.devincubator.banklist.connection.ConnectionFactory;
import by.devincubator.banklist.connection.config.DataBaseConfig;
import by.devincubator.banklist.connection.config.DataBaseConfigFactory;
import by.devincubator.banklist.dao.DaoHelper;
import by.devincubator.banklist.entity.User;
import by.devincubator.banklist.service.impl.AccountWorker;
import by.devincubator.banklist.service.impl.UserWorker;
import by.devincubator.banklist.utils.ResultPage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


public class SimpleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String title = "Result Page";

        DataBaseConfigFactory configFactory = new DataBaseConfigFactory();
        DataBaseConfig config = configFactory.createConfig();
        ConnectionFactory factory = new ConnectionFactory(config);

        try (Connection connection = factory.createConnection())
        {
            DaoHelper daoHelper = new DaoHelper(connection);

            String context = null;
            String action = request.getParameter("action");

            AccountWorker accountWorker = new AccountWorker(daoHelper, new AccountBuilder());
            UserWorker userWorker = new UserWorker(daoHelper, new UserBuilder());

            if ("sum".equals(action)) {
                context = String.valueOf(accountWorker.getAccountSum());
            }

            if ("richest".equals(action)) {
                Integer richestId = accountWorker.getRichestUserId();
                if (userWorker.getUserById(richestId).isPresent()) {
                    User user = userWorker.getUserById(richestId).get();
                    context = user.getFistName() + " " + user.getSecondName();
                }
            }

            writer.println(ResultPage.getPage(title, context));

            writer.close();
        } catch (Exception e){
            System.out.println(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
