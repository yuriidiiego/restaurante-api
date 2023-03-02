package br.com.projeto.restaurante.domain.lanche;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LancheRepository extends MongoRepository<Lanche, String> {
  List<Lanche> findAllById(List<String> ids);
}
