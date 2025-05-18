package az.hamburg.it.turbo.service.abstraction;

import az.hamburg.it.turbo.model.request.CarRequest;
import az.hamburg.it.turbo.model.response.CarPageResponse;
import az.hamburg.it.turbo.model.response.CarResponse;
import java.util.List;

public interface CarService {
    void saveCar(CarRequest request);

    void deleteCar(Long id);

    CarResponse getCar(Long id);

    void updateCar(Long id, CarRequest request);

    CarPageResponse getAll(int page, int count);
}
