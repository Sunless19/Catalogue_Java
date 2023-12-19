package catalogue;

import jakarta.persistence.*;

@Entity
@Table(name = "Grade", schema = "public", catalog = "mip")
public class GradeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGrade", nullable = false)
    private long idGrade;

    @Basic
    @Column(name = "value", nullable = true)
    private int value;
}