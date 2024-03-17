package fute.sam.dcx;

import java.io.Serializable;
import java.util.Objects;

public class Jogador implements Serializable {
    private String nome;
    private String idade;
    private String numero;
    private String nomeTime;
    private String cpf;

    public Jogador(String nome, String idade, String numero, String nomeTime, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.numero = numero;
        this.nomeTime = nomeTime;
        this.cpf = cpf;
    }

    public boolean temTime() {
        return !nomeTime.isEmpty();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String toString(){
        return "Jogador: "+ this.nome + "- Idade: " + this.idade+ " Numero "+this.numero + "CPF: " + this.cpf +"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jogador jogador = (Jogador) o;

        return Objects.equals(cpf, jogador.cpf);
    }

    @Override
    public int hashCode() {
        return cpf != null ? cpf.hashCode() : 0;
    }
}
