package app.project.content.person.infrastructure.controller.dto.output;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class PersonOutputDto {

    @NonNull
    private Long idPerson;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String name;

    private String surname;

    @NonNull
    // TODO ver más anotaciones @Email @Size(max = 50)
    private String companyEmail;

    @NonNull
    private String personalEmail;

    @NonNull
    private String city;

    @NotNull
    private Boolean active;

    @NotNull
    private LocalDate createdDate;

    private String imageUrl;

    private LocalDate terminationDate;
}
