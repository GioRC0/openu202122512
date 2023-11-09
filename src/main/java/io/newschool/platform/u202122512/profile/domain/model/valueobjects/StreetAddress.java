package io.newschool.platform.u202122512.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record StreetAddress(String address) {
    public StreetAddress(){this(null);}

    public StreetAddress {
        if (address == null) {
            throw new IllegalArgumentException("Address can not be null");
        }
    }
}
