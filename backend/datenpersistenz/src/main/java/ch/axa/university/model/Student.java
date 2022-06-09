package ch.axa.university.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "matriculation_number")
    private int matriculationNumber;

    private String firstname;
    private String lastname;
    private String street;
    private int zipcode;
    private String city;
    private String phone;

    @Column(name = "birthday_date")
    private Date birthdayDate;

    @ManyToOne()
    @JoinColumn(name="faculty_idfs")
    @JsonIgnore
    private Faculty faculty;

    @ManyToMany(mappedBy="students")
    private List<Modul> moduls;

}
