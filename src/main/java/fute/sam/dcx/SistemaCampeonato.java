package fute.sam.dcx;

import java.util.Collection;

public interface SistemaCampeonato {

    String cadatrarJogador(Jogador jogador) throws JaExisteJogadorExecption, JaExisteNumeroCamisaExecption, TimeNaoExisteException;
    String cadastrarTime(Time time);
    String revomerJogador(String cpf) throws NaoExisteJogadorException;
    String removerTime(Time time) throws TimeNaoRemovidoException;
    String alteraNumeroJogador(String nomeTime, String cpf, String numeroCamisa) throws TimeNaoExisteException, NaoExisteJogadorException, NumeroDeCamisaJaExisteException;
    Collection<Jogador> pesquisarJogadoresDoTime(String nomeTime) throws TimeNaoExisteException;
    void salvarDados();
    Collection<Jogador> getListaJogadores();
    Collection<Time> getListaTimes();

}
