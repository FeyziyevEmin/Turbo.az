package az.hamburg.it.turbo.controller;

import az.hamburg.it.turbo.model.request.UserRequest;
import az.hamburg.it.turbo.model.response.UserResponse;
import az.hamburg.it.turbo.service.abstraction.UserService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/v1/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserController {
    UserService userService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void saveUser(@RequestBody UserRequest request){
        userService.saveUser(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public UserResponse getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateUser(@PathVariable Long id, @RequestBody UserRequest request) {
        userService.updateUser(id, request);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<UserResponse> getAll() {
        return userService.getAll();
    }
}
