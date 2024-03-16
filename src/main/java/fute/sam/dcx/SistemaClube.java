package fute.sam.dcx;

import java.util.List;

public interface SistemaClube {

    String cadatrarJogador(Jogador jogador) throws JaExisteJogadorExecption;
    String cadastrarTime(Time time);
    String adicionarJogadorNoTime(String nomeTime, Jogador jogador) throws NaoExisteJogadorException, TimeNaoExisteException;
    String RevomerJogadorNoTime(String nomeTime, Jogador jogador) throws NaoExisteJogadorException, TimeNaoExisteException;
    void alteraNumeroJogador(String nomeTime, String nomeJogador, String numeroCamisa) throws TimeNaoExisteException, NaoExisteJogadorException, NumeroDeCamisaJaExisteException;
    List<Jogador> pesquisarJogadoresDoTime(String nome) throws TimeNaoExisteException;
    void sairDoSistema();

    void removerTime(Time time) throws TimeNaoRemovidoException;

}
