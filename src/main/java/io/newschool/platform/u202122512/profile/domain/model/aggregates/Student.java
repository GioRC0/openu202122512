package io.newschool.platform.u202122512.profile.domain.model.aggregates;

import io.newschool.platform.u202122512.profile.domain.model.valueobjects.BirthDate;
import io.newschool.platform.u202122512.profile.domain.model.valueobjects.Dni;
import io.newschool.platform.u202122512.profile.domain.model.valueobjects.StreetAddress;
import io.newschool.platform.u202122512.profile.domain.model.valueobjects.StudentName;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Student extends AbstractAggregateRoot<Student> {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Dni DNI;
    @Embedded
    private StreetAddress streetAddress;
    @Embedded
    private StudentName name;
    @Embedded
    private BirthDate birthdate;
    private String gender;
    private String specialty;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    public Student(){}
    public Student(Long dni, String streetAddress, String name, String gender, LocalDate birthdate, String specialty){
        this.DNI = new Dni(dni);
        this.name = new StudentName(name);
        this.streetAddress = new StreetAddress(streetAddress);
        this.validateGender(gender);
        this.gender = gender;
        this.birthdate = new BirthDate(birthdate);
        this.specialty = specialty;
    }

    public void validateGender(String gender){
        if (gender.equals("Male") || gender.equals("Female")){
            return;
        };
        throw new IllegalArgumentException("Gender can not be different of male or female");
    }

    public Long getDni(){
        return this.DNI.dni();
    }
}