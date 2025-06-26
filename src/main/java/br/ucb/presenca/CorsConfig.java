package br.ucb.presenca; // Define o pacote ao qual esta classe pertence

import org.springframework.context.annotation.Bean; // Importa uma classe ou pacote necessário
import org.springframework.context.annotation.Configuration; // Importa uma classe ou pacote necessário
import org.springframework.web.servlet.config.annotation.*; // Importa uma classe ou pacote necessário

@Configuration // Anotação usada pelo framework (como Spring)
public class CorsConfig implements WebMvcConfigurer { // Declaração da classe

    @Override // Anotação usada pelo framework (como Spring)
    public void addCorsMappings(CorsRegistry registry) { // Declaração de método
        registry.addMapping("/**")
                .allowedOrigins("*") // Em produção, troque por o endereço do seu front
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    } // Fim de um bloco de código
} // Fim de um bloco de código
