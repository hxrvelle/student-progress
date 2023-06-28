package entity;

import java.util.Objects;

public class Mark {
    private int id;
    private Student student;
    private Term term;
    private Discipline discipline;
    private int mark;

    public Mark() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mark mark1 = (Mark) o;

        if (id != mark1.id) return false;
        if (mark != mark1.mark) return false;
        if (!Objects.equals(student, mark1.student)) return false;
        if (!Objects.equals(term, mark1.term)) return false;
        return Objects.equals(discipline, mark1.discipline);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (student != null ? student.hashCode() : 0);
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + (discipline != null ? discipline.hashCode() : 0);
        result = 31 * result + mark;
        return result;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", student=" + student +
                ", term=" + term +
                ", discipline=" + discipline +
                ", mark=" + mark +
                '}';
    }
}