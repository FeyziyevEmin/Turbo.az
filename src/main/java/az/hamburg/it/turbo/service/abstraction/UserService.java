package az.hamburg.it.turbo.service.abstraction;

import az.hamburg.it.turbo.model.request.CreateOrUptadeUserRequest;
import az.hamburg.it.turbo.model.response.UserResponse;

import java.util.List;

public interface UserService {
    void saveUser(CreateOrUptadeUserRequest request);

    void deleteUser(Long id);

    void updateUser(Long id, CreateOrUptadeUserRequest user);

    UserResponse getUser(Long id);

    List<UserResponse> getAll();
}
