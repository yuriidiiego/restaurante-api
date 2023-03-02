package br.com.projeto.restaurante.domain.lanche;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LancheNaoEncontradoException extends RuntimeException {

  public LancheNaoEncontradoException(String message) {
    super(message);
  }
}
