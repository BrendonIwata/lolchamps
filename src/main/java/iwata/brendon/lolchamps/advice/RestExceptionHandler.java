package iwata.brendon.lolchamps.advice;

import iwata.brendon.lolchamps.domain.dto.response.ResponseError;
import iwata.brendon.lolchamps.domain.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.math.BigDecimal;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseError> handleNotFoundException(NotFoundException e) {
        log.info("bateu no advice do notfound");
        ResponseError responseError = ResponseError.builder()
                .message(e.getMessage())
                .typeMessage(e.getTypeMessage())
                .status(new BigDecimal(HttpStatus.NOT_FOUND.value()).longValue())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Void> handleGenericException(Exception e) {
        log.info("bateu no advice do exception");
        return ResponseEntity.internalServerError().build();
    }
}
