package br.ucb.presenca.controllers; // Define o pacote ao qual esta classe pertence

import br.ucb.presenca.models.Aluno; // Importa uma classe ou pacote necessário
import br.ucb.presenca.services.AlunoService; // Importa uma classe ou pacote necessário
import org.springframework.beans.factory.annotation.Autowired; // Importa uma classe ou pacote necessário
import org.springframework.http.HttpStatus; // Importa uma classe ou pacote necessário
import org.springframework.http.ResponseEntity; // Importa uma classe ou pacote necessário
import org.springframework.web.bind.annotation.*; // Importa uma classe ou pacote necessário

import java.util.List; // Importa uma classe ou pacote necessário
import java.util.Optional; // Importa uma classe ou pacote necessário

@RestController // Anotação usada pelo framework (como Spring)
@RequestMapping("/alunos") // Anotação usada pelo framework (como Spring)
public class AlunoController { // Declaração da classe AlunoController

    @Autowired // Anotação usada pelo framework (como Spring) pra reutilizar classe
    private AlunoService alunoService; // Declaração de classe reutilizada

    @PostMapping // Anotação usada pelo framework (como Spring)
    public ResponseEntity<?> criarAluno(@RequestBody Aluno aluno) { // Declaração de método
        if (aluno.getMatricula() == null || aluno.getMatricula().isBlank() ||  
                aluno.getNome() == null || aluno.getNome().isBlank() ||
                aluno.getSenha() == null || aluno.getSenha().isBlank()) {
            return ResponseEntity //retorna a resposta da entidade em caso de campo nulo
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Matrícula, nome e senha são obrigatórios.");
        } // impede que deixe os campos em branco

        Optional<Aluno> alunoExistente = alunoService.findByMatricula(aluno.getMatricula());
        if (alunoExistente.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT) //indica conflito dentro das requisições feitas anteriormente
                    .body("Já existe um aluno com essa matrícula.");
        } // Impede que sejam salvos dois alunos com o mesmo numero de matricula

        Aluno novoAluno = alunoService.save(aluno);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(novoAluno);
    } // Fim de um bloco de código

    @GetMapping // Anotação usada pelo framework (como Spring)
    public ResponseEntity<List<Aluno>> listarAlunos() { // Declaração de método
        List<Aluno> alunos = alunoService.findAll();
        return ResponseEntity.ok(alunos);
    } // Fim de um bloco de código

    @GetMapping("/{id}") // Anotação usada pelo framework (como Spring)
    public ResponseEntity<?> buscarAlunoPorId(@PathVariable Long id) { // Declaração de método para buscar aluno por id e dar a resposta se encontrou ou n
        Optional<Aluno> aluno = alunoService.findById(id);
        if (aluno.isPresent()) {
            return ResponseEntity.ok(aluno.get()); //retorna resposta pra requisição
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Aluno não encontrado."); //retorna resposta negativa pra requisição
        }

    }

    @PutMapping("/{id}") // Anotação usada pelo framework (como Spring) para mapear os id's
    public ResponseEntity<?> atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) { // Declaração de método para atualizar o cadastro do aluno
        Optional<Aluno> alunoExistente = alunoService.findById(id);

        if (alunoExistente.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Aluno não encontrado.");
        } // Fim de um bloco de código

        Aluno aluno = alunoExistente.get();

        if (alunoAtualizado.getMatricula() != null && !alunoAtualizado.getMatricula().isBlank()) {
            aluno.setMatricula(alunoAtualizado.getMatricula());
        } // Atualiza matrícula
        if (alunoAtualizado.getNome() != null && !alunoAtualizado.getNome().isBlank()) {
            aluno.setNome(alunoAtualizado.getNome());
        } // Atualiza Nome
        if (alunoAtualizado.getEmail() != null) {
            aluno.setEmail(alunoAtualizado.getEmail());
        } // Atualiza Email
        if (alunoAtualizado.getSenha() != null && !alunoAtualizado.getSenha().isBlank()) {
            aluno.setSenha(alunoAtualizado.getSenha());
        } // Atualiza senha

        Aluno alunoSalvo = alunoService.save(aluno);
        return ResponseEntity.ok(alunoSalvo);
    } // Retorna aluno salvo 

    @DeleteMapping("/{id}") // Anotação usada pelo framework (como Spring) para deletar aluno
    public ResponseEntity<?> deletarAluno(@PathVariable Long id) { // Declaração de método para deletar aluno
        Optional<Aluno> alunoExistente = alunoService.findById(id);

        if (alunoExistente.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Aluno não encontrado.");
        } // retorna aluno encontrado ou não

        alunoService.deleteById(id);
        // Deleta aluno e retorna 204 No content ou apenas 200 Ok
        return ResponseEntity.noContent().build();
    } 
} //