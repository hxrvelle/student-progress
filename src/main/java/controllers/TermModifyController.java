package controllers;

import database.DBManager;
import entity.Discipline;
import entity.Student;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "TermModifyController", urlPatterns = "/term-modify")
public class TermModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("idTermToModify");

        DBManager manager = new DBManager();
        Term term = manager.getTermById(id);
        req.setAttribute("term", term);

        List<Discipline> allDisciplines = manager.getAllActiveDisciplines();
        req.setAttribute("allDisciplines", allDisciplines);

        List<Discipline> termDisciplines = manager.getDisciplinesByTerm(Integer.parseInt(id));
        req.setAttribute("termDisciplines", termDisciplines);

        req.getRequestDispatcher("WEB-INF/term-modify.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String duration = req.getParameter("duration");
        String[] disciplines = req.getParameterValues("disciplines");
        String termId = req.getParameter("id");

        if(disciplines == null || disciplines.length == 0 || duration.equals("")) {
            req.setAttribute("message", "1");
            req.getRequestDispatcher("WEB-INF/term-create.jsp").forward(req, resp);
            return;
        }

        DBManager manager = new DBManager();
        manager.modifyTerm(duration, disciplines, Integer.parseInt(termId));
        resp.sendRedirect("/terms");
    }
}
