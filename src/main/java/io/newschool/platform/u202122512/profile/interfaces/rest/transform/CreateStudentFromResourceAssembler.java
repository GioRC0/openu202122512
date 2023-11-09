package io.newschool.platform.u202122512.profile.interfaces.rest.transform;

import io.newschool.platform.u202122512.profile.domain.model.commands.CreateStudentCommand;
import io.newschool.platform.u202122512.profile.interfaces.rest.resources.CreateStudentResource;

public class CreateStudentFromResourceAssembler {
    public static CreateStudentCommand toCommandFrom(CreateStudentResource resource){
        return new CreateStudentCommand(resource.dni(), resource.streetAddress(), resource.name(), resource.gender(), resource.birthdate(),resource.specialty());
    }
}
