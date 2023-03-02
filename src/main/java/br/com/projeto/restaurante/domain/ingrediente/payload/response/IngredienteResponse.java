package br.com.projeto.restaurante.domain.ingrediente.payload.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

@Schema(description = "DTO de resposta para criação de um novo ingrediente")
public class IngredienteResponse {

  @Schema(name = "ID", description = "ID do ingrediente", example = "1")
  private String id;

  @Schema(
    name = "Nome",
    description = "Nome do ingrediente",
    example = "Tomate"
  )
  private String nome;

  @Schema(
    name = "Preço",
    description = "Preço do ingrediente",
    example = "10.00"
  )
  private BigDecimal preco;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public BigDecimal getPreco() {
    return preco;
  }

  public void setPreco(BigDecimal preco) {
    this.preco = preco;
  }
}
