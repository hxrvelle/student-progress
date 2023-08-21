package database;

import entity.Discipline;
import entity.Student;
import entity.Term;
import entity.Mark;

import java.sql.Date;
import java.util.List;

public interface IDBManager {
    List<Student> getAllActiveStudents();

    void deleteStudent(int id);

    void createStudent(String surname, String name, String group, String date);

    Student getStudentById(int id);

    void modifyStudent(int id, String surname, String name, String group, String date);

    List<Term> getAllActiveTerm();
    Term getTermById(String id);

    List<Discipline> getDisciplinesByTerm(int id);

    //TO получение оценок по десциплинам у студента

    List<Discipline> getAllActiveDisciplines();

    Discipline getDisciplineById(int id);

    void createDiscipline(String discipline);

    void modifyDiscipline(String discipline, int id);

    void deleteDiscipline(int id);

    List<Mark> getMarksByStudentAndTerm(String idTerm, String idStudent);

    boolean canLogin(String login, String password, String role);
}
