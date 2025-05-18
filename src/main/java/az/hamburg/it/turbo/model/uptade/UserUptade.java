package az.hamburg.it.turbo.model.uptade;

import az.hamburg.it.turbo.model.enums.userEnums.Role;
import az.hamburg.it.turbo.model.response.CarResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class UserUptade {
    String name;
    String surname;
    String email;
    String phoneNumber;
    String password;
    Role role;
    String location;
    List<CarResponse> cars;
}
