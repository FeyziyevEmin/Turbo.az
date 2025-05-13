package az.hamburg.it.turbo.mapper;

import az.hamburg.it.turbo.dao.entity.CarEntity;
import az.hamburg.it.turbo.dao.entity.UserEntity;
import az.hamburg.it.turbo.model.enums.Status;
import az.hamburg.it.turbo.model.request.CreateOrUptadeCarRequest;
import az.hamburg.it.turbo.model.response.CarResponse;

public enum CarMapper {
    CAR_MAPPER;

    public CarEntity buildCarEntity(CreateOrUptadeCarRequest request, UserEntity user){
        return CarEntity.builder()
                .brand(request.getBrand())
                .model(request.getModel())
                .year(request.getYear())
                .bodyType(request.getBodyType())
                .transmission(request.getTransmission())
                .horsePower(request.getHorsePower())
                .engineSize(request.getEngineSize())
                .mileage(request.getMileage())
                .drivetrain(request.getDrivetrain())
                .fuelType(request.getFuelType())
                .color(request.getColor())
                .price(request.getPrice())
                .currency(request.getCurrency())
                .barter(request.getBarter())
                .isDamaged(request.getIsDamaged())
                .vinCode(request.getVinCode())
                .owner(request.getOwner())
                .description(request.getDescription())
                .user(user)
                .build();
    }

    public CarResponse buildCarResponse(CarEntity car){
        return CarResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .year(car.getYear())
                .bodyType(car.getBodyType())
                .transmission(car.getTransmission())
                .horsePower(car.getHorsePower())
                .engineSize(car.getEngineSize())
                .mileage(car.getMileage())
                .drivetrain(car.getDrivetrain())
                .fuelType(car.getFuelType())
                .color(car.getColor())
                .status(car.getStatus())
                .price(car.getPrice())
                .currency(car.getCurrency())
                .barter(car.getBarter())
                .isDamaged(car.getIsDamaged())
                .vinCode(car.getVinCode())
                .owner(car.getOwner())
                .description(car.getDescription())
                .createdAt(car.getCreatedAt())
                .updatedAt(car.getUpdatedAt())
                .user(car.getUser())
                .build();
    }

    public void uptadeCar(CarEntity carEntity, CreateOrUptadeCarRequest request){
        carEntity.setBrand(request.getBrand());
        carEntity.setModel(request.getModel());
        carEntity.setYear(request.getYear());
        carEntity.setBodyType(request.getBodyType());
        carEntity.setTransmission(request.getTransmission());
        carEntity.setHorsePower(request.getHorsePower());
        carEntity.setEngineSize(request.getEngineSize());
        carEntity.setMileage(request.getMileage());
        carEntity.setDrivetrain(request.getDrivetrain());
        carEntity.setFuelType(request.getFuelType());
        carEntity.setColor(request.getColor());
        carEntity.setPrice(request.getPrice());
        carEntity.setCurrency(request.getCurrency());
        carEntity.setBarter(request.getBarter());
        carEntity.setIsDamaged(request.getIsDamaged());
        carEntity.setVinCode(request.getVinCode());
        carEntity.setOwner(request.getOwner());
        carEntity.setDescription(request.getDescription());

        carEntity.setStatus(Status.IN_PROGRESS);
//        carEntity.setUser(request.getUser());
    }
}
