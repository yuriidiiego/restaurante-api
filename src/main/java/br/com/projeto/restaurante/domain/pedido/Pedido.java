package br.com.projeto.restaurante.domain.pedido;

import br.com.projeto.restaurante.domain.lanche.Lanche;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Schema(description = "Entidade para representar um pedido")
@Document(collection = "pedidos")
public class Pedido {

  @Id
  private String id;

  @DBRef
  private List<Lanche> lanches = new ArrayList<>();

  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  private LocalDateTime dataHora;

  @Indexed
  private BigDecimal valorTotal;

  public Pedido(
    List<Lanche> lanches,
    LocalDateTime dataHora,
    BigDecimal valorTotal
  ) {
    this.lanches = lanches;
    this.dataHora = dataHora;
    this.valorTotal = valorTotal;
  }

  public String getId() {
    return id;
  }

  public List<Lanche> getLanches() {
    return lanches;
  }

  public void setLanches(List<Lanche> lanche) {
    this.lanches = lanche;
  }

  public void setDataHora(LocalDateTime dataHora) {
    this.dataHora = dataHora;
  }

  public LocalDateTime getDataHora() {
    return dataHora;
  }

  public BigDecimal getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(BigDecimal valorTotal) {
    this.valorTotal = valorTotal;
  }
}
