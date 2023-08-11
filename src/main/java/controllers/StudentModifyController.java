package controllers;

import database.DBManager;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name="StudentModifyController", urlPatterns = "/student-modify")
public class StudentModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("idToModifyHidden");
        DBManager manager = new DBManager();
        Student student = manager.getStudentById(Integer.parseInt(id));

        req.setAttribute("student", student);
        req.getRequestDispatcher("WEB-INF/student-modify.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String group = req.getParameter("group");
        String dateUser = req.getParameter("date");

        if (surname.equals("") || name.equals("") || group.equals("") || dateUser.equals("")) {
            req.setAttribute("message", "1");
            req.getRequestDispatcher("WEB-INF/student-modify.jsp").forward(req, resp);
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
        manager.modifyStudent(Integer.parseInt(id), surname, name, group, dateDataBase);
        resp.sendRedirect("/students");
    }
}
