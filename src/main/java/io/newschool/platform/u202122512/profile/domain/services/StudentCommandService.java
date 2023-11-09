package io.newschool.platform.u202122512.profile.domain.services;

import io.newschool.platform.u202122512.profile.domain.model.commands.CreateStudentCommand;

public interface StudentCommandService {
    Long handle(CreateStudentCommand command);
}
