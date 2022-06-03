package ch.axa.university.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany
    @JoinColumn(name = "faculty_IDFS")
    private Faculty faculty;

    @Column(name = "matriculation_number")
    private int matriculationNumber;

    private String firstname;
    private String lastname;
    private String street;
    private int zipcode;
    private String city;
    private String phone;

    @Column(name = "birthday_date")
    private Date date;
}
