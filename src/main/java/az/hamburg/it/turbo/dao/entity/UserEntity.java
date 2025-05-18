package az.hamburg.it.turbo.dao.entity;

import az.hamburg.it.turbo.model.enums.userEnums.Role;
import az.hamburg.it.turbo.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Where(clause = "status <> 'DELETED'")
@EqualsAndHashCode(of = "id")
@Table(name = "users")
@FieldDefaults(level = PRIVATE)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String name;

    String surname;

    String email;

    String phoneNumber;

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
            @JsonBackReference
    List<CarEntity> cars;

    @OneToMany(mappedBy = "user", cascade = {PERSIST, MERGE})
            @JsonBackReference
    List<ListingEntity> listings;

    String username;
}