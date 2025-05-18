package az.hamburg.it.turbo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorDetails {
    private String code;
    private String message;
}