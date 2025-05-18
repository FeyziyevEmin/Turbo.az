package az.hamburg.it.turbo.service.abstraction;

import az.hamburg.it.turbo.model.request.RegisterRequest;
import az.hamburg.it.turbo.model.response.RegisterResponse;

public interface AuthService {
    RegisterResponse register(RegisterRequest registerRequest);
}
