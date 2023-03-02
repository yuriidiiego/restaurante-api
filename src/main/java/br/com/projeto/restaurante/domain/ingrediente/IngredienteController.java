package br.com.projeto.restaurante.domain.ingrediente;

import br.com.projeto.restaurante.config.error.ErrorResponse;
import br.com.projeto.restaurante.domain.ingrediente.payload.request.IngredienteRequest;
import br.com.projeto.restaurante.domain.ingrediente.payload.response.IngredienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(
  name = "Ingrediente",
  description = "Endpoints para criação, consulta e atualização de ingredientes"
)
@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {

  @Autowired
  private IngredienteService ingredienteService;

  @Operation(
    summary = "Retorna todos os ingredientes cadastrados",
    operationId = "getAllIngredientes",
    responses = {
      @ApiResponse(
        responseCode = "200",
        description = "Retorna todos os ingredientes cadastrados",
        content = @Content(
          mediaType = "application/json",
          array = @ArraySchema(
            schema = @Schema(implementation = IngredienteResponse.class)
          )
        )
      ),
    }
  )
  @GetMapping
  public ResponseEntity<List<IngredienteResponse>> getAllIngredientes() {
    List<IngredienteResponse> ingredientes = ingredienteService.getAllIngredientes();
    return ResponseEntity.ok().body(ingredientes);
  }

  @Operation(
    summary = "Cria um novo ingrediente",
    operationId = "addIngrediente",
    responses = {
      @ApiResponse(
        responseCode = "201",
        description = "Cria um novo ingrediente",
        content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = IngredienteResponse.class)
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
  public ResponseEntity<IngredienteResponse> addIngrediente(
    @RequestBody IngredienteRequest ingredienteRequest
  ) {
    return ResponseEntity
      .created(
        URI.create(
          "/ingredientes/" +
          ingredienteService.addIngrediente(ingredienteRequest)
        )
      )
      .body(ingredienteService.addIngrediente(ingredienteRequest));
  }

  @Operation(
    summary = "Atualiza o preço de um ingrediente",
    operationId = "updatePrecoIngrediente",
    responses = {
      @ApiResponse(
        responseCode = "200",
        description = "Atualiza o preço de um ingrediente",
        content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = IngredienteResponse.class)
        )
      ),
      @ApiResponse(
        responseCode = "404",
        description = "Ingrediente não encontrado",
        content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = ErrorResponse.class)
        )
      ),
      @ApiResponse(
        responseCode = "400",
        description = "Erro de validação",
        content = @Content
      ),
    }
  )
  @PutMapping("/{id}/preco")
  public ResponseEntity<IngredienteResponse> updatePrecoIngrediente(
    @PathVariable @Parameter(
      name = "ID",
      description = "ID do ingrediente",
      example = "63ff6fd6f5a034518fd77771",
      in = ParameterIn.PATH,
      schema = @Schema(type = "string")
    ) String id,
    @RequestParam @Parameter(
      name = "preco",
      description = "Preço do ingrediente",
      in = ParameterIn.QUERY,
      example = "10.00"
    ) BigDecimal novoPreco
  ) {
    return ResponseEntity
      .ok()
      .body(ingredienteService.updatePrecoIngrediente(id, novoPreco));
  }
}
