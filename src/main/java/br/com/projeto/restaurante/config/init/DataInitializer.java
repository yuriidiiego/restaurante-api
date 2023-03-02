// package br.com.projeto.restaurante.config.init;

// import br.com.projeto.restaurante.domain.ingrediente.Ingrediente;
// import br.com.projeto.restaurante.domain.ingrediente.IngredienteRepository;
// import br.com.projeto.restaurante.domain.lanche.Lanche;
// import br.com.projeto.restaurante.domain.lanche.LancheRepository;
// import com.fasterxml.jackson.core.type.TypeReference;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import java.io.File;
// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.ApplicationArguments;
// import org.springframework.boot.ApplicationRunner;
// import org.springframework.stereotype.Component;

// @Component
// public class DataInitializer implements ApplicationRunner {

// //   @Autowired
// //   private LancheRepository lancheRepository;

//   @Autowired
//   private IngredienteRepository ingredienteRepository;

//   @Override
//   public void run(ApplicationArguments args) throws Exception {
//     ObjectMapper mapper = new ObjectMapper();
//     // List<Lanche> lanches = mapper.readValue(
//     //   new File("src/main/resources/lanches.json"),
//     //   new TypeReference<List<Lanche>>() {}
//     // );
//     // lancheRepository.saveAll(lanches);

//     List<Ingrediente> ingredientes = mapper.readValue(
//       new File("src/main/resources/ingredientes.json"),
//       new TypeReference<List<Ingrediente>>() {}
//     );
//     ingredienteRepository.saveAll(ingredientes);
//   }
// }
