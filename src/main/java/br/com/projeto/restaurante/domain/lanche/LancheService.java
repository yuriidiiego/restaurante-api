package br.com.projeto.restaurante.domain.lanche;

import br.com.projeto.restaurante.domain.ingrediente.Ingrediente;
import br.com.projeto.restaurante.domain.ingrediente.IngredienteService;
import br.com.projeto.restaurante.domain.ingrediente.payload.response.IngredienteResponse;
import br.com.projeto.restaurante.domain.lanche.payload.request.LancheRequest;
import br.com.projeto.restaurante.domain.lanche.payload.response.LancheResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancheService {

  @Autowired
  private LancheRepository lancheRepository;

  @Autowired
  private IngredienteService ingredienteService;

  @Autowired
  private LancheMapper lancheMapper;

  public LancheResponse addLanche(LancheRequest lancheRequest) {
    List<Ingrediente> ingredientes = new ArrayList<>();
    for (String ingredienteId : lancheRequest.getIngredientes()) {
      Optional<IngredienteResponse> optionalIngrediente = ingredienteService.getIngredienteByIdOrElseThrow(
        ingredienteId
      );
      IngredienteResponse ingrediente = optionalIngrediente.get();
      ingredientes.add(
        new Ingrediente(
          ingrediente.getId(),
          ingrediente.getNome(),
          ingrediente.getPreco()
        )
      );
    }

    BigDecimal precoTotal = BigDecimal.ZERO;
    for (Ingrediente ingrediente : ingredientes) {
      precoTotal = precoTotal.add(ingrediente.getPreco());
    }

    Lanche lanche = new Lanche();
    lanche.setNome(lancheRequest.getNome());
    lanche.setIngredientes(ingredientes);
    lanche.setPreco(precoTotal);

    Lanche savedLanche = lancheRepository.save(lanche);
    return lancheMapper.lancheToLancheResponse(savedLanche);
  }

  public List<LancheResponse> getAllLanches() {
    List<Lanche> lanches = lancheRepository.findAll();
    return lancheMapper.lanchesToLancheResponses(lanches);
  }

  public LancheResponse getById(String id) {
    return lancheMapper.lancheToLancheResponse(
      lancheRepository
        .findById(id)
        .orElseThrow(() ->
          new LancheNaoEncontradoException("Lanche não encontrado")
        )
    );
  }
}
