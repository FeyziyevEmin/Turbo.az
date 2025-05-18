package az.hamburg.it.turbo.model.response;

import az.hamburg.it.turbo.dao.entity.CarEntity;
import az.hamburg.it.turbo.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;
import java.util.List;
import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationResponse {
    Long id;
    String city;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Status status;
    List<CarEntity> car;
}
