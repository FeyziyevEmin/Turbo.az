package az.hamburg.it.turbo.service.concrete;

import az.hamburg.it.turbo.dao.entity.CarEntity;
import az.hamburg.it.turbo.dao.repository.CarRepository;
import az.hamburg.it.turbo.dao.repository.LocationRepository;
import az.hamburg.it.turbo.dao.repository.UserRepository;
import az.hamburg.it.turbo.exception.NotFoundException;
import az.hamburg.it.turbo.model.enums.Status;
import az.hamburg.it.turbo.model.request.CarRequest;
import az.hamburg.it.turbo.model.response.CarPageResponse;
import az.hamburg.it.turbo.model.response.CarResponse;
import az.hamburg.it.turbo.service.abstraction.CarService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import static az.hamburg.it.turbo.exception.ExceptionConstants.*;
import static az.hamburg.it.turbo.mapper.CarMapper.CAR_MAPPER;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CarServiceHandler implements CarService {
    CarRepository carRepository;
    UserRepository userRepository;
    LocationRepository locationRepository;
    @Override
    public void saveCar(CarRequest request) {
        var userEntity = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new NotFoundException((USER_NOT_FOUND.getCode()), USER_NOT_FOUND.getMessage()));
        var locationEntity = locationRepository.findById(request.getLocationId())
                .orElseThrow(()-> new NotFoundException((LOCATION_NOT_FOUND.getCode()),LOCATION_NOT_FOUND.getMessage()));
        var carEntity = CAR_MAPPER.buildCarEntity(request, userEntity, locationEntity);
        carRepository.save(carEntity);
    }

    @Override
    public void deleteCar(Long id) {
        CarEntity carEntity = fetchCarIfExist(id);
        carEntity.setStatus(Status.DELETED);
        carRepository.save(carEntity);
    }

    @Override
    public CarResponse getCar(Long id) {
        CarEntity carEntity = fetchCarIfExist(id);
        return CAR_MAPPER.buildCarResponse(carEntity);
    }

    @Override
    public void updateCar(Long id, CarRequest request) {
        CarEntity carEntity = fetchCarIfExist(id);
        CAR_MAPPER.updateCar(carEntity, request);
        carRepository.save(carEntity);
    }

    @Override
    public CarPageResponse getAll(int page, int count) {
        Page<CarEntity> pagedCar = carRepository.findAll(PageRequest.of(page, count));
        return new CarPageResponse(
                pagedCar.stream().map(CAR_MAPPER::buildCarResponse).toList(),
                pagedCar.getTotalElements(),
                pagedCar.getTotalPages(),
                pagedCar.hasNext());
    }

    private CarEntity fetchCarIfExist(Long id) {
        return carRepository.findById(id).orElseThrow(() ->
                new NotFoundException(CAR_NOT_FOUND.getCode(), CAR_NOT_FOUND.getMessage()));
    }
}
