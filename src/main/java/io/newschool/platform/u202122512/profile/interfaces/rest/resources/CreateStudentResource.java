package io.newschool.platform.u202122512.profile.interfaces.rest.resources;

import java.time.LocalDate;

public record CreateStudentResource(
        Long dni,
        String streetAddress,
        String name,
        String gender,
        LocalDate birthdate,
        String specialty
) {
}
