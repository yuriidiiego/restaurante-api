package br.com.projeto.restaurante.domain.pedido.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.constraints.NotNull;

@Schema(description = "DTO para criação de um novo pedido")
public class CriarPedidoPersonalizadoRequest {

  @Schema(
    description = "IDs dos lanches",
    required = true,
    example = "[63ff6fd6f5a034518fd77771, 61d9c78b812774a5c10ba7f5]"
  )
  @NotNull
  private List<String> lanchesIds;

  @Schema(
    description = "IDs dos ingredientes opcionais",
    required = true,
    example = "[63ff6fd6f5a034518fd77771, 61d9c78b812774a5c10ba7f5]"
  )
  private List<String> ingredientesOpcionaisIds;

  public CriarPedidoPersonalizadoRequest(
    List<String> lanchesIds,
    List<String> ingredientesOpcionaisIds
  ) {
    this.lanchesIds = lanchesIds;
    this.ingredientesOpcionaisIds = ingredientesOpcionaisIds;
  }

  public List<String> getLanchesIds() {
    return lanchesIds;
  }

  public List<String> getIngredientesOpcionaisIds() {
    return ingredientesOpcionaisIds;
  }
}
