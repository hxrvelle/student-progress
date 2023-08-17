package controllers;

import database.DBManager;
import entity.Mark;
import entity.Student;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        List<Mark> marks = manager.getMarksByStudentAndTerm(selectedTerm.getId()+"", student.getId()+"");
        req.setAttribute("marks", marks);

        List<Integer> markNumbers = new ArrayList<>();
        for (int i = 0; i < marks.size(); i++) {
            markNumbers.add(marks.get(i).getMark());
        }
        int sum = markNumbers.stream().mapToInt(Integer::intValue).sum();
        double middleMark = Math.floor(((float) sum / markNumbers.size()) * 100.0) / 100.0;

        req.setAttribute("middleMark", middleMark);

        req.getRequestDispatcher("WEB-INF/student-progress.jsp").forward(req, resp);
    }
}
