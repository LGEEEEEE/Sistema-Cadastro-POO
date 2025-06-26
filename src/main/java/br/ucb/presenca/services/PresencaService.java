package br.ucb.presenca.services; // Define o pacote ao qual esta classe pertence

import br.ucb.presenca.models.Presenca; // Importa uma classe ou pacote necessário
import br.ucb.presenca.repositories.PresencaRepository; // Importa uma classe ou pacote necessário
import org.springframework.beans.factory.annotation.Autowired; // Importa uma classe ou pacote necessário
import org.springframework.stereotype.Service; // Importa uma classe ou pacote necessário

import java.util.List; // Importa uma classe ou pacote necessário
import java.util.Optional; // Importa uma classe ou pacote necessário

@Service // Anotação usada pelo framework (como Spring) para anotar como Serviço
public class PresencaService { // Declaração da classe

    @Autowired // Anotação usada pelo framework (como Spring) para reutilizar classes anteriores
    private PresencaRepository presencaRepository; // Declaração de classe reutilizada

    public Presenca save(Presenca presenca) { // Declaração de método 
        return presencaRepository.save(presenca);
    } // Fim de um bloco de código

    public List<Presenca> findAll() { // Declaração de método
        return presencaRepository.findAll();
    } // Fim de um bloco de código

    public Optional<Presenca> findById(Long id) { // Declaração de método
        return presencaRepository.findById(id);
    } // Fim de um bloco de código

    public void deleteById(Long id) { // Declaração de método
        presencaRepository.deleteById(id);
    } // Fim de um bloco de código
} // Fim de um bloco de código
