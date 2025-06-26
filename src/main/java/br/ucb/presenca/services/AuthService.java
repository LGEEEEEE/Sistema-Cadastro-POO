package br.ucb.presenca.services; // Define o pacote ao qual esta classe pertence

import java.util.Optional; // Importa pacote necessário

import org.springframework.beans.factory.annotation.Autowired; // Importa um pacote necessário
import org.springframework.stereotype.Service; // Importa uma classe ou pacote necessário

import br.ucb.presenca.models.Aluno; // Importa um pacote necessário
import br.ucb.presenca.repositories.AlunoRepository; // Importa um pacote necessário

@Service // Anotação usada pelo framework (como Spring) pra definir como serviçio
public class AuthService { // Declaração da classe AuthService que vai servir como autenticador de entrada do projeto

    @Autowired // Anotação usada pelo framework (como Spring) reutilizando classes 
    private AlunoRepository alunoRepository; // Declaração de classe reutilizada para evitar extensão do Código

    public boolean autenticar(String matricula, String senha) { // Declaração de método pra autenticar pela matricula e senha do aluno
        Optional<Aluno> alunoOpt = alunoRepository.findByMatricula(matricula);
        if (alunoOpt.isPresent()) {
            Aluno aluno = alunoOpt.get();
            // Aqui pode colocar criptografia depois, por enquanto compara direto
            return aluno.getSenha().equals(senha);
        } //Confere se a senha cadastrada é igual a senha utilizada no cadastro
        return false;
    } //
}
