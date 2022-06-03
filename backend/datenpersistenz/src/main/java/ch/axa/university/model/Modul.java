package ch.axa.university.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "modul")
public class Modul implements Serializable {

    @Id
    @Column(name = "modul_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String shortname;
    private String title;
    private int ects_points;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name="ENROLLMENT",
            joinColumns={@JoinColumn(name="MODUL_IDFS",
                    referencedColumnName="MODUL_ID")},
            inverseJoinColumns={@JoinColumn(name="STUDENT_IDFS",
                    referencedColumnName="STUDENT_ID")})
    private List<Student> students;


}
