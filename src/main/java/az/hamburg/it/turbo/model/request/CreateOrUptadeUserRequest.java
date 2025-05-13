package az.hamburg.it.turbo.model.request;

import az.hamburg.it.turbo.dao.entity.CarEntity;
import az.hamburg.it.turbo.model.enums.userEnums.Role;
import az.hamburg.it.turbo.model.response.CarResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrUptadeUserRequest {
    String name;
    String surname;
    String email;
    String phoneNumber;
    String password;
    Role role;
    String location;
    List<CarResponse> cars;
}
