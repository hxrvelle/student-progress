package database;

import entity.Discipline;
import entity.Student;
import entity.Term;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DBManager manager = new DBManager();

//        СТУДЕНТЫ

//        Получение даты для методов
        String dateString = "2011-09-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date sqlDate = null;
        try {
            java.util.Date date = sdf.parse(dateString);
            sqlDate = new Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }


//        Получение всех активных студентов
//        List<Student> students = manager.getAllActiveStudents();
//        for (Student st:students) {
//            System.out.println(st);
//        }

//        Получение студента по id
//        Student student = manager.getStudentById(7);
//        System.out.println(student);

//        Создание студента
//        manager.createStudent("Рожнов", "Николай", "КТ-21", sqlDate);

//        Редактирование студента
//        manager.modifyStudent(7,"Борисов", "Борис", "КТ-21", sqlDate);

//        Удаление студента
//        manager.deleteStudent(4);


//        СЕМЕСТРЫ

//        Получение всех активных семестров
        List<Term> terms = manager.getAllActiveTerm();
        for (Term t:terms) {
            System.out.println(t);
        }

//        ДИСЦИПЛИНЫ

//        Получение всех активных дисциплин
//        List<Discipline> disciplines = manager.getAllActiveDisciplines();
//        for (Discipline d:disciplines) {
//            System.out.println(d);
//        }

//        Получение всех дисциплин по семестру
//        List<Discipline> disciplines1 = manager.getDisciplinesByTerm(1);
//        for (Discipline d:disciplines1) {
//            System.out.println(d);
//        }
    }
}
