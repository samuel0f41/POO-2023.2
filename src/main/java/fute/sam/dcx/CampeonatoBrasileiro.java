package fute.sam.dcx;

import java.io.IOException;
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
            this.gravadorJogadores.gravaJogadores(this.listaJogadores);
            this.gravadorTimes.gravaTimes(this.listaTimes);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public String cadatrarJogador(Jogador jogador) throws JaExisteJogadorExecption {
        if(!listaJogadores.containsKey(jogador.getCpf()) ){
            listaJogadores.put(jogador.getCpf(), jogador);
            return "Jogador cadastrado com sucesso: " + jogador;
        }
        throw new JaExisteJogadorExecption("Não foi possível cadastrar. Jogador já existe.");
    }

    public String RevomerJogadorNoTime(String nomeTime, Jogador jogador) throws NaoExisteJogadorException, TimeNaoExisteException{
        if(listaTimes.containsKey(nomeTime)){
            for(Time t:  listaTimes.values()){
                List<Jogador> listaJogadoresDesseTime = t.getListaJogadoresDoTime();
                for(Jogador j: listaJogadoresDesseTime){
                    if(j.getCpf().equals(jogador.getCpf())){
                        t.removerJogador(jogador);
                        return "Jogador "+ jogador.getNome() + " removido do time "+ nomeTime+ ".";
                    }
                }
                throw new NaoExisteJogadorException("Não existe jogador com esse nome!");
            }
        }
        throw new TimeNaoExisteException("Não existe esse Time cadastrado!");

    }

    @Override
    public String adicionarJogadorNoTime(String nomeTime, Jogador jogador) throws NaoExisteJogadorException, TimeNaoExisteException {
        //se o jogador não tem time, entao tenta cadastrar
        if (!verificarJogadorSeEstaSemTime(jogador.getCpf())) {
            Time time = listaTimes.get(nomeTime);
            if (time != null) {
                time.adicionarJogador(jogador);
                return jogador.toString() + "Cadastrado com sucesso";
            }
            throw new TimeNaoExisteException("Time digitado não existe ou não esta cadastrado, tente outro!");
        }
        return "Não pode cadastrar esse jogador, pois ele ja esta em um time, tente outro!";
    }
    public boolean  verificarJogadorSeEstaSemTime(String cpf)throws NaoExisteJogadorException {
        if(!listaJogadores.containsKey(cpf)){
            throw new NaoExisteJogadorException("Jogador Nao encontrado, tente outro CPF");
        }
        for(Jogador j: listaJogadores.values()){
            if(j.getCpf().equals(cpf) && !j.getNomeTime().isEmpty() ){
                return true;
            }
        }
        return false;
    }

    @Override
    public void alteraNumeroJogador(String nomeTime, String nomeJogador, String numeroCamisa) throws TimeNaoExisteException, NaoExisteJogadorException, NumeroDeCamisaJaExisteException {
        if (!listaTimes.containsKey(nomeTime)) {
            throw new TimeNaoExisteException("Não existe esse time: " + nomeTime);
        }

        Time time = listaTimes.get(nomeTime);
        List<Jogador> listaJogadoresDoTime = time.getListaJogadoresDoTime();

        // Verificar se o número da camisa já está em uso por outro jogador
        for (Jogador jogador : listaJogadoresDoTime) {
            if (!jogador.getNome().equals(nomeJogador) && jogador.getNumero().equals(numeroCamisa)) {
                throw new NumeroDeCamisaJaExisteException("O número da camisa " + numeroCamisa + " já está sendo usado por outro jogador.");
            }
        }
        // Encontrar o jogador pelo nome e atualizar o número da camisa
        boolean jogadorEncontrado = false;
        for (Jogador jogador : listaJogadoresDoTime) {
            if (jogador.getNome().equals(nomeJogador)) {
                jogador.setNumero(numeroCamisa);
                jogadorEncontrado = true;
                break; // Não precisamos continuar procurando
            }
        }

        if (!jogadorEncontrado) {
            throw new NaoExisteJogadorException("Não existe esse jogador: " + nomeJogador);
        }
        time.setListaJogadoresDoTime(listaJogadoresDoTime);
    }
    @Override
    public List<Jogador> pesquisarJogadoresDoTime(String nomeTime) throws TimeNaoExisteException{
        Time time = listaTimes.get(nomeTime);
        if(time != null){
            return time.getListaJogadoresDoTime();
        }
        throw new TimeNaoExisteException("Esse time não existe, pesquise por outro");
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

    public void setListaTimes(Map<String, Time> listaTimes) {
        this.listaTimes = listaTimes;
    }



}//FIM DA CLASS
