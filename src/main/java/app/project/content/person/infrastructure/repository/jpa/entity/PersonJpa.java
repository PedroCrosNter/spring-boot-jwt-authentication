package app.project.content.person.infrastructure.repository.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "person")
@Getter
@Setter
public class PersonJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Long idPerson;

    @Column(name = "username", length = 10, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "company_email", nullable = false)
    private String companyEmail;

    @Column(name = "personal_email", nullable = false)
    private String personalEmail;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @Column(name = "created_date", nullable = false)
//    @Temporal(TemporalType.DATE)
    private LocalDate createdDate;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "termination_date")
//    @Temporal(TemporalType.DATE)
    private LocalDate terminationDate;
}