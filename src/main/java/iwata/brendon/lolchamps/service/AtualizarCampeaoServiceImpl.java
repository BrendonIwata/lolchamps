package iwata.brendon.lolchamps.service;

import iwata.brendon.lolchamps.database.model.Campeao;
import iwata.brendon.lolchamps.database.repository.CampeaoRepository;
import iwata.brendon.lolchamps.domain.dto.ReqPutCampeaoDTO;
import iwata.brendon.lolchamps.domain.enums.TypeMessageEnum;
import iwata.brendon.lolchamps.domain.exception.NotFoundException;
import iwata.brendon.lolchamps.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtualizarCampeaoServiceImpl implements AtualizarCampeaoService {

    @Autowired
    private CampeaoRepository campeaoRepository;

    @Autowired
    private ObjectUtils objectUtils;

    @Override
    public void atualizar(ReqPutCampeaoDTO params) {

        Optional<Campeao> campeaoOptional = campeaoRepository.findById(params.getId());

        if (!campeaoOptional.isPresent()) {
            NotFoundException notFoundException = new NotFoundException();
            notFoundException.setMessage("Campeão não encontrado");
            notFoundException.setTypeMessage(TypeMessageEnum.TOAST);
            throw notFoundException;
        }

        try {
            Campeao campeao = objectUtils.mergeObjects(params.parseToCampeao(), campeaoOptional.get());
            campeaoRepository.save(campeao);
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
