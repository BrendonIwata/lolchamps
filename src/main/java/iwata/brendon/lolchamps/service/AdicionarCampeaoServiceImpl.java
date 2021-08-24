package iwata.brendon.lolchamps.service;

import iwata.brendon.lolchamps.database.model.Campeao;
import iwata.brendon.lolchamps.database.repository.CampeaoRepository;
import iwata.brendon.lolchamps.domain.dto.ReqPostCampeaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdicionarCampeaoServiceImpl implements AdicionarCampeaoService {

    @Autowired
    private CampeaoRepository campeaoRepository;

    public void adicionar(ReqPostCampeaoDTO params) {
        Campeao campeao = Campeao.builder().comAnoLancamento(params.getAnoLancamento())
                .comNome(params.getNome())
                .comRework(params.getRework())
                .comPosicaoPrimaria(params.getPosicaoPrimaria()).build();

        campeaoRepository.save(campeao);
    }
}
