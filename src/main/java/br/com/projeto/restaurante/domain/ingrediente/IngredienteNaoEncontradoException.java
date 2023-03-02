package br.com.projeto.restaurante.domain.ingrediente;

public class IngredienteNaoEncontradoException extends RuntimeException {

  public IngredienteNaoEncontradoException(String message) {
    super(message);
  }
}
