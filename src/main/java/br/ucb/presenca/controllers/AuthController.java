package br.ucb.presenca.controllers; // Define o pacote ao qual esta classe pertence

import org.springframework.beans.factory.annotation.Autowired; // Importa uma classe ou pacote necessário
import org.springframework.http.HttpStatus; // Importa uma classe ou pacote necessário
import org.springframework.http.ResponseEntity; // Importa uma classe ou pacote necessário
import org.springframework.web.bind.annotation.*; // Importa uma classe ou pacote necessário

import br.ucb.presenca.models.LoginRequest; // Importa uma classe ou pacote necessário
import br.ucb.presenca.services.AuthService; // Importa uma classe ou pacote necessário

@RestController // Anotação usada pelo framework (como Spring)
@RequestMapping("/auth") // Anotação usada pelo framework (como Spring)
public class AuthController { // Declaração da classe

    @Autowired // Anotação usada pelo framework (como Spring)
    private AuthService authService; // Declaração de variável ou atributo

    @PostMapping("/login") // Anotação usada pelo framework (como Spring)
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) { // Declaração de método
        boolean autenticado = authService.autenticar(loginRequest.getMatricula(), loginRequest.getSenha());
        if (autenticado) {
            return ResponseEntity.ok("Login realizado com sucesso!");
        } // Fim de um bloco de código
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Matrícula ou senha inválidos");
    } // Fim de um bloco de código
} // Fim de um bloco de código
