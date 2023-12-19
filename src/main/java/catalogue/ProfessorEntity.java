package catalogue;

import jakarta.persistence.*;

@Entity
@Table(name = "Professor", schema = "public", catalog = "mip")
public class ProfessorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProfessor", nullable = false)
    private long idProfessor;

    @Basic
    @Column(name = "name", nullable = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_discipline", nullable = false)
    private DisciplineEntity discipline;
}