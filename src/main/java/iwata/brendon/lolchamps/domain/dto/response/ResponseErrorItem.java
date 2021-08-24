package iwata.brendon.lolchamps.domain.dto.response;


import lombok.Data;

@Data
public class ResponseErrorItem {

    private String field;

    private String message;
}
