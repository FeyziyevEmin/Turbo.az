package az.hamburg.it.turbo.service.abstraction;
import az.hamburg.it.turbo.model.request.ListingRequest;
import az.hamburg.it.turbo.model.response.ListingResponse;
import java.util.List;

public interface ListingService {
    void saveListing(ListingRequest request);

    void deleteListing(Long id);

    ListingResponse getListing(Long id);

    void updateListing(Long id, ListingRequest request);

    List<ListingResponse> getAll();
}
