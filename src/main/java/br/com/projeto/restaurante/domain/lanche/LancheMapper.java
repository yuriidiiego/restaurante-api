package br.com.projeto.restaurante.domain.lanche;

import br.com.projeto.restaurante.domain.lanche.payload.response.LancheResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LancheMapper {
  List<LancheResponse> lanchesToLancheResponses(List<Lanche> lanches);

  LancheResponse lancheToLancheResponse(Lanche lanche);
}
