package br.ucb.presenca.services; // Define o pacote ao qual esta classe pertence

import br.ucb.presenca.models.Aluno; // Importa a classe models.aluno
import br.ucb.presenca.repositories.AlunoRepository; // Importa a classe repositories.AlunoRepository
import org.springframework.beans.factory.annotation.Autowired; // Importa uma classe ou pacote necessário
import org.springframework.stereotype.Service; // Importa uma classe ou pacote necessário

import java.util.List; // Importa um pacote necessário do Spring Boot
import java.util.Optional; // Importa uma classe ou pacote necessário

@Service // Anotação usada pelo framework (como Spring)
public class AlunoService { // Declaração da classe

    @Autowired // Anotação usada pelo framework (como Spring) Reutilizando uma classe 
    private AlunoRepository alunoRepository; // Declaração de classe reaproveitada

    public Aluno save(Aluno aluno) { // Declaração de método para salvar um novo aluno, bora fazer isso através de requisição no postman
        return alunoRepository.save(aluno);
    } // Fim de um bloco de código

    public List<Aluno> findAll() { // Declaração de método de encontrar todos os alunos cadastrados
        return alunoRepository.findAll();
    } //Retorna todos os alunos

    public Optional<Aluno> findById(Long id) { // Declaração de método de achar id do aluno
        return alunoRepository.findById(id);
    } // Retorna o id do aluno

    public Optional<Aluno> findByMatricula(String matricula) { // Declaração de método pra achar matricula do aluno
        return alunoRepository.findByMatricula(matricula);
    } // Retorna a matrícula do aluno

    public void deleteById(Long id) { // Declaração de método para deletar o aluno pelo Id
        alunoRepository.deleteById(id);
    } // Deleta o aluno e seu id
} 
