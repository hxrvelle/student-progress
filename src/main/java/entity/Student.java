package entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class Student {
    private int id;
    private String surname;
    private String name;
    private String group;
    private Date date;
    private int status;

    public Student() {
    }

    public Student(int studentId, String surname, String name, String group, Date date, int status) {
        this.id = studentId;
        this.surname = surname;
        this.name = name;
        this.group = group;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int studentId) {
        this.id = studentId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (status != student.status) return false;
        if (!Objects.equals(surname, student.surname)) return false;
        if (!Objects.equals(name, student.name)) return false;
        if (!Objects.equals(group, student.group)) return false;
        return Objects.equals(date, student.date);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + status;
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
