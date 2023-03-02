package br.com.projeto.restaurante.domain.pedido;

import br.com.projeto.restaurante.config.error.ErrorResponse;
import br.com.projeto.restaurante.domain.pedido.payload.request.CriarPedidoPersonalizadoRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.net.URI;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
  name = "Pedidos",
  description = "Endpoints para criação e consulta de pedidos"
)
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

  @Autowired
  private PedidoService pedidoService;

  @Operation(
    summary = "Cria um pedido personalizado",
    description = "Cria um pedido personalizado",
    operationId = "criarPedidoPersonalizado",
    responses = {
      @ApiResponse(
        responseCode = "201",
        description = "Cria um pedido personalizado",
        content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = Pedido.class)
        )
      ),
      @ApiResponse(
        responseCode = "400",
        description = "Erro de validação",
        content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = ErrorResponse.class)
        )
      ),
    }
  )
  @PostMapping
  public ResponseEntity<Pedido> criarPedido(
    @RequestBody @Valid CriarPedidoPersonalizadoRequest request
  ) {
    Pedido pedido = pedidoService.criarPedidoPersonalizado(request);
    return ResponseEntity
      .created(URI.create("/pedidos/" + pedido.getId()))
      .body(pedido);
  }
}
