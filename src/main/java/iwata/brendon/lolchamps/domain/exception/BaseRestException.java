package iwata.brendon.lolchamps.domain.exception;

import iwata.brendon.lolchamps.domain.dto.response.ResponseErrorItem;
import iwata.brendon.lolchamps.domain.enums.TypeMessageEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseRestException extends RuntimeException{

    public String message;

    public TypeMessageEnum typeMessage;

    public List<ResponseErrorItem> errors;
}
