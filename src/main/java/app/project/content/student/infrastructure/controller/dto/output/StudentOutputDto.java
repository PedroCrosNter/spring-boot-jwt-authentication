package app.project.content.student.infrastructure.controller.dto.output;

import app.project.shared.enums.Branch;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentOutputDto {


    @NonNull
    private Integer numHoursWeek;

    @NonNull
    private Branch branch;
}
