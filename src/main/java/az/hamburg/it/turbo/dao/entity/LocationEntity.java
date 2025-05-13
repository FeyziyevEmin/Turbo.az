package az.hamburg.it.turbo.dao.entity;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

public class LocationEntity {


    @OneToMany
    CarEntity car;
}
