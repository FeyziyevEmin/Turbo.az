package az.hamburg.it.turbo.dao.entity;

import az.hamburg.it.turbo.model.enums.Status;
import az.hamburg.it.turbo.model.enums.carEnums.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.EAGER;
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
@Table(name = "cars")
@FieldDefaults(level = PRIVATE)
public class CarEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @NotBlank
    String brand;

    @NotBlank
    String model;

    Integer year;

    @Enumerated(STRING)
    @NotNull
    BodyType bodyType;

    @Enumerated(STRING)
    @NotNull
    TransmissionType transmission;

    @NotNull
    Integer horsePower;

    @Min(value = 50, message = "start from 50")
    @Max(value = 16000, message = "to 16000")
    Double engineSize;

    @NotNull
    Double mileage;

    @Enumerated(STRING)
    DriveType drivetrain;

    @Enumerated(STRING)
    @NotNull
    FuelType fuelType;

    @Enumerated(STRING)
    @NotNull
    CarColor color;

    Status status;

    @NotNull
    BigDecimal price;

    @NotBlank
    @Enumerated(STRING)
    CurrencyType currency;       //$,azn

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
    UserEntity user;

    @ManyToOne
    LocationEntity location;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "id")
    ListingEntity listing;
}