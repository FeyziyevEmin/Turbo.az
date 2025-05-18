package az.hamburg.it.turbo.dao.entity;

import az.hamburg.it.turbo.model.enums.Status;
import az.hamburg.it.turbo.model.enums.carEnums.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "Status <> 'DELETED'")
@Entity
@EqualsAndHashCode(of = "id")
@Builder
@Table(name = "cars")
@FieldDefaults(level = PRIVATE)
public class CarEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String brand;

    String model;

    Integer year;

    @Enumerated(STRING)
    BodyType bodyType;

    @Enumerated(STRING)
    TransmissionType transmission;

    Integer horsePower;


    Double engineSize;

    Double mileage;

    @Enumerated(STRING)
    DriveType drivetrain;

    @Enumerated(STRING)
    FuelType fuelType;

    @Enumerated(STRING)
    CarColor color;

    @Enumerated(STRING)
    Status status;

    BigDecimal price;

    @Enumerated(STRING)
    CurrencyType currency;

    Boolean barter;

    Boolean isDamaged;

    String vinCode;

    Integer owner;

    String description;

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;

    @ManyToOne(fetch = LAZY, cascade = MERGE)
            @JsonBackReference
    UserEntity user;

    @ManyToOne(fetch = LAZY, cascade = MERGE)
            @JsonBackReference
    LocationEntity location;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "id")
            @JsonBackReference
    ListingEntity listing;

}
