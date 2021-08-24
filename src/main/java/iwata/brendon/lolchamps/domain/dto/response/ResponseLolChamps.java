package iwata.brendon.lolchamps.domain.dto.response;

import iwata.brendon.lolchamps.domain.enums.TypeMessageEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseLolChamps<T> {

    private T data;

    private String message;

    private Long status;

    private TypeMessageEnum typeMessage;

    private List<ResponseErrorItem> errors = new ArrayList<>();


    public ResponseLolChamps(T data) {
        this.data = data;
    }

    public ResponseEntity<ResponseLolChamps<T>> okResponse(T data) {
        ResponseLolChamps<T> response = new ResponseLolChamps<T>();
        response.setData(data);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<ResponseLolChamps<T>> createdResponse(T data) {
        ResponseLolChamps<T> response = new ResponseLolChamps<T>();
        response.setData(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<ResponseLolChamps<T>> okOrNoContent(T data) {
        ResponseLolChamps<T> response = new ResponseLolChamps<T>();
        response.setData(data);
        if (data != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.noContent().build();
    }

}
