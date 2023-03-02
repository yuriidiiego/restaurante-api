package br.com.projeto.restaurante;

import br.com.projeto.restaurante.domain.ingrediente.Ingrediente;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class RestauranteApplication implements CommandLineRunner {

  @Autowired
  private MongoTemplate mongoTemplate;

  public static void main(String[] args) {
    SpringApplication.run(RestauranteApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Ingrediente alface = new Ingrediente(
      "64001cdb7ac08a4793a531fa",
      "Alface",
      new BigDecimal("0.40")
    );
    Ingrediente bacon = new Ingrediente(
      "64001cdb7ac08a4793a531fb",
      "Bacon",
      new BigDecimal("2.00")
    );
    Ingrediente hamburguer = new Ingrediente(
      "64001cdb7ac08a4793a531fc",
      "Hamburguer",
      new BigDecimal("3.00")
    );
    Ingrediente ovo = new Ingrediente(
      "64001cdb7ac08a4793a531fd",
      "Ovo",
      new BigDecimal("0.80")
    );
    Ingrediente queijo = new Ingrediente(
      "64001cdb7ac08a4793a531fe",
      "Queijo",
      new BigDecimal("1.50")
    );

    mongoTemplate.save(alface);
    mongoTemplate.save(bacon);
    mongoTemplate.save(hamburguer);
    mongoTemplate.save(ovo);
    mongoTemplate.save(queijo);
  }
}
