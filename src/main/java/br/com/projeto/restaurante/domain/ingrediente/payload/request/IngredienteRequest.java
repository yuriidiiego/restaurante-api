package br.com.projeto.restaurante.domain.ingrediente.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Schema(description = "DTO para criação de um novo ingrediente")
public class IngredienteRequest {

  @Schema(
    name = "Nome",
    description = "Nome do ingrediente",
    example = "Tomate"
  )
  @Size(
    min = 3,
    message = "O nome do ingrediente deve ter no mínimo 3 caracteres."
  )
  @NotBlank(message = "O nome do ingrediente deve ser informado.")
  private String nome;

  @Schema(
    name = "Preço",
    description = "Preço do ingrediente",
    example = "10.00"
  )
  @Min(value = 0, message = "O preço do ingrediente deve ser maior que zero.")
  @NotBlank(message = "O preço do ingrediente deve ser informado.")
  private BigDecimal preco;

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
