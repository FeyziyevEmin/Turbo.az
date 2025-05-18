package az.hamburg.it.turbo.model.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = PRIVATE )
public class CarPageResponse {
    List<CarResponse> userResponseList;
    long totalCars;
    long totalPage;
    boolean hasNextPage;
}
