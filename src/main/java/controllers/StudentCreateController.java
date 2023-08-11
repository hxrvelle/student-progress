package controllers;

import database.DBManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="StudentCreateController", urlPatterns = "/student-create")
public class StudentCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/student-create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String group = req.getParameter("group");
        String dateUser = req.getParameter("date");

        if (surname.equals("") || name.equals("") || group.equals("") || dateUser.equals("")) {
            req.setAttribute("message", "1");
            req.getRequestDispatcher("WEB-INF/student-create.jsp").forward(req, resp);
            return;
        }

        SimpleDateFormat dt = new SimpleDateFormat("dd/mm/yyyy");
        Date date;
        try {
            date = dt.parse(dateUser);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-mm-dd");
        String dateDataBase = dt1.format(date);

        DBManager manager = new DBManager();
        manager.createStudent(surname, name, group, dateDataBase);
        resp.sendRedirect("/students");
    }
}
