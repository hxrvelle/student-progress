package database;

import entity.Discipline;
import entity.Student;
import entity.Term;

import java.sql.Date;
import java.util.List;

public interface IDBManager {
    List<Student> getAllActiveStudents();

    void deleteStudent(int id);

    void createStudent(String surname, String name, String group, Date date);

    Student getStudentById(int id);

    void modifyStudent(int id, String surname, String name, String group, Date date);

    List<Term> getAllActiveTerm();

    List<Discipline> getDisciplinesByTerm(int id);

    //TO получение оценок по десциплинам у студента

    List<Discipline> getAllActiveDisciplines();
}
