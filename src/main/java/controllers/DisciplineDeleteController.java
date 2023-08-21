package controllers;

import database.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="DisciplineDeleteController", urlPatterns = "/discipline-delete")
public class DisciplineDeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mass = req.getParameter("idsToDeleteHidden");
        String[] ids = mass.split(" ");
        DBManager manager = new DBManager();
        for (String id:ids) {
            manager.deleteDiscipline(Integer.parseInt(id));
        }
        resp.sendRedirect("/disciplines");
    }
}
