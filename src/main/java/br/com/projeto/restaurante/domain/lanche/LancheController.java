package br.com.projeto.restaurante.domain.lanche;

import br.com.projeto.restaurante.config.error.ErrorResponse;
import br.com.projeto.restaurante.domain.lanche.payload.request.LancheRequest;
import br.com.projeto.restaurante.domain.lanche.payload.response.LancheResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
  name = "Lanches",
  description = "Endpoints para criação e consulta de lanches"
)
@RestController
@RequestMapping("/lanches")
public class LancheController {

  @Autowired
  private LancheService lancheService;

  @Operation(
    summary = "Cria um novo lanche",
    operationId = "addLanche",
    responses = {
      @ApiResponse(
        responseCode = "201",
        description = "Cria um novo lanche",
        content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = LancheResponse.class)
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
  public ResponseEntity<LancheResponse> addLanche(
    @RequestBody @Valid LancheRequest lancheRequest
  ) {
    LancheResponse lanche = lancheService.addLanche(lancheRequest);
    return ResponseEntity
      .created(URI.create("/lanches/" + lanche.getId()))
      .body(lanche);
  }

  @Operation(
    summary = "Lista todos os lanches",
    operationId = "getAllLanches",
    responses = {
      @ApiResponse(
        responseCode = "200",
        description = "Lista todos os lanches",
        content = @Content(
          mediaType = "application/json",
          array = @ArraySchema(
            schema = @Schema(implementation = LancheResponse.class)
          )
        )
      ),
    }
  )
  @GetMapping
  public ResponseEntity<List<LancheResponse>> getAllLanches() {
    return ResponseEntity.ok().body(lancheService.getAllLanches());
  }

  @Operation(
    summary = "Retorna um lanche pelo id",
    operationId = "getLancheById",
    responses = {
      @ApiResponse(
        responseCode = "200",
        description = "Retorna um lanche pelo id",
        content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = LancheResponse.class)
        )
      ),
    }
  )
  @GetMapping("/{id}")
  public ResponseEntity<LancheResponse> getLancheById(
    @PathVariable @Parameter(
      description = "Id do lanche",
      required = true,
      in = ParameterIn.PATH,
      schema = @Schema(type = "string")
    ) String id
  ) {
    return ResponseEntity.ok().body(lancheService.getById(id));
  }
}
