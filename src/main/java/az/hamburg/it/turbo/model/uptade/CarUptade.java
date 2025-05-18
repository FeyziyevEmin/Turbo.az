package az.hamburg.it.turbo.model.uptade;

import az.hamburg.it.turbo.model.enums.carEnums.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarUptade {
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
    BigDecimal price;
    CurrencyType currency;//$,azn
    Boolean barter;
    Boolean isDamaged;
    String vinCode;
    Integer owner;
    String description;

    Long userId;

}
