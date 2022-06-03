package ch.axa.university.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "faculty")
public class Faculty implements Serializable {

    @Id
    @Column(name = "faculty_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String description;

    @OneToMany(mappedBy="faculty")
    private List<Student> students;
}
