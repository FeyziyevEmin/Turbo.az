package az.hamburg.it.turbo.controller;

import az.hamburg.it.turbo.model.request.RegisterRequest;
import az.hamburg.it.turbo.model.response.RegisterResponse;
import az.hamburg.it.turbo.service.abstraction.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/v1")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest){
        return authService.register(registerRequest);
    }
}
