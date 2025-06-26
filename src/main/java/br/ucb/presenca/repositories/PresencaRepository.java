package br.ucb.presenca.repositories; // Define o pacote ao qual esta classe pertence

import br.ucb.presenca.models.Presenca; // Importa uma classe Presenca
import org.springframework.data.jpa.repository.JpaRepository; // Importa uma anotação/jpa que é uma espécie de controlador do db H2
import org.springframework.stereotype.Repository; // Importa uma classe ou pacote necessário

@Repository // Anotação usada pelo framework (como Spring) para anotar como Repositório
public interface PresencaRepository extends JpaRepository<Presenca, Long> {
} // implementa o repositório Jpa 
