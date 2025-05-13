package az.hamburg.it.turbo.service.concrete;

import az.hamburg.it.turbo.dao.entity.CarEntity;
import az.hamburg.it.turbo.dao.repository.CarRepository;
import az.hamburg.it.turbo.dao.repository.UserRepository;
import az.hamburg.it.turbo.exception.ExceptionConstants;
import az.hamburg.it.turbo.exception.NotFoundException;
import az.hamburg.it.turbo.mapper.CarMapper;
import az.hamburg.it.turbo.mapper.UserMapper;
import az.hamburg.it.turbo.model.enums.Status;
import az.hamburg.it.turbo.model.request.CreateOrUptadeCarRequest;
import az.hamburg.it.turbo.model.response.CarResponse;
import az.hamburg.it.turbo.model.response.UserResponse;
import az.hamburg.it.turbo.service.abstraction.CarService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

import static az.hamburg.it.turbo.exception.ExceptionConstants.CAR_NOT_FOUND;
import static az.hamburg.it.turbo.exception.ExceptionConstants.USER_NOT_FOUND;
import static az.hamburg.it.turbo.mapper.CarMapper.CAR_MAPPER;


@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CarServiceHandler implements CarService {
    CarRepository carRepository;
    UserRepository userRepository;

    @Override
    public void saveCar(CreateOrUptadeCarRequest request) {
        var userEntity = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new NotFoundException((USER_NOT_FOUND.getCode()), USER_NOT_FOUND.getMessage()));
        CarEntity carEntity= CAR_MAPPER.buildCarEntity(request, userEntity);
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
    public void updateCar(Long id, CreateOrUptadeCarRequest request) {
        CarEntity carEntity = fetchCarIfExist(id);
        CAR_MAPPER.uptadeCar(carEntity,request);
        carRepository.save(carEntity);
    }

    @Override
    public List<CarResponse> getAll() {
        return carRepository.findAll()
                .stream()
                .map(CAR_MAPPER::buildCarResponse)
                .toList();
    }

    private CarEntity fetchCarIfExist(Long id) {
        return carRepository.findById(id).orElseThrow(() ->
                new NotFoundException(CAR_NOT_FOUND.getCode(), CAR_NOT_FOUND.getMessage()));
    }
}
