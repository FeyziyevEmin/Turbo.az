package az.hamburg.it.turbo.dao.entity;

import az.hamburg.it.turbo.model.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(of = "id")
@Builder
@Where(clause = "Status <> 'DELETED'")
@Table(name = "locations")
@FieldDefaults(level = PRIVATE)
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @Column(nullable = false)
    String city;

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;

    @Enumerated(STRING)
    Status status;

    @OneToMany(mappedBy = "location", cascade = {MERGE, PERSIST})
    List<CarEntity> car;

}
