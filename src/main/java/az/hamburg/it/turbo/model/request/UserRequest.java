package az.hamburg.it.turbo.model.request;

import az.hamburg.it.turbo.model.enums.userEnums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class UserRequest {
    @NotBlank
    String name;

    @NotBlank
    String surname;

    @NotBlank(message = "email can't be blank")
    @Email(regexp = "^[\\w.-]+@[\\w.-]+\\.(com|ru)$", message = "Email must end with .com or .ru")
    String email;

    @Pattern(regexp = "\\+994[0-9]{9}", message = "Phone number must start with +994 and contain 9 digits after.")
    String phoneNumber;

    @NotBlank
    String password;

    Role role;
    String location;
}