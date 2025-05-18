package az.hamburg.it.turbo.model.request;

import az.hamburg.it.turbo.model.enums.carEnums.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class CarRequest {
    @NotBlank
    String brand;

    @NotBlank
    String model;

    @NotBlank
    Integer year;

    @NotBlank
    BodyType bodyType;

    @NotBlank
    TransmissionType transmission;

    @NotBlank
    Integer horsePower;

    @NotBlank
    Double engineSize;

    @NotBlank
    Double mileage;

    @NotBlank
    DriveType drivetrain;

    @NotBlank
    FuelType fuelType;

    @NotBlank
    CarColor color;

    @NotBlank
    BigDecimal price;

    @NotBlank
    CurrencyType currency;//$,azn

    @NotBlank
    Boolean barter;

    @NotBlank
    Boolean isDamaged;

    @NotBlank
    String vinCode;

    @NotBlank
    Integer owner;

    @NotBlank
    String description;

    Long userId;
    Long locationId;
}
