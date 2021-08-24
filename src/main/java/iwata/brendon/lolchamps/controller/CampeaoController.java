package iwata.brendon.lolchamps.controller;

import iwata.brendon.lolchamps.database.model.Campeao;
import iwata.brendon.lolchamps.database.repository.CampeaoRepository;
import iwata.brendon.lolchamps.domain.dto.ReqPostCampeaoDTO;
import iwata.brendon.lolchamps.domain.dto.ReqPutCampeaoDTO;
import iwata.brendon.lolchamps.domain.dto.response.ResponseLolChamps;
import iwata.brendon.lolchamps.service.AdicionarCampeaoService;
import iwata.brendon.lolchamps.service.AtualizarCampeaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clientes")
public class CampeaoController {

    @Autowired
    private CampeaoRepository campeaoRepository;

    @Autowired
    private AdicionarCampeaoService adicionarCampeaoService;

    @Autowired
    private AtualizarCampeaoService atualizarCampeaoService;

    @GetMapping
    public ResponseEntity<ResponseLolChamps<List<Campeao>>> buscarTodosOsCampeoes() {
        return new ResponseLolChamps<List<Campeao>>().okResponse(campeaoRepository.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarCampeao(@RequestBody ReqPostCampeaoDTO params) {
        adicionarCampeaoService.adicionar(params);
    }

    @PutMapping
    public void atualizarCampeao(@RequestBody ReqPutCampeaoDTO params) {
        atualizarCampeaoService.atualizar(params);
    }
}
