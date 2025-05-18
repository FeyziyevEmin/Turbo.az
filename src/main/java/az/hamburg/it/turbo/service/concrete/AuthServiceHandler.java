package az.hamburg.it.turbo.service.concrete;

import az.hamburg.it.turbo.dao.entity.UserEntity;
import az.hamburg.it.turbo.dao.repository.UserRepository;
import az.hamburg.it.turbo.model.request.RegisterRequest;
import az.hamburg.it.turbo.model.response.RegisterResponse;
import az.hamburg.it.turbo.service.abstraction.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceHandler implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        if (userRepository.existsByUsername(registerRequest.getUserName())) {
            return new RegisterResponse("Username is taken");
        }

        UserEntity userEntity=new UserEntity();
        userEntity.setUsername(registerRequest.getUserName());
        userEntity.setPassword(encoder.encode(registerRequest.getPassword()));
        userRepository.save(userEntity);

        return new RegisterResponse("User registered successfully");
    }
}
