package az.hamburg.it.turbo.service.concrete;

import az.hamburg.it.turbo.dao.entity.LocationEntity;

import az.hamburg.it.turbo.dao.entity.UserEntity;
import az.hamburg.it.turbo.dao.repository.LocationRepository;

import az.hamburg.it.turbo.exception.NotFoundException;

import az.hamburg.it.turbo.model.request.LocationRequest;

import az.hamburg.it.turbo.model.response.LocationResponse;


import az.hamburg.it.turbo.model.response.UserResponse;
import az.hamburg.it.turbo.service.abstraction.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

import static az.hamburg.it.turbo.exception.ExceptionConstants.LOCATION_NOT_FOUND;

import static az.hamburg.it.turbo.mapper.LocationMapper.LOCATION_MAPPER;

import static az.hamburg.it.turbo.mapper.UserMapper.USER_MAPPER;
import static az.hamburg.it.turbo.model.enums.Status.DELETED;
import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class LocationServiceHandler implements LocationService {
    LocationRepository locationRepository;

    @Override
    public void saveLocation(LocationRequest request) {
        LocationEntity locationEntity = LOCATION_MAPPER.buildLocationEntity(request);
        locationRepository.save(locationEntity);
    }

    @Override
    public void deleteLocation(Long id) {
        LocationEntity locationEntity = fetchLocationIfExist(id);
        locationEntity.setStatus(DELETED);
        locationRepository.save(locationEntity);
    }

    @Override
    public LocationResponse getLocation(Long id) {
        LocationEntity locationEntity = fetchLocationIfExist(id);
        return LOCATION_MAPPER.buildLocationResponse(locationEntity);
    }

    @Override
    public void updateLocation(Long id, LocationRequest request) {
        LocationEntity locationEntity = fetchLocationIfExist(id);
        LOCATION_MAPPER.uptadeLocation(locationEntity, request);
        locationRepository.save(locationEntity);
    }

    @Override
    public List<LocationResponse> getAll() {
        return locationRepository.findAll()
                .stream()
                .map(LOCATION_MAPPER::buildLocationResponse)
                .toList();
    }

    private LocationEntity fetchLocationIfExist(Long id) {
        return locationRepository.findById(id).orElseThrow(() ->
                new NotFoundException(LOCATION_NOT_FOUND.getCode(), LOCATION_NOT_FOUND.getMessage()));
    }
}
