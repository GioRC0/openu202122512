package io.newschool.platform.u202122512.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record StudentName(String name) {
    public StudentName(){this(null);}

    public StudentName{
        if (name == null){
            throw new IllegalArgumentException("Name can not be null");
        }
    }
}
