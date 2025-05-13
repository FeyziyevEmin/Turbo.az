package az.hamburg.it.turbo.model.response;

import az.hamburg.it.turbo.dao.entity.UserEntity;
import az.hamburg.it.turbo.model.enums.Status;
import az.hamburg.it.turbo.model.enums.carEnums.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarResponse {
    Long id;
    String brand;
    String model;
    Integer year;
    BodyType bodyType;
    TransmissionType transmission;
    Integer horsePower;
    Double engineSize;
    Double mileage;
    DriveType drivetrain;
    FuelType fuelType;
    CarColor color;
    Status status;
    BigDecimal price;
    CurrencyType currency;//$,azn
    Boolean barter;
    Boolean isDamaged;
    String vinCode;
    Integer owner;
    String description;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    UserEntity user;
}
