package iwata.brendon.lolchamps.domain.dto;

import iwata.brendon.lolchamps.database.model.Campeao;
import iwata.brendon.lolchamps.domain.enums.PosicaoPrimariaEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReqPutCampeaoDTO {

    private Long id;

    private String nome;

    private LocalDate anoLancamento;

    private Boolean rework;

    private PosicaoPrimariaEnum posicaoPrimaria;

    public Campeao parseToCampeao() {
        return Campeao.builder().comId(id).comNome(nome).comRework(rework).comAnoLancamento(anoLancamento).comPosicaoPrimaria(posicaoPrimaria).build();
    }
}
