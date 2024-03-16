package fute.sam.dcx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Time implements Serializable {
    private String nome;
    private List<Jogador> listaJogadoresDoTime;
    private String PJ;

    public Time(String nome, String pj){
        this.nome = nome;
        this.listaJogadoresDoTime = new ArrayList<>();
        this.PJ = pj;
    }


    public String getPJ() {
        return PJ;
    }

    public void setPJ(String PJ) {
        this.PJ = PJ;
    }

    public void adicionarJogador(Jogador jogador){
        this.listaJogadoresDoTime.add(jogador);
    }
    public void removerJogador(Jogador jogador){
        this.listaJogadoresDoTime.remove(jogador);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Jogador> getListaJogadoresDoTime() {
        return listaJogadoresDoTime;
    }

    public void setListaJogadoresDoTime(List<Jogador> listaJogadoresDoTime) {
        this.listaJogadoresDoTime = listaJogadoresDoTime;
    }
}
