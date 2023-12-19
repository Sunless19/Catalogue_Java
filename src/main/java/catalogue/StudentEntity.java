package catalogue;

import jakarta.persistence.*;

@Entity
@Table(name = "Student", schema = "public", catalog = "mip")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idStudent", nullable = false)
    private long idStudent;

    @Basic
    @Column(name = "name", nullable = true)
    private String name;
}