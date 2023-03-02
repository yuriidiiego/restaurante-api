package br.com.projeto.restaurante.domain.lanche.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;

@Schema(description = "DTO para criação de um novo lanche")
public class LancheRequest {

  @Schema(name = "Nome", description = "Nome do lanche", example = "X-Burguer")
  @NotBlank(message = "O nome do lanche deve ser informado.")
  private String nome;

  @Schema(name = "Ingredientes", description = "Ingredientes do lanche")   
  private String[] ingredientes;

  public LancheRequest() {}

  public LancheRequest(String nome, String[] ingredientes) {
    this.nome = nome;
    this.ingredientes = ingredientes;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String[] getIngredientes() {
    return ingredientes;
  }

  public void setIngredientes(String[] ingredientes) {
    this.ingredientes = ingredientes;
  }
}
