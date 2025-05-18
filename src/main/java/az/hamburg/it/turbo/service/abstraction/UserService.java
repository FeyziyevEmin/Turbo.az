package az.hamburg.it.turbo.service.abstraction;

import az.hamburg.it.turbo.model.request.UserRequest;
import az.hamburg.it.turbo.model.response.UserResponse;

import java.util.List;

public interface UserService {
    void saveUser(UserRequest request);

    void deleteUser(Long id);

    void updateUser(Long id, UserRequest user);

    UserResponse getUser(Long id);

    List<UserResponse> getAll();
}
