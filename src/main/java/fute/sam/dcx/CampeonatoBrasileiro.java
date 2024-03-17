package fute.sam.dcx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CampeonatoBrasileiro implements SistemaClube {
    private Map<String, Time> listaTimes;
    private Map<String, Jogador> listaJogadores;
    GravadorDeTime gravadorTimes = new GravadorDeTime();
    GravadorDeJogadores gravadorJogadores = new GravadorDeJogadores();

    public CampeonatoBrasileiro(){
        try {
            this.listaTimes = gravadorTimes.leTimes();
            this.listaJogadores = gravadorJogadores.leJogadores();
        }catch (IOException e){
            System.err.println((e.getMessage()));
            this.listaTimes = new HashMap<>();
            this.listaJogadores = new HashMap<>();
        }
    }

    public void sairDoSistema(){
        try {
            this.gravadorTimes.gravaTimes(this.listaTimes);
            this.gravadorJogadores.gravaJogadores(this.listaJogadores);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public String cadatrarJogador(Jogador jogador) throws JaExisteJogadorExecption, JaExisteNumeroCamisaExecption {
        if(!listaJogadores.containsKey(jogador.getCpf())  && !listaJogadores.containsKey(jogador.getNumero()) ){
            listaJogadores.put(jogador.getNome(), jogador);
            return "Jogador cadastrado com sucesso: " + jogador;
        }else if(listaJogadores.containsKey(jogador.getNumero())){
            throw new JaExisteNumeroCamisaExecption("Ja possui um jogador com esse numero de camisa!");
        }
        throw new JaExisteJogadorExecption("Não foi possível cadastrar. Jogador já existe.");
    }

    public String revomerJogador(String cpf) throws NaoExisteJogadorException{
        if(!listaJogadores.containsKey(cpf)) {
            throw new NaoExisteJogadorException("Nenhum jogador encontrado com esse CPF");
        }
        Jogador jogadorRemovido = listaJogadores.remove(cpf);
        return "jogador " + jogadorRemovido.getNome() + " removido!";
    }

    @Override
    public String alteraNumeroJogador(String nomeTime, String cpf, String numeroCamisa) throws TimeNaoExisteException, NaoExisteJogadorException, NumeroDeCamisaJaExisteException {
        if(listaTimes.containsKey(nomeTime)){
            throw new TimeNaoExisteException("Não existe esse time!");
        }

        Jogador jogadorEncontrado = null;
        if(listaJogadores.containsKey(cpf)){
            jogadorEncontrado = listaJogadores.get(cpf);
        }
        if(jogadorEncontrado == null){
            throw new NaoExisteJogadorException("Nenhum jogador encontrado com esse CPF!");
        }

        for(Jogador j: listaJogadores.values()){
            if(!j.getCpf().equals(jogadorEncontrado.getCpf()) && j.getNomeTime().equals(nomeTime) && j.getNumero().equals(numeroCamisa)){
                    throw new NumeroDeCamisaJaExisteException("Não foi possivel troca de numero, ja possui um c");
            }
        }
        jogadorEncontrado.setNumero(numeroCamisa);
        return "Número do jogador " + jogadorEncontrado.getNome() + " trocado com sucesso!";
    }

    @Override
    public List<Jogador> pesquisarJogadoresDoTime(String nomeTime) throws TimeNaoExisteException{

        if (listaTimes.containsKey(nomeTime)) {
            throw new TimeNaoExisteException("Esse time não existe, pesquise por outro");
        }
        List<Jogador> jogadoresDoTime = new ArrayList<>();
        for(Jogador j: listaJogadores.values()){
            if(j.getNomeTime().equals(nomeTime)){
                jogadoresDoTime.add(j);
            }
        }

        return jogadoresDoTime;
    }

    @Override
    public String cadastrarTime(Time time) {
        if (!listaTimes.containsKey(time.getPJ())) {
            this.listaTimes.put(time.getPJ(), time);
            return "Time cadastrado!";
        }
        return "NÃO FOI POSSÍVEL CADASTRAR ESSE TIME, POIS ELE JÁ EXISTE";
    }


    public void removerTime(Time time) throws TimeNaoRemovidoException{
        if(listaTimes.containsKey(time.getPJ())){
            listaTimes.remove(time.getPJ());
        }else{
            throw new TimeNaoRemovidoException("TIME NÃO ENCONTRADO, TENTE OUTRO!");
        }
    }

    public Map<String, Time> getListaTimes() {
        return listaTimes;
    }

    @Override
    public String toString() {
        return "Times = " + listaTimes +
                "\nJogadores do campeonato =" + listaJogadores;
    }

    public void setListaTimes(Map<String, Time> listaTimes) {
        this.listaTimes = listaTimes;
    }

    public Map<String, Jogador> getListaJogadores() {
        return listaJogadores;
    }

    public void setListaJogadores(Map<String, Jogador> listaJogadores) {
        this.listaJogadores = listaJogadores;
    }
}//FIM DA CLASS
