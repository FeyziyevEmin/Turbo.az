package az.hamburg.it.turbo.service.abstraction;

import az.hamburg.it.turbo.model.request.CarRequest;
import az.hamburg.it.turbo.model.request.LocationRequest;
import az.hamburg.it.turbo.model.response.CarResponse;
import az.hamburg.it.turbo.model.response.LocationResponse;

import java.util.List;

public interface LocationService {
    void saveLocation(LocationRequest request);

    void deleteLocation(Long id);

    LocationResponse getLocation(Long id);

    void updateLocation(Long id, LocationRequest request);

    List<LocationResponse> getAll();
}
