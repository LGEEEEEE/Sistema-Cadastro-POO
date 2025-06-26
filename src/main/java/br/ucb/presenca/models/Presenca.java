package br.ucb.presenca.models; // Define o pacote ao qual esta classe pertence

import jakarta.persistence.*; // Importa uma classe ou pacote necessário
import lombok.AllArgsConstructor; // Importa uma classe ou pacote necessário
import lombok.Data; // Importa uma classe ou pacote necessário
import lombok.NoArgsConstructor; // Importa uma classe ou pacote necessário

import java.time.LocalDate; // Importa uma classe ou pacote necessário

@Entity // Anotação usada pelo framework (como Spring)
@Table(name = "presencas") // Anotação usada pelo framework (como Spring)
@Data // Anotação usada pelo framework (como Spring)
@NoArgsConstructor // Anotação usada pelo framework (como Spring)
@AllArgsConstructor // Anotação usada pelo framework (como Spring)
public class Presenca { // Declaração da classe

    @Id // Anotação usada pelo framework (como Spring)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotação usada pelo framework (como Spring)
    private Long id; // Declaração de variável ou atributo

    @ManyToOne(optional = false) // Anotação usada pelo framework (como Spring)
    @JoinColumn(name = "aluno_id") // Anotação usada pelo framework (como Spring)
    private Aluno aluno; // Declaração de variável ou atributo

    @Column(nullable = false) // Anotação usada pelo framework (como Spring)
    private LocalDate data; // Declaração de variável ou atributo
} // Fim de um bloco de código
