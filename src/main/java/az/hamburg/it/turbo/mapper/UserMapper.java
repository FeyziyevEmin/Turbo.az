package az.hamburg.it.turbo.mapper;

import az.hamburg.it.turbo.dao.entity.UserEntity;
import az.hamburg.it.turbo.model.enums.Status;
import az.hamburg.it.turbo.model.request.CreateOrUptadeUserRequest;
import az.hamburg.it.turbo.model.response.UserResponse;

public enum UserMapper {
    USER_MAPPER;

    public UserEntity buildUserEntity(CreateOrUptadeUserRequest request){
        return UserEntity.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .password(request.getPassword())
                .role(request.getRole())
                .location(request.getLocation())
                .status(Status.ACTIVE)
                .cars(request.getCars())
                .build();
    }

    public UserResponse buildUserResponse(UserEntity user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .password(user.getPassword())
                .status(user.getStatus())
                .role(user.getRole())
                .location(user.getLocation())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    public void uptadeUser(UserEntity userEntity, CreateOrUptadeUserRequest request){
        userEntity.setName(request.getName());
        userEntity.setSurname(request.getSurname());
        userEntity.setEmail(request.getEmail());
        userEntity.setPhoneNumber(request.getPhoneNumber());
        userEntity.setPassword(request.getPassword());
        userEntity.setLocation(request.getLocation());
        userEntity.setStatus(Status.IN_PROGRESS);
    }
}
