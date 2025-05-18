package az.hamburg.it.turbo.dao.entity;

import az.hamburg.it.turbo.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;
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
    Status status;

    @OneToOne(mappedBy = "listing", fetch = LAZY, cascade = {PERSIST, MERGE})
            @JsonBackReference
    CarEntity car;

    @ManyToOne(fetch = LAZY, cascade = MERGE)
     @JsonBackReference
    UserEntity user;
}
