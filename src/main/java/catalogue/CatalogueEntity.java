package catalogue;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@jakarta.persistence.Table(name = "Catalogue", schema = "public", catalog = "mip")
@IdClass(catalogue.CatalogueEntityPK.class)
public class CatalogueEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id_grade", nullable = false)
    private long idGrade;

    public long getIdGrade() {
        return idGrade;
    }

    public void setIdGrade(long idGrade) {
        this.idGrade = idGrade;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id_student", nullable = false)
    private long idStudent;

    public long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id_discipline", nullable = false)
    private long idDiscipline;

    public long getIdDiscipline() {
        return idDiscipline;
    }

    public void setIdDiscipline(long idDiscipline) {
        this.idDiscipline = idDiscipline;
    }

    @Basic
    @Column(name = "date", nullable = false)
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CatalogueEntity that = (CatalogueEntity) o;

        if (idGrade != that.idGrade) return false;
        if (idStudent != that.idStudent) return false;
        if (idDiscipline != that.idDiscipline) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idGrade ^ (idGrade >>> 32));
        result = 31 * result + (int) (idStudent ^ (idStudent >>> 32));
        result = 31 * result + (int) (idDiscipline ^ (idDiscipline >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
