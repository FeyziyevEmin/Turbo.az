package az.hamburg.it.turbo.dao.repository;

import az.hamburg.it.turbo.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findUserByUsername(String username);
    Boolean existsByUsername(String userName);
}
