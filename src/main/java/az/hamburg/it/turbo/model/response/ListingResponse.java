package az.hamburg.it.turbo.model.response;

import az.hamburg.it.turbo.dao.entity.CarEntity;
import az.hamburg.it.turbo.dao.entity.UserEntity;
import az.hamburg.it.turbo.model.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;
import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListingResponse {
    Long id;
    String title;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Status status;
    CarEntity car;
    UserEntity user;
}
