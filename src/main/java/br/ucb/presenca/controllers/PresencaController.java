package br.ucb.presenca.controllers; // Define o pacote ao qual esta classe pertence

import br.ucb.presenca.models.Presenca; // Importa uma classe ou pacote necessário
import br.ucb.presenca.models.Aluno; // Importa uma classe ou pacote necessário
import br.ucb.presenca.services.PresencaService; // Importa uma classe ou pacote necessário
import br.ucb.presenca.services.AlunoService; // Importa uma classe ou pacote necessário
import org.springframework.beans.factory.annotation.Autowired; // Importa uma classe ou pacote necessário
import org.springframework.http.HttpStatus; // Importa uma classe ou pacote necessário
import org.springframework.http.ResponseEntity; // Importa uma classe ou pacote necessário
import org.springframework.web.bind.annotation.*; // Importa uma classe ou pacote necessário

import java.time.LocalDate; // Importa uma classe ou pacote necessário
import java.util.List; // Importa uma classe ou pacote necessário
import java.util.Optional; // Importa uma classe ou pacote necessário

@RestController // Anotação usada pelo framework (como Spring)
@RequestMapping("/presencas") // Anotação usada pelo framework (como Spring)
public class PresencaController { // Declaração da classe

    @Autowired // Anotação usada pelo framework (como Spring)
    private PresencaService presencaService; // Declaração de variável ou atributo

    @Autowired // Anotação usada pelo framework (como Spring)
    private AlunoService alunoService; // Declaração de variável ou atributo

    @PostMapping // Anotação usada pelo framework (como Spring)
    public ResponseEntity<?> registrarPresenca(@RequestParam Long alunoId, @RequestParam String data) { // Declaração de método
        Optional<Aluno> alunoOpt = alunoService.findById(alunoId);
        if (alunoOpt.isEmpty()) {
            return new ResponseEntity<>("Aluno não encontrado.", HttpStatus.NOT_FOUND);
        } // Fim de um bloco de código

        LocalDate localDate;
        try {
            localDate = LocalDate.parse(data);
        } catch (Exception e) {
            return new ResponseEntity<>("Data inválida. Use formato yyyy-MM-dd.", HttpStatus.BAD_REQUEST);
        } // Fim de um bloco de código

        Presenca presenca = new Presenca();
        presenca.setAluno(alunoOpt.get());
        presenca.setData(localDate);

        Presenca salva = presencaService.save(presenca);
        return new ResponseEntity<>(salva, HttpStatus.CREATED);
    } // Fim de um bloco de código

    @GetMapping // Anotação usada pelo framework (como Spring)
    public ResponseEntity<List<Presenca>> listarPresencas() { // Declaração de método
        List<Presenca> presencas = presencaService.findAll();
        return new ResponseEntity<>(presencas, HttpStatus.OK);
    } // Fim de um bloco de código

    @DeleteMapping("/{id}") // Anotação usada pelo framework (como Spring)
    public ResponseEntity<?> deletarPresenca(@PathVariable Long id) { // Declaração de método
        Optional<Presenca> presencaOpt = presencaService.findById(id);
        if (presencaOpt.isEmpty()) {
            return new ResponseEntity<>("Presença não encontrada.", HttpStatus.NOT_FOUND);
        } // Fim de um bloco de código
        presencaService.deleteById(id);
        return new ResponseEntity<>("Presença deletada com sucesso.", HttpStatus.NO_CONTENT);
    } // Fim de um bloco de código
} // Fim de um bloco de código
