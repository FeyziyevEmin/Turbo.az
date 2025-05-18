package az.hamburg.it.turbo.security;

import az.hamburg.it.turbo.dao.entity.UserEntity;
import az.hamburg.it.turbo.dao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findUserByUsername(username);
        return new org.springframework.security.core.userdetails.User(userEntity.getUsername(),userEntity.getPassword(), List.of(new SimpleGrantedAuthority("ADMIN")));
    }
}
