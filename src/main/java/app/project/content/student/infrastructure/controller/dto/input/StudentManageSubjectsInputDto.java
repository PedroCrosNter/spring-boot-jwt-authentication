package app.project.content.student.infrastructure.controller.dto.input;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentManageSubjectsInputDto {

    @NonNull
    private Long idStudent;

    @NonNull
    private List<Long> idsSubjects;
}
