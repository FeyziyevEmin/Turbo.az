package az.hamburg.it.turbo.service.abstraction;

import az.hamburg.it.turbo.model.request.CreateOrUptadeCarRequest;
import az.hamburg.it.turbo.model.response.CarResponse;
import java.util.List;

public interface CarService {
    void saveCar(CreateOrUptadeCarRequest request);

    void deleteCar(Long id);

    CarResponse getCar(Long id);

    void updateCar(Long id, CreateOrUptadeCarRequest request);

    List<CarResponse> getAll();
}
