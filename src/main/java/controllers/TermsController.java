package controllers;

import database.DBManager;
import entity.Discipline;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TermsController", urlPatterns = "/terms")
public class TermsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager manager = new DBManager();
        List<Term> terms = manager.getAllActiveTerm();

        Term selectedTerm;
        String duration;
        List<Discipline> disciplines;

        String idSelectedTerm = req.getParameter("idSelectedTerm");
        if (idSelectedTerm == null) {
            selectedTerm = terms.get(0);
            req.setAttribute("selectedTerm", selectedTerm);

            duration = terms.get(0).getDuration();
            req.setAttribute("duration", duration);

            disciplines = manager.getDisciplinesByTerm(terms.get(0).getId());
            req.setAttribute("disciplines", disciplines);
        } else {
            selectedTerm = manager.getTermById(idSelectedTerm);
            req.setAttribute("selectedTerm", selectedTerm);

            duration = manager.getTermById(idSelectedTerm).getDuration();
            req.setAttribute("duration", duration);

            disciplines = manager.getDisciplinesByTerm(Integer.parseInt(idSelectedTerm));
            req.setAttribute("disciplines", disciplines);
        }

        req.setAttribute("terms", terms);

        req.getRequestDispatcher("/WEB-INF/terms.jsp").forward(req, resp);
    }
}
