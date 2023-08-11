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

    List<Discipline> getDisciplinesByTerm(int id);

    //TO получение оценок по десциплинам у студента

    List<Discipline> getAllActiveDisciplines();

    List<Mark> getMarksByStudentAndTerm(String idTerm, String idStudent);
}
