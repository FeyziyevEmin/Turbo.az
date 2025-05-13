package az.hamburg.it.turbo.dao.entity;

import az.hamburg.it.turbo.model.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

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
@Table(name = "listings")
@FieldDefaults(level = PRIVATE)
public class ListingEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String title;

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;

    @Enumerated(STRING)
    private Status status;

    @OneToOne(mappedBy = "listing", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private CarEntity car;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private UserEntity user;
}
