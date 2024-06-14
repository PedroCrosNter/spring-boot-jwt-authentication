package app.project.content.person.infrastructure.controller.dto.input;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
//import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonCreateInputDto {

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

