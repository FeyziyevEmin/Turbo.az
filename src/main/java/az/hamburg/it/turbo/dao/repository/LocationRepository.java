package az.hamburg.it.turbo.dao.repository;

import az.hamburg.it.turbo.dao.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationEntity,Long> {
}
