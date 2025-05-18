package az.hamburg.it.turbo.model.uptade;

import az.hamburg.it.turbo.dao.entity.CarEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class LocationUptade {
    String city;
    List<CarEntity> car;
}
