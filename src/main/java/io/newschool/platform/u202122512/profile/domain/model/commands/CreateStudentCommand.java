package io.newschool.platform.u202122512.profile.domain.model.commands;

import java.time.LocalDate;

public record CreateStudentCommand(
        Long dni,
        String streetAddress,
        String name,
        String gender,
        LocalDate birthdate,
        String specialty) {
}
