package br.com.projeto.restaurante.domain.ingrediente;

import br.com.projeto.restaurante.domain.ingrediente.payload.request.IngredienteRequest;
import br.com.projeto.restaurante.domain.ingrediente.payload.response.IngredienteResponse;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService {

  @Autowired
  private IngredienteRepository ingredienteRepository;

  @Autowired
  private IngredienteMapper ingredienteMapper;

  public IngredienteResponse addIngrediente(
    IngredienteRequest ingredienteRequest
  ) {
    Ingrediente savedIngrediente = ingredienteRepository.save(
      ingredienteMapper.ingredienteRequestToIngrediente(ingredienteRequest)
    );
    return ingredienteMapper.ingredienteToIngredienteResponse(savedIngrediente);
  }

  public List<IngredienteResponse> getAllIngredientes() {
    List<Ingrediente> ingredientes = ingredienteRepository.findAll();
    return ingredientes
      .stream()
      .map(ingredienteMapper::ingredienteToIngredienteResponse)
      .collect(Collectors.toList());
  }

  public Optional<IngredienteResponse> getIngredienteByIdOrElseThrow(
    String id
  ) {
    Ingrediente ingrediente = ingredienteRepository
      .findById(id)
      .orElseThrow(() ->
        new IngredienteNaoEncontradoException("Ingrediente não encontrado")
      );

    return Optional.of(
      ingredienteMapper.ingredienteToIngredienteResponse(ingrediente)
    );
  }

  public IngredienteResponse updatePrecoIngrediente(
    String id,
    BigDecimal novoPreco
  ) {
    Ingrediente ingrediente = ingredienteRepository
      .findById(id)
      .orElseThrow(() ->
        new IngredienteNaoEncontradoException("Ingrediente não encontrado")
      );
    ingrediente.setPreco(novoPreco);
    Ingrediente savedIngrediente = ingredienteRepository.save(ingrediente);
    return ingredienteMapper.ingredienteToIngredienteResponse(savedIngrediente);
  }
}
