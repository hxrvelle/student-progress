package controllers;

import database.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentDeleteController", urlPatterns = "/student-delete")
public class StudentDeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mass = req.getParameter("idsToDeleteHidden");
        String[] ids = mass.split(" ");
        DBManager manager = new DBManager();
        for (String id:ids) {
            manager.deleteStudent(Integer.parseInt(id));
        }
        resp.sendRedirect("/students");
    }
}
