package dio.restifull.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

@ExceptionHandler(IllegalArgumentException.class)  
  public ResponseEntity<String> handlebusinessException(IllegalArgumentException businessException) {
     
    return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);

  }

  @ExceptionHandler(NoSuchElementException.class)  
  public ResponseEntity<String> handlenotFoundException(NoSuchElementException notFoundException) {
     
    return new ResponseEntity<>( "Resource ID not found.", HttpStatus.NOT_FOUND);

  }

  @ExceptionHandler(Throwable.class)  
  public ResponseEntity<String> handleUnexpectedException(Throwable UnexpectedException){
    var message = "Unexpected server error, see the logs."; 
    logger.error(message, UnexpectedException); 
    return new ResponseEntity<>( message, HttpStatus.INTERNAL_SERVER_ERROR);

  }
  
  @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        StringBuilder errorMessage = new StringBuilder("Validation errors: ");
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errorMessage.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("; ")
        );
        return ResponseEntity.badRequest().body(errorMessage.toString());

}
}

