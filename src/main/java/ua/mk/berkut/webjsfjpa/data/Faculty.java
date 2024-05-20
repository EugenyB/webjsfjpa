package ua.mk.berkut.webjsfjpa.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "faculty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "faculty_id_gen")
    @SequenceGenerator(name = "faculty_id_gen", sequenceName = "faculty_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "faculty")
    private Set<Student> students = new LinkedHashSet<>();

}