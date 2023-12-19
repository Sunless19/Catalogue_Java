package catalogue;

import jakarta.persistence.*;

@Entity
@Table(name = "Discipline", schema = "public", catalog = "mip")
public class DisciplineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDiscipline", nullable = false)
    private long idDiscipline;

    @Basic
    @Column(name = "name", nullable = true)
    private String name;
}