package br.ucb.presenca.models; // Define o pacote ao qual esta classe pertence

import jakarta.persistence.*; // Importa uma classe ou pacote necessário
import lombok.AllArgsConstructor; // Importa uma classe ou pacote necessário
import lombok.Data; // Importa uma classe ou pacote necessário
import lombok.NoArgsConstructor; // Importa uma classe ou pacote necessário
import com.fasterxml.jackson.annotation.JsonIgnore; // Importa uma classe ou pacote necessário

@Entity // Anotação usada pelo framework (como Spring)
@Table(name = "alunos") // Anotação usada pelo framework (como Spring)
@Data // Anotação usada pelo framework (como Spring)
@NoArgsConstructor // Anotação usada pelo framework (como Spring)
@AllArgsConstructor // Anotação usada pelo framework (como Spring)
public class Aluno { // Declaração da classe

    @Id // Anotação usada pelo framework (como Spring)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotação usada pelo framework (como Spring)
    private Long id; // Declaração de variável ou atributo

    @Column(nullable = false, unique = true) // Anotação usada pelo framework (como Spring)
    private String matricula; // Declaração de variável ou atributo

    @Column(nullable = false) // Anotação usada pelo framework (como Spring)
    private String nome; // Declaração de variável ou atributo

    @Column(nullable = true) // Anotação usada pelo framework (como Spring)
    private String email; // Declaração de variável ou atributo

    @Column(nullable = false) // Anotação usada pelo framework (como Spring)
    private String senha; // Declaração de variável ou atributo
} // Fim de um bloco de código
