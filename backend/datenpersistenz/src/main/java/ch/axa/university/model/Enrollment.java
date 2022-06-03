package ch.axa.university.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "enrollment")
@Getter
@Setter
public class Enrollment {
    @EmbeddedId
    private EnrollmentId id;

    @MapsId("modulIdfs")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "modul_IDFS", nullable = false)
    private Modul modulIdfs;

    @MapsId("studentIdfs")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_IDFS", nullable = false)
    private Student studentIdfs;

}