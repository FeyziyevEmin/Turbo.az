package az.hamburg.it.turbo.service.concrete;

import az.hamburg.it.turbo.dao.entity.UserEntity;
import az.hamburg.it.turbo.dao.repository.UserRepository;
import az.hamburg.it.turbo.exception.NotFoundException;
import az.hamburg.it.turbo.mapper.UserMapper;
import az.hamburg.it.turbo.model.request.CreateOrUptadeUserRequest;
import az.hamburg.it.turbo.model.response.UserResponse;
import az.hamburg.it.turbo.service.abstraction.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

import static az.hamburg.it.turbo.exception.ExceptionConstants.USER_NOT_FOUND;
import static az.hamburg.it.turbo.mapper.UserMapper.USER_MAPPER;
import static az.hamburg.it.turbo.model.enums.Status.DELETED;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserServiceHandler implements UserService {
    UserRepository userRepository;

    @Override
    public void saveUser(CreateOrUptadeUserRequest request) {
        UserEntity userEntity = USER_MAPPER.buildUserEntity(request);
        userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(Long id) {
        UserEntity userEntity = fetchUserIfExist(id);
        userEntity.setStatus(DELETED);
        userRepository.save(userEntity);
    }

    @Override
    public void updateUser(Long id, CreateOrUptadeUserRequest request) {
        UserEntity userEntity = fetchUserIfExist(id);
        USER_MAPPER.uptadeUser(userEntity, request);
        userRepository.save(userEntity);
    }

    @Override
    public UserResponse getUser(Long id) {
        UserEntity userEntity = fetchUserIfExist(id);
        return USER_MAPPER.buildUserResponse(userEntity);
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(USER_MAPPER::buildUserResponse)
                .toList();
    }

    private UserEntity fetchUserIfExist(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new NotFoundException(USER_NOT_FOUND.getCode(), USER_NOT_FOUND.getMessage()));
    }
}
