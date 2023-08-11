package database;

import constants.Constants;
import entity.Discipline;
import entity.Mark;
import entity.Student;
import entity.Term;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager implements IDBManager {
    String query;

    // Подключение к БД
    public Statement sqlConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(Constants.CONNECT_DB_URL);
        return connection.createStatement();
    }
    public ResultSet connect(String query) throws SQLException, ClassNotFoundException {
        return sqlConnection().executeQuery(query);
    }
    public void updateConnect(String query) throws SQLException, ClassNotFoundException {
        sqlConnection().executeUpdate(query);
    }
    public void voidConnect(String query) throws ClassNotFoundException, SQLException {
        sqlConnection().execute(query);
    }
    // Методы работы со студентами

    // Метод для getAllActiveStudents и getStudentById
    public void parseStudent(ResultSet rs, Student student) throws SQLException {
        student.setId(rs.getInt("id"));
        student.setSurname(rs.getString("surname"));
        student.setName(rs.getString("name"));
        student.setGroup(rs.getString("group"));
        student.setDate(rs.getDate("date"));
        student.setStatus(1);
    }

    @Override
    public List<Student> getAllActiveStudents() {
        ArrayList<Student> students = new ArrayList<>();
        query = "SELECT * FROM student WHERE status = 1;";
        try {
            ResultSet rs = connect(query);
            while (rs.next()) {
                Student student = new Student();
                parseStudent(rs, student);
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        Student student = new Student();
        query = "SELECT * FROM student WHERE id ='" + id + "';";
        try {
            ResultSet rs = connect(query);
            while (rs.next()) {
                parseStudent(rs, student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void createStudent(String surname, String name, String group, String date) {
        query = "INSERT INTO `student` (`surname`, `name`, `group`, `date`) VALUES ('" + surname + "', '" + name + "', '" + group + "', '" + date + "');";
        try {
            updateConnect(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyStudent(int id, String surname, String name, String group, String date) {
        query = "UPDATE `students`.`student` SET `surname` ='" + surname + "', `name` = '" + name + "', `group` ='" + group + "', `date` = '" + date + "' WHERE (`id` ='" + id + "');";
        try {
            updateConnect(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int id) {
        query = "UPDATE `student` SET `status` = '0' WHERE (`id` ='" + id + "');";
        try {
            voidConnect(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Методы работы с семестрами

    @Override
    public List<Term> getAllActiveTerm() {
        ArrayList<Term> terms = new ArrayList<>();
        query = "SELECT * FROM term WHERE status = 1;";
        try {
            ResultSet rs = connect(query);
            while (rs.next()) {
                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setTerm(rs.getString("term"));
                term.setDuration(rs.getString("duration"));
                term.setStatus(rs.getInt("status"));
                terms.add(term);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return terms;
    }

    // Методы работы с дисциплинами

    // Метод для getDisciplinesByTerm и getAllActiveDisciplines
    public List<Discipline> parseDiscipline(ArrayList<Discipline> disciplines) {
        try {
            ResultSet rs = connect(query);
            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDiscipline(rs.getString("discipline"));
                discipline.setStatus(rs.getInt("status"));
                disciplines.add(discipline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;
    }

    @Override
    public List<Discipline> getDisciplinesByTerm(int id) {
        ArrayList<Discipline> disciplines = new ArrayList<>();
        query = "SELECT * FROM discipline JOIN term_discipline on id_term WHERE id_term ='" + id + "' AND discipline.id = id_discipline;";
        return parseDiscipline(disciplines);
    }

    @Override
    public List<Discipline> getAllActiveDisciplines() {
        ArrayList<Discipline> disciplines = new ArrayList<>();
        query = "SELECT * FROM discipline WHERE status = 1;";
        return parseDiscipline(disciplines);
    }

    @Override
    public List<Mark> getMarksByStudentAndTerm(String idTerm, String idStudent) {
        List<Mark> marks = new ArrayList<>();

        return marks;
    }
}