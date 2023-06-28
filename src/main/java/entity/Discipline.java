package entity;

import java.util.Objects;

public class Discipline {
    private int id;
    private String discipline;
    private int status;

    public Discipline() {
    }

    public Discipline(int id, String discipline, int status) {
        this.id = id;
        this.discipline = discipline;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getDiscipline() {
        return discipline;
    }

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discipline that = (Discipline) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        return Objects.equals(discipline, that.discipline);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (discipline != null ? discipline.hashCode() : 0);
        result = 31 * result + status;
        return result;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "id=" + id +
                ", discipline='" + discipline + '\'' +
                ", status=" + status +
                '}';
    }
}
