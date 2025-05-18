package az.hamburg.it.turbo.mapper;

import az.hamburg.it.turbo.dao.entity.ListingEntity;
import az.hamburg.it.turbo.dao.entity.UserEntity;
import az.hamburg.it.turbo.model.enums.Status;
import az.hamburg.it.turbo.model.request.ListingRequest;
import az.hamburg.it.turbo.model.response.ListingResponse;

import static az.hamburg.it.turbo.model.enums.Status.IN_PROGRESS;


public enum ListingMapper {
    LISTING_MAPPER;

    public ListingEntity buildListingEntity(ListingRequest request, UserEntity user) {
        return ListingEntity.builder()
                .title(request.getTitle())
                .status(Status.ACTIVE)
                .user(user)
                .build();
    }

    public ListingResponse buildListingResponse(ListingEntity listing) {
        return ListingResponse.builder()
                .id(listing.getId())
                .title(listing.getTitle())
                .createdAt(listing.getCreatedAt())
                .updatedAt(listing.getUpdatedAt())
                .status(listing.getStatus())
                .car(listing.getCar())
                .user(listing.getUser())
                .build();
    }

    public void uptadeListing(ListingEntity listingEntity, ListingRequest request) {
        listingEntity.setTitle(request.getTitle());
        listingEntity.getUser().setId(request.getUserId());
        listingEntity.setStatus(IN_PROGRESS);
    }
}
