package br.com.projeto.restaurante.domain.pedido;

import br.com.projeto.restaurante.domain.ingrediente.Ingrediente;
import br.com.projeto.restaurante.domain.ingrediente.IngredienteRepository;
import br.com.projeto.restaurante.domain.lanche.Lanche;
import br.com.projeto.restaurante.domain.lanche.LancheNaoEncontradoException;
import br.com.projeto.restaurante.domain.lanche.LancheRepository;
import br.com.projeto.restaurante.domain.pedido.payload.request.CriarPedidoPersonalizadoRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

  private final IngredienteRepository ingredienteRepository;
  private final PedidoRepository pedidoRepository;
  private final LancheRepository lancheRepository;

  public PedidoService(
    IngredienteRepository ingredienteRepository,
    PedidoRepository pedidoRepository,
    LancheRepository lancheRepository
  ) {
    this.ingredienteRepository = ingredienteRepository;
    this.pedidoRepository = pedidoRepository;
    this.lancheRepository = lancheRepository;
  }

  public Pedido criarPedidoPersonalizado(
    CriarPedidoPersonalizadoRequest criarPedidoPersonalizadoRequest
  ) {
    List<Lanche> lanches = lancheRepository.findAllById(
      criarPedidoPersonalizadoRequest.getLanchesIds()
    );
    if (lanches.isEmpty()) {
      throw new LancheNaoEncontradoException("Nenhum lanche foi encontrado");
    }
    BigDecimal valorTotal = BigDecimal.ZERO;

    for (Lanche lanche : lanches) {
      List<Ingrediente> ingredientes = lanche.getIngredientes();
      List<String> ingredientesOpcionaisIds = criarPedidoPersonalizadoRequest.getIngredientesOpcionaisIds();

      for (String ingredienteOpcionalId : ingredientesOpcionaisIds) {
        Optional<Ingrediente> ingredienteOpcionalOptional = ingredienteRepository.findById(
          ingredienteOpcionalId
        );
        if (ingredienteOpcionalOptional.isPresent()) {
          ingredientes.add(ingredienteOpcionalOptional.get());
        }
      }

      BigDecimal valorLanche = ingredientes
        .stream()
        .map(Ingrediente::getPreco)
        .reduce(BigDecimal.ZERO, BigDecimal::add);

      valorTotal = valorTotal.add(valorLanche);
    }

    Pedido pedido = new Pedido(lanches, LocalDateTime.now(), valorTotal);
    return pedidoRepository.save(pedido);
  }
}
