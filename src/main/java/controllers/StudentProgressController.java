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
import java.util.List;

@WebServlet(name="StudentProgressController", urlPatterns = "/student-progress")
public class StudentProgressController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("idToProgressHidden");
        DBManager manager = new DBManager();
        Student student = manager.getStudentById(Integer.parseInt(id));
        List<Term> terms = manager.getAllActiveTerm();

        Term selectedTerm = new Term();
        if (terms.size() != 0) {
            selectedTerm = terms.get(0);
            req.setAttribute("selectedTerm", selectedTerm);
        }

        req.setAttribute("student", student);
        req.setAttribute("terms", terms);

        List<Mark> marks = manager.getMarksByStudentAndTerm(selectedTerm.getId()+"", student.getId()+"");
        req.setAttribute("marks", marks);

        req.getRequestDispatcher("WEB-INF/student-progress.jsp").forward(req, resp);
    }
}
