package az.hamburg.it.turbo.controller;

import az.hamburg.it.turbo.model.request.CreateOrUptadeCarRequest;
import az.hamburg.it.turbo.model.response.CarResponse;
import az.hamburg.it.turbo.service.abstraction.CarService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("v1/cars")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CarController {
    CarService carService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void saveCar(@RequestBody CreateOrUptadeCarRequest request){
        carService.saveCar(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public CarResponse getCar(@PathVariable Long id) {
        return carService.getCar(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public void updateCar(@PathVariable Long id, @RequestBody CreateOrUptadeCarRequest request) {
        carService.updateCar(id, request);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<CarResponse> getAll() {
        return carService.getAll();
    }
}
