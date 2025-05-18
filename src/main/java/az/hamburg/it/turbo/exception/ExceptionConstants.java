package az.hamburg.it.turbo.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ExceptionConstants {
    UNEXPECTED_EXCEPTION("UNEXPECTED_EXCEPTION", "unexpected exception occurred"),
    USER_NOT_FOUND("USER_NOT_FOUND", "user not found"),
    CAR_NOT_FOUND("CAR_NOT_FOUND", "car not found"),
    LISTING_NOT_FOUND("LISTING_NOT_FOUND","listing not found"),
    LOCATION_NOT_FOUND("LOCATION_NOT_FOUD", "location not found");

    private final String code;
    private final String message;
}
