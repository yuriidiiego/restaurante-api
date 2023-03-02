package br.com.projeto.restaurante.domain.lanche.payload.response;

import br.com.projeto.restaurante.domain.ingrediente.Ingrediente;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.List;

@Schema(description = "DTO de resposta para criação de um novo lanche")
public class LancheResponse {

  @Schema(name = "ID", description = "ID do lanche", example = "1")
  private String id;

  @Schema(name = "Nome", description = "Nome do lanche", example = "X-Burguer")
  private String nome;

  @Schema(name = "Ingredientes", description = "Ingredientes do lanche")
  private List<Ingrediente> ingredientes;

  @Schema(name = "Preço", description = "Preço do lanche", example = "10.00")
  private BigDecimal preco;

  public LancheResponse() {}

  public LancheResponse(
    String id,
    String nome,
    List<Ingrediente> ingredientes,
    BigDecimal preco
  ) {
    this.id = id;
    this.nome = nome;
    this.ingredientes = ingredientes;
    this.preco = preco;
  }

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

  public List<Ingrediente> getIngredientes() {
    return ingredientes;
  }

  public void setIngredientes(List<Ingrediente> ingredientes) {
    this.ingredientes = ingredientes;
  }

  public BigDecimal getPreco() {
    return preco;
  }

  public void setPreco(BigDecimal preco) {
    this.preco = preco;
  }
}
