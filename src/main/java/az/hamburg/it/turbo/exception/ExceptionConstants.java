package az.hamburg.it.turbo.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ExceptionConstants {
    USER_NOT_FOUND("USER_NOT_FOUND", "user not found"),
    CAR_NOT_FOUND("CAR_NOT_FOUND", "user not found");

    private final String code;
    private final String message;
}
