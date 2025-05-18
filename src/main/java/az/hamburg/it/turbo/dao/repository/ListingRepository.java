package az.hamburg.it.turbo.dao.repository;

import az.hamburg.it.turbo.dao.entity.ListingEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ListingRepository extends JpaRepository<ListingEntity, Long > {

    @EntityGraph(attributePaths = {"car", "user"})
    Optional<ListingEntity> findById(Long id);
}
