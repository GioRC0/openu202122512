package io.newschool.platform.u202122512.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;
import java.time.Period;
@Embeddable
public record BirthDate(LocalDate birthdate) {
    public BirthDate(){this(null);}

    public BirthDate {
        var actualDate = LocalDate.now();
        var yearDifference = Period.between(birthdate, actualDate).getYears();
        if (yearDifference < 18){
            throw new IllegalArgumentException("The student can not be a minor");
        }
    }
}
