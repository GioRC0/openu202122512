package io.newschool.platform.u202122512.profile.application.internal.commandservices;

import io.newschool.platform.u202122512.profile.domain.model.aggregates.Student;
import io.newschool.platform.u202122512.profile.domain.model.commands.CreateStudentCommand;
import io.newschool.platform.u202122512.profile.domain.model.valueobjects.Dni;
import io.newschool.platform.u202122512.profile.domain.services.StudentCommandService;
import io.newschool.platform.u202122512.profile.infrastructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentCommandServiceImpl implements StudentCommandService {
    private StudentRepository studentRepository;

    public StudentCommandServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    @Override
    public Long handle(CreateStudentCommand command) {
        var dni = new Dni(command.dni());
        var student = studentRepository.findByDNI(dni);
        if (student.isEmpty()){
            var newStudent = new Student(command.dni(), command.streetAddress(), command.name(), command.gender(), command.birthdate(), command.specialty());
            this.studentRepository.save(newStudent);
            return newStudent.getDni();
        }
        throw new IllegalArgumentException("Student with dni " + dni.dni() + " already exists");
    }
}
