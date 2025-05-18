package az.hamburg.it.turbo.controller;

import az.hamburg.it.turbo.model.request.ListingRequest;import az.hamburg.it.turbo.model.request.UserRequest;
import az.hamburg.it.turbo.model.response.ListingResponse;
import az.hamburg.it.turbo.service.abstraction.ListingService;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("v1/listings")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ListingController {
    ListingService listingService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void saveListing(@RequestBody ListingRequest request){
        listingService.saveListing(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteListing(@PathVariable Long id) {
        listingService.deleteListing(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public ListingResponse getResponse(@PathVariable Long id) {
        return listingService.getListing(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateListing(@PathVariable Long id, @RequestBody ListingRequest request) {
        listingService.updateListing(id, request);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<ListingResponse> getAll() {
        return listingService.getAll();
    }
}
