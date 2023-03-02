package br.com.projeto.restaurante.domain.ingrediente;

import br.com.projeto.restaurante.domain.ingrediente.payload.request.IngredienteRequest;
import br.com.projeto.restaurante.domain.ingrediente.payload.response.IngredienteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IngredienteMapper {
  @Mapping(target = "id", ignore = true)
  Ingrediente ingredienteRequestToIngrediente(
    IngredienteRequest ingredienteRequest
  );

  IngredienteResponse ingredienteToIngredienteResponse(Ingrediente ingrediente);
}
