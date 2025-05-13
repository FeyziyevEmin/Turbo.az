package az.hamburg.it.turbo.model.response;

import az.hamburg.it.turbo.dao.entity.CarEntity;
import az.hamburg.it.turbo.model.enums.Status;
import az.hamburg.it.turbo.model.enums.userEnums.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class UserResponse {
    Long id;
    String name;
    String surname;
    String email;
    String phoneNumber;
    String password;
    Status status;
    Role role;
    String location;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    List<CarEntity> cars;
}
