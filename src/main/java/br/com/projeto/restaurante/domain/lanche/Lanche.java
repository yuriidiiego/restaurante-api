package br.com.projeto.restaurante.domain.lanche;

import br.com.projeto.restaurante.domain.ingrediente.Ingrediente;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Schema(description = "Entidade para representar um lanche")
@Document(collection = "lanches")
public class Lanche {

  @Id
  private String id;

  @Field
  @Indexed(name = "nome", unique = true)
  private String nome;

  @DBRef
  private List<Ingrediente> ingredientes = new ArrayList<>();

  private BigDecimal preco;

  public Lanche() {}

  public Lanche(String nome, List<Ingrediente> ingredientes) {
    this.nome = nome;
    this.ingredientes = ingredientes;
  }

  public Lanche(String nome, List<Ingrediente> ingredientes, BigDecimal preco) {
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
