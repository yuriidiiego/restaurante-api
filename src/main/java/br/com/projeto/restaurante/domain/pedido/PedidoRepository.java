package br.com.projeto.restaurante.domain.pedido;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepository extends MongoRepository<Pedido, String> {}
