package az.hamburg.it.turbo.dao.entity;

import az.hamburg.it.turbo.model.enums.userEnums.Role;
import az.hamburg.it.turbo.model.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@EqualsAndHashCode(of = "id")
@Table(name = "users")
@FieldDefaults(level = PRIVATE)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @NotEmpty
    String name;

    @NotEmpty
    String surname;

    @NotEmpty
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    String email;

    @Pattern(regexp = "\\+994[0-9]{9}", message = "Phone number must start with +994 and contain 9 digits after.")
    String phoneNumber;

    @NotEmpty
    String password;

    @Enumerated(STRING)
    Status status;

    @Enumerated(STRING)
    Role role;

    String location;

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user", cascade = {PERSIST, MERGE})
    List<CarEntity> cars;
}