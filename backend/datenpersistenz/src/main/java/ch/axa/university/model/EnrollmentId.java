package ch.axa.university.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class EnrollmentId implements Serializable {

    private static final long serialVersionUID = -1289223640605767562L;
    @Column(name = "modul_IDFS", nullable = false)
    private Integer modulIdfs;

    @Column(name = "student_IDFS", nullable = false)
    private Integer studentIdfs;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EnrollmentId entity = (EnrollmentId) o;
        return Objects.equals(this.modulIdfs, entity.modulIdfs) &&
                Objects.equals(this.studentIdfs, entity.studentIdfs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modulIdfs, studentIdfs);
    }

}