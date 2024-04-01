package fute.sam.dcx;

import java.io.IOException;
import java.util.*;

public class CampeonatoBrasileiro implements SistemaCampeonato {
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

    public void salvarDados(){
        try {
            this.gravadorTimes.gravaTimes(this.listaTimes);
            this.gravadorJogadores.gravaJogadores(this.listaJogadores);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public String cadatrarJogador(Jogador jogador) throws JaExisteJogadorExecption, JaExisteNumeroCamisaExecption, TimeNaoExisteException {
        if(listaJogadores.containsKey(jogador.getCpf())){
            throw new JaExisteJogadorExecption("Não foi possível cadastrar. Jogador já existe.");
        }

        boolean timeAchou = false;
        for(Time t:listaTimes.values()){
            if(t.getNome().startsWith(jogador.getNomeTime())){
               timeAchou = true;
            }
        }
        if(!timeAchou){
            throw new TimeNaoExisteException("Não existe time com esse nome");
        }


        boolean numeroCamisaRepetido = false;
        for(Jogador j: listaJogadores.values()){
            if(j.getNumero().equals(jogador.getNumero())){
                numeroCamisaRepetido = true;
            }
        }
        if(numeroCamisaRepetido){
            throw new JaExisteNumeroCamisaExecption("Ja possui um jogador com a camisa: "+ jogador.getNumero()+ " Tente outro numero");
        }
        listaJogadores.put(jogador.getCpf(), jogador);
        return "Jogador: "+jogador+ " cadastrado!";


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
            if(!j.getCpf().equals(jogadorEncontrado.getCpf()) && j.getNomeTime().startsWith(nomeTime) && j.getNumero().equals(numeroCamisa)){
                    throw new NumeroDeCamisaJaExisteException("Não foi possivel troca de numero, ja possui um c");
            }
        }
        jogadorEncontrado.setNumero(numeroCamisa);
        return "Número do jogador " + jogadorEncontrado.getNome() + " trocado com sucesso!";
    }

    @Override
    public Collection<Jogador> pesquisarJogadoresDoTime(String nomeTime) throws TimeNaoExisteException{
        Collection<Jogador> jogadoresDoTime = new ArrayList<>();
        for(Jogador j: listaJogadores.values()){
            if(j.getNomeTime().startsWith(nomeTime)){
                jogadoresDoTime.add(j);
            }
        }
        for(Time t: listaTimes.values()){
            if(!t.getNome().equals(nomeTime)){
                throw new TimeNaoExisteException("Esse time não existe, pesquise por outro");
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


    public String removerTime(Time time) throws TimeNaoRemovidoException{
        if(listaTimes.containsKey(time.getPJ())){
            listaTimes.remove(time.getPJ());
        }else{
            throw new TimeNaoRemovidoException("TIME NÃO ENCONTRADO, TENTE OUTRO!");
        }
        return "Time "+ time+ " Revomido!";
    }

    public Collection<Time> getListaTimes() {
        Collection<Time> times = new LinkedList<>();
        for(Time t: listaTimes.values()){
            times.add(t);
        }
        return times;
    }

    @Override
    public String toString() {
        return "Times = " + listaTimes +
                "\nJogadores do campeonato =" + listaJogadores;
    }
    public  Collection<Jogador> getListaJogadores() {
        Collection<Jogador> jogadores = new LinkedList<>();
        for(Jogador j: listaJogadores.values()){
            jogadores.add(j);
        }
        return jogadores;
    }

}//FIM DA CLASS
