package az.hamburg.it.turbo.model.request;

import az.hamburg.it.turbo.dao.entity.CarEntity;
import az.hamburg.it.turbo.dao.entity.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class ListingRequest {
    String title;
    CarRequest request;
    Long userId;
}
