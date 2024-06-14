package app.project.content.teacher.infrastructure.controller.dto.output;

import app.project.shared.enums.Branch;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeacherOutputDto {

    @NonNull
    private Long idTeacher;

    @NonNull
    private String comments;

    @NonNull
    private Branch branch;
}
