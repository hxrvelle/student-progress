package controllers;

import database.DBManager;
import entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet(name="StudentProgressController", urlPatterns = "/student-progress")
public class StudentProgressController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("idToProgressHidden");
        DBManager manager = new DBManager();
        Student student = manager.getStudentById(Integer.parseInt(id));
        List<Term> terms = manager.getAllActiveTerm();

        Term selectedTerm = null;
        String idSelectedTerm = req.getParameter("idSelectedTerm");
        if (idSelectedTerm == null) {
            selectedTerm = terms.get(0);
            req.setAttribute("selectedTerm", selectedTerm);
        } else {
            selectedTerm = manager.getTermById(idSelectedTerm);
            req.setAttribute("selectedTerm", selectedTerm);
        }

        req.setAttribute("student", student);
        req.setAttribute("terms", terms);

        List<Discipline> disciplines = manager.getDisciplinesByTerm(selectedTerm.getId());
        req.setAttribute("disciplines", disciplines);

        List<Mark> marks = manager.getMarksByStudentAndTerm(selectedTerm.getId()+"", student.getId()+"");
        while (marks.size() != disciplines.size()) {
            Mark mark = new Mark();
            marks.add(mark);
        }
        req.setAttribute("marks", marks);

        List<Integer> markNumbers = new ArrayList<>();
        for (int i = 0; i < marks.size(); i++) {
            if (marks.get(i).getMark() != 0) {
                markNumbers.add(marks.get(i).getMark());
            }
        }
        int sum = markNumbers.stream().mapToInt(Integer::intValue).sum();
        double middleMark = Math.floor(((float) sum / markNumbers.size()) * 100.0) / 100.0;

        req.setAttribute("middleMark", middleMark);

        req.getRequestDispatcher("WEB-INF/student-progress.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager manager = new DBManager();

        String studentId;
        String idSelectedTerm;

        String path = req.getHeader("referer");
        String[] pathParts = path.split("=");
        if (pathParts.length > 2) {
            String secondPart = pathParts[1];
            studentId = pathParts[2];
            String[] pathParts2 = secondPart.split("&");
            idSelectedTerm = pathParts2[0];
        } else {
            studentId = pathParts[1];
            idSelectedTerm = String.valueOf(1);
        }

        String disciplineId = req.getParameter("selectedDis");

        String mark = req.getParameter("mark");
        manager.setMark(studentId, idSelectedTerm, disciplineId, mark);

        resp.sendRedirect(path);
    }
}
