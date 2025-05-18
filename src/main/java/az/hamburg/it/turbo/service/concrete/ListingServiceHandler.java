package az.hamburg.it.turbo.service.concrete;

import az.hamburg.it.turbo.dao.entity.CarEntity;
import az.hamburg.it.turbo.dao.entity.ListingEntity;
import az.hamburg.it.turbo.dao.repository.ListingRepository;
import az.hamburg.it.turbo.dao.repository.UserRepository;
import az.hamburg.it.turbo.exception.NotFoundException;
import az.hamburg.it.turbo.model.enums.Status;
import az.hamburg.it.turbo.model.request.ListingRequest;
import az.hamburg.it.turbo.model.response.ListingResponse;
import az.hamburg.it.turbo.service.abstraction.ListingService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

import static az.hamburg.it.turbo.exception.ExceptionConstants.LISTING_NOT_FOUND;
import static az.hamburg.it.turbo.exception.ExceptionConstants.USER_NOT_FOUND;
import static az.hamburg.it.turbo.mapper.ListingMapper.LISTING_MAPPER;
import static az.hamburg.it.turbo.model.enums.Status.DELETED;
import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ListingServiceHandler implements ListingService {
    ListingRepository listingRepository;
    UserRepository userRepository;

    @Override
    public void saveListing(ListingRequest request) {

        var listingentity = ListingEntity.builder()
                .title(request.getTitle())
                .status(Status.ACTIVE)
                .build();

        var carEntity = CarEntity.builder()
                .listing(listingentity)
                .brand(request.getRequest().getBrand())
                .model(request.getRequest().getModel())
                .year(request.getRequest().getYear())
                .bodyType(request.getRequest().getBodyType())
                .transmission(request.getRequest().getTransmission())
                .horsePower(request.getRequest().getHorsePower())
                .engineSize(request.getRequest().getEngineSize())
                .mileage(request.getRequest().getMileage())
                .drivetrain(request.getRequest().getDrivetrain())
                .fuelType(request.getRequest().getFuelType())
                .color(request.getRequest().getColor())
                .price(request.getRequest().getPrice())
                .currency(request.getRequest().getCurrency())
                .barter(request.getRequest().getBarter())
                .isDamaged(request.getRequest().getIsDamaged())
                .vinCode(request.getRequest().getVinCode())
                .owner(request.getRequest().getOwner())
                .description(request.getRequest().getDescription())
//                .user(request.getUser().getUserId())
//                .location(request.getRequest().getLocationId())
                .build();

        listingentity.setCar(carEntity);

        var userEntity = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new NotFoundException((USER_NOT_FOUND.getCode()), USER_NOT_FOUND.getMessage()));
        ListingEntity listingEntity = LISTING_MAPPER.buildListingEntity(request, userEntity);
        listingRepository.save(listingEntity);
    }

    @Override
    public void deleteListing(Long id) {
        ListingEntity listingEntity = fetchListingIfExist(id);
        listingEntity.setStatus(DELETED);
        listingRepository.save(listingEntity);
    }

    @Override
    public void updateListing(Long id, ListingRequest request) {
        ListingEntity listingEntity = fetchListingIfExist(id);
        LISTING_MAPPER.uptadeListing(listingEntity, request);
        listingRepository.save(listingEntity);
    }

    @Override
    public ListingResponse getListing(Long id) {
        ListingEntity listingEntity = fetchListingIfExist(id);
        return LISTING_MAPPER.buildListingResponse(listingEntity);
    }

    @Override
    public List<ListingResponse> getAll() {
        return listingRepository.findAll()
                .stream()
                .map(LISTING_MAPPER::buildListingResponse)
                .toList();
    }

    private ListingEntity fetchListingIfExist(Long id) {
        return listingRepository.findById(id).orElseThrow(() ->
                new NotFoundException(LISTING_NOT_FOUND.getCode(), LISTING_NOT_FOUND.getMessage()));
    }
}
