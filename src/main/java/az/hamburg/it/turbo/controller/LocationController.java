package az.hamburg.it.turbo.controller;

import az.hamburg.it.turbo.model.request.LocationRequest;
import az.hamburg.it.turbo.model.response.LocationResponse;
import az.hamburg.it.turbo.service.abstraction.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("v1/locations")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class LocationController {
    LocationService locationService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void saveLocation(@RequestBody LocationRequest request){
        locationService.saveLocation(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public LocationResponse getLocation(@PathVariable Long id) {
        return locationService.getLocation(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateLocation(@PathVariable Long id, @RequestBody LocationRequest request) {
        locationService.updateLocation(id, request);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<LocationResponse> getAll() {
        return locationService.getAll();
    }
}
