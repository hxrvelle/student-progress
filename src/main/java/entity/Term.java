package entity;

import java.util.ArrayList;
import java.util.Objects;

public class Term {
    private int id;
    private String term;
    private String duration;
    private int status;
    private ArrayList<Discipline> disciplines = new ArrayList<>();

    public Term() {
    }

    public Term(int id, String term, String duration, int status) {
        this.id = id;
        this.term = term;
        this.duration = duration;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(ArrayList<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Term term1 = (Term) o;

        if (id != term1.id) return false;
        if (status != term1.status) return false;
        if (!Objects.equals(term, term1.term)) return false;
        if (!Objects.equals(duration, term1.duration)) return false;
        return Objects.equals(disciplines, term1.disciplines);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (disciplines != null ? disciplines.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Term{" +
                "id=" + id +
                ", term='" + term + '\'' +
                ", duration='" + duration + '\'' +
                ", status=" + status +
                ", disciplines=" + disciplines +
                '}';
    }
}
