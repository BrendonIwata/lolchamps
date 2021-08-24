package iwata.brendon.lolchamps.domain.dto;

import iwata.brendon.lolchamps.domain.enums.PosicaoPrimariaEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReqPostCampeaoDTO {

    private String nome;

    private LocalDate anoLancamento;

    private Boolean rework;

    private PosicaoPrimariaEnum posicaoPrimaria;
}
