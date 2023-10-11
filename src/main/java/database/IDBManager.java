package database;

import entity.*;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public interface IDBManager {
    List<Student> getAllActiveStudents();

    void deleteStudent(int id);

    void createStudent(String surname, String name, String group, String date);

    Student getStudentById(int id);

    void modifyStudent(int id, String surname, String name, String group, String date);

    void setMark(String idStudent, String idTerm, String idDiscipline, String mark);
    void deleteMark(String idStudent, String idTerm, String idDiscipline, String mark);

    List<Term> getAllActiveTerm();
    Term getTermById(String id);

    void createTerm(String duration, String[] disciplines);

    void modifyTerm(String duration, String[] disciplines, int termId);

    void deleteTerm(int termId);

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
