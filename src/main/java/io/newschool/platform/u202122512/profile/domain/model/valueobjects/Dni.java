package io.newschool.platform.u202122512.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Dni(Long dni) {
    public Dni(){this(0L);}

    public Dni {
        if (dni == 0L){
            throw new IllegalArgumentException("DNI cannot be 0");
        }
    }
}
