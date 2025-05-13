package az.hamburg.it.turbo.dao.repository;

import az.hamburg.it.turbo.dao.entity.ListingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<ListingEntity, Long > {

}
