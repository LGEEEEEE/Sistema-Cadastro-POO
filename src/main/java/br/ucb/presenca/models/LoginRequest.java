package br.ucb.presenca.models; // Define o pacote ao qual esta classe pertence

public class LoginRequest { // Declaração da classe
    private String matricula; // Declaração de variável ou atributo
    private String senha; // Declaração de variável ou atributo

    public String getMatricula() { // Declaração de método
        return matricula;
    } // Fim de um bloco de código
    public void setMatricula(String matricula) { // Declaração de método
        this.matricula = matricula;
    } // Fim de um bloco de código
    public String getSenha() { // Declaração de método
        return senha;
    } // Fim de um bloco de código
    public void setSenha(String senha) { // Declaração de método
        this.senha = senha;
    } // Fim de um bloco de código
} // Fim de um bloco de código
