package io.newschool.platform.u202122512.profile.infrastructure.persistence.jpa.repositories;

import io.newschool.platform.u202122512.profile.domain.model.aggregates.Student;
import io.newschool.platform.u202122512.profile.domain.model.valueobjects.Dni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByDNI(Dni dni);
}
