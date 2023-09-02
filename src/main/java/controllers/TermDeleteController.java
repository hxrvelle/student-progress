package controllers;

import database.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TermDeleteController", urlPatterns = "/term-delete")
public class TermDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idTermToDelete = req.getParameter("idTermToDelete");
        DBManager manager = new DBManager();

        manager.deleteTerm(Integer.parseInt(idTermToDelete));
        resp.sendRedirect("/terms");
    }
}
