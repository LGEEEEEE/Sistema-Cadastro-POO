package br.ucb.presenca; // Define o pacote ao qual esta classe pertence

import org.springframework.boot.SpringApplication; // Importa uma classe ou pacote necessário
import org.springframework.boot.autoconfigure.SpringBootApplication; // Importa uma classe ou pacote necessário

@SpringBootApplication // Anotação usada pelo framework (como Spring)
public class PresencaApplication { // Declaração da classe

    public static void main(String[] args) { // Declaração de método
        SpringApplication.run(PresencaApplication.class, args);
    } // Fim de um bloco de código
} // Fim de um bloco de código
