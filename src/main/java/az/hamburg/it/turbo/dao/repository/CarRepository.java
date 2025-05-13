package az.hamburg.it.turbo.dao.repository;

import az.hamburg.it.turbo.dao.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
}
