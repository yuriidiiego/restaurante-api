package br.com.projeto.restaurante.domain.ingrediente;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Schema(description = "Entidade para representar um ingrediente")
@Document(collection = "ingredientes")
public class Ingrediente {

  @Id
  private String id;

  @Field
  @Indexed(unique = true, name = "nome")
  private String nome;

  @Field
  @Indexed(name = "preco")
  private BigDecimal preco;

  public Ingrediente() {}

  public Ingrediente(String id, String nome, BigDecimal preco) {
    this.id = id;
    this.nome = nome;
    this.preco = preco;
  }

  public Ingrediente(String nome, BigDecimal preco) {
    this.nome = nome;
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

  public BigDecimal getPreco() {
    return preco;
  }

  public void setPreco(BigDecimal preco) {
    this.preco = preco;
  }
}
