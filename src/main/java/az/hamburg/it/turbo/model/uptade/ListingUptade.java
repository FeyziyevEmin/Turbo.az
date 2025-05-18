package az.hamburg.it.turbo.model.uptade;

import az.hamburg.it.turbo.dao.entity.CarEntity;
import az.hamburg.it.turbo.dao.entity.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ListingUptade {
    String title;
    CarEntity car;
    UserEntity user;
}
