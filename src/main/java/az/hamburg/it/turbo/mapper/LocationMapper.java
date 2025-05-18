package az.hamburg.it.turbo.mapper;

import az.hamburg.it.turbo.dao.entity.LocationEntity;
import az.hamburg.it.turbo.model.enums.Status;
import az.hamburg.it.turbo.model.request.LocationRequest;
import az.hamburg.it.turbo.model.response.LocationResponse;

public enum LocationMapper {
    LOCATION_MAPPER;

    public LocationEntity buildLocationEntity(LocationRequest request){
        return LocationEntity.builder()
                .city(request.getCity())
                .status(Status.ACTIVE)
//                .car(request.getCar())
                .build();
    }

    public LocationResponse buildLocationResponse(LocationEntity location){
        return LocationResponse.builder()
                .id(location.getId())
                .city(location.getCity())
                .createdAt(location.getCreatedAt())
                .updatedAt(location.getUpdatedAt())
                .status(location.getStatus())
                .car(location.getCar())
                .build();
    }

    public void uptadeLocation(LocationEntity locationEntity, LocationRequest request){
        locationEntity.setCity(request.getCity());
//        locationEntity.setCar(request.getCar());
        locationEntity.setStatus(Status.IN_PROGRESS);
    }
}
