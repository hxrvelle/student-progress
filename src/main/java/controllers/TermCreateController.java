package controllers;

import database.DBManager;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TermCreateController", urlPatterns = "/term-create")
public class TermCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager manager = new DBManager();
        List<Discipline> disciplines = manager.getAllActiveDisciplines();
        req.setAttribute("disciplines", disciplines);

        req.getRequestDispatcher("WEB-INF/term-create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String duration = req.getParameter("duration");
        String[] disciplines = req.getParameterValues("disciplines");

        if(disciplines == null || disciplines.length == 0 || duration.equals("")) {
            req.setAttribute("message", "1");
            req.getRequestDispatcher("WEB-INF/term-create.jsp").forward(req, resp);
            return;
        }

        if (duration.length() > 1 ) {
            String lastDigit = duration.substring(duration.length() - 1);
            if (Integer.parseInt(lastDigit) == 0 || Integer.parseInt(lastDigit) == 5 || Integer.parseInt(lastDigit) == 6 ||
                    Integer.parseInt(lastDigit) == 7 || Integer.parseInt(lastDigit) == 8 || Integer.parseInt(lastDigit) == 9 ||
                    Integer.parseInt(duration) == 11 ||Integer.parseInt(duration) == 12 || Integer.parseInt(duration) == 13 ||
                    Integer.parseInt(duration) == 14 || Integer.parseInt(duration) == 15 || Integer.parseInt(duration) == 16 ||
                    Integer.parseInt(duration) == 17 || Integer.parseInt(duration) == 18 || Integer.parseInt(duration) == 19 ||
                    Integer.parseInt(duration) == 20) {
                duration = duration + " недель";
            } else if (Integer.parseInt(lastDigit) == 1 && (Integer.parseInt(duration) != 11)) {
                duration = duration + " неделя";
            } else if (Integer.parseInt(lastDigit) == 2 && (Integer.parseInt(duration) != 12) || Integer.parseInt(lastDigit) == 3 && (Integer.parseInt(duration)) != 13 ||
                    Integer.parseInt(lastDigit) == 4 && (Integer.parseInt(duration) != 14)) {
                duration = duration + " недели";
            }
        } else if (duration.length() == 1) {
            if (Integer.parseInt(duration) == 0 || Integer.parseInt(duration) == 5 || Integer.parseInt(duration) == 6 ||
                    Integer.parseInt(duration) == 7 || Integer.parseInt(duration) == 8 || Integer.parseInt(duration) == 9 ) {
                duration = duration + " недель";
            } else if (Integer.parseInt(duration) == 1) {
                duration = duration + " неделя";
            } else {
                duration = duration + " недели";
            }
        }

        DBManager manager = new DBManager();
        manager.createTerm(duration, disciplines);
        resp.sendRedirect("/terms");
    }
}
