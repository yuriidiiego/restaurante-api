package br.com.projeto.restaurante.domain.ingrediente;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IngredienteRepository
  extends MongoRepository<Ingrediente, String> {}
