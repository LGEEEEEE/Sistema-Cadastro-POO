package br.ucb.presenca.repositories; // Define o pacote ao qual esta classe pertence

import java.util.Optional; // Importa uma classe ou pacote necessário

import org.springframework.data.jpa.repository.JpaRepository; // Importa uma classe ou pacote necessário
import org.springframework.stereotype.Repository; // Importa uma classe ou pacote necessário

import br.ucb.presenca.models.Aluno; // Importa uma classe ou pacote necessário

@Repository // Anotação usada pelo framework (como Spring)
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByMatricula(String matricula);
} // Fim de um bloco de código
