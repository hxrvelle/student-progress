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

    @Override
    public Term getTermById(String id) {
        query = "SELECT * FROM term WHERE id ='" + id + "';";
        try {
            ResultSet rs = connect(query);
            while (rs.next()) {
                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setTerm(rs.getString("term"));
                term.setDuration(rs.getString("duration"));
                return term;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createTerm(String duration, String[] disciplines) {
        String query1 = "SELECT term FROM term ORDER BY id DESC LIMIT 1;";
        String lastTermName = "";
        try {
            ResultSet rs = connect(query1);
            while (rs.next()) {
                lastTermName = rs.getString("term");
            }
            String[] partsOfLastName = lastTermName.split(" ");
            int numOfTerm = Integer.parseInt(partsOfLastName[1]);
            numOfTerm++;

            String query2 = "INSERT INTO `term` (`term`, `duration`) VALUES ('Семестр " + numOfTerm + "', '"+duration+"');";
            updateConnect(query2);

            String query3 = "SELECT id FROM term ORDER BY id DESC LIMIT 1;";
            rs = connect(query3);
            int newTermId = 0;
            while (rs.next()) {
                newTermId = rs.getInt("id");
            }

            for (String idDis:disciplines) {
                String query4 = "INSERT INTO `term_discipline` (`id_term`, `id_discipline`) VALUES ('"+newTermId+"', '"+idDis+"');";
                updateConnect(query4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyTerm(String duration, String[] disciplines, int termId) {
        query = "UPDATE `term` SET `duration` = '" + duration + "' WHERE (`id` ='" + termId + "');";
        try {
            updateConnect(query);

            String query1 = "SELECT * FROM term_discipline WHERE (`id_term` = '" + termId + "');";
            ArrayList<String> ids = new ArrayList<>();
            ResultSet rs = connect(query1);
            while (rs.next()) {
                ids.add(rs.getString("id"));
            }

            for (String id:ids) {
                String query2 = "DELETE FROM `mark` WHERE (`id_term_discipline` = '" + id + "');";
                voidConnect(query2);
            }
            
            String query3 = "DELETE FROM `term_discipline` WHERE (`id_term` = '" + termId + "');";
            voidConnect(query3);

            for (String idDis:disciplines) {
                String query4 = "INSERT INTO `term_discipline` (`id_term`, `id_discipline`) VALUES ('" + termId + "', '" + idDis + "');";
                updateConnect(query4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTerm(int termId) {
        query = "UPDATE `term` SET `status` = '0' WHERE (`id` ='" + termId + "');";
        try {
            voidConnect(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
        query = "SELECT * FROM discipline JOIN term_discipline on id_term WHERE id_term ='" + id + "' AND discipline.id = id_discipline AND discipline.status = 1;";
        return parseDiscipline(disciplines);
    }

    @Override
    public List<Discipline> getAllActiveDisciplines() {
        ArrayList<Discipline> disciplines = new ArrayList<>();
        query = "SELECT * FROM discipline WHERE status = 1;";
        return parseDiscipline(disciplines);
    }

    @Override
    public Discipline getDisciplineById(int id) {
        query = "SELECT * FROM discipline WHERE id ='" + id + "';";
        try {
            ResultSet rs = connect(query);
            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDiscipline(rs.getString("discipline"));
                return discipline;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createDiscipline(String discipline) {
        query = "INSERT INTO `discipline` (`discipline`) VALUES ('" + discipline + "');";
        try {
            updateConnect(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyDiscipline(String discipline, int id) {
        query = "UPDATE `discipline` SET `discipline` ='" + discipline + "' WHERE (`id` ='" + id + "');";
        try {
            updateConnect(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDiscipline(int id) {
        query = "UPDATE `discipline` SET `status` = '0' WHERE (`id` ='" + id + "');";
        try {
            voidConnect(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Mark> getMarksByStudentAndTerm(String idTerm, String idStudent) {
        List<Mark> marks = new ArrayList<>();
        query = "SELECT m.id, m.mark, d.id as id_disc, d.discipline FROM mark as m\n" +
                "left join term_discipline as td on m.id_term_discipline = td.id\n" +
                "left join discipline as d on td.id_discipline = d.id\n" +
                "where m.id_student = " + idStudent + " and td.id_term = " + idTerm + " and d.status = 1";
        try {
            ResultSet rs = connect(query);
            while (rs.next()) {
                Mark mark = new Mark();
                mark.setId(rs.getInt("id"));
                mark.setMark(rs.getInt("mark"));
                mark.setId(rs.getInt("id"));

                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id_disc"));
                discipline.setDiscipline(rs.getString("discipline"));
                mark.setDiscipline(discipline);

                marks.add(mark);
            }

            if (marks.size() == 0 ) {
                String query1 = "SELECT term_discipline.id_discipline, discipline.discipline FROM term_discipline JOIN discipline on discipline.id = term_discipline.id_discipline WHERE term_discipline.id_term = " + idTerm + " AND discipline.status = 1;";
                rs = connect(query1);
                while (rs.next()) {
                    Mark mark = new Mark();
                    mark.setId(-1);
                    mark.setMark(-1);

                    Discipline discipline = new Discipline();
                    discipline.setId(rs.getInt("id_discipline"));
                    discipline.setDiscipline(rs.getString("discipline"));
                    mark.setDiscipline(discipline);

                    marks.add(mark);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return marks;
    }

    @Override
    public boolean canLogin(String login, String password, String role) {
        query = "SELECT * FROM user_role AS ur LEFT JOIN user AS u ON ur.id_user = u.id WHERE ur.id_role = '" + role + "' AND u.login = '" + login + "' AND u.password = '" + password + "';";
        try {
            ResultSet rs = connect(query);
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}