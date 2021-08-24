package iwata.brendon.lolchamps.domain.dto.response;

import iwata.brendon.lolchamps.domain.enums.TypeMessageEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ResponseError {

    private Object data;

    private String message;

    private Long status;

    private TypeMessageEnum typeMessage;

    private List<ResponseErrorItem> errors;
}
