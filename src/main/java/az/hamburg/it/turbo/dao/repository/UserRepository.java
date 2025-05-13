package az.hamburg.it.turbo.dao.repository;

import az.hamburg.it.turbo.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
