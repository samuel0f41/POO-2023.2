package fute.sam.dcx;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface SistemaCampeonato {

    String cadatrarJogador(Jogador jogador) throws JaExisteJogadorExecption, JaExisteNumeroCamisaExecption;
    String cadastrarTime(Time time);
    String revomerJogador(String cpf) throws NaoExisteJogadorException;
    String alteraNumeroJogador(String nomeTime, String cpf, String numeroCamisa) throws TimeNaoExisteException, NaoExisteJogadorException, NumeroDeCamisaJaExisteException;
    Collection<Jogador> pesquisarJogadoresDoTime(String nomeTime) throws TimeNaoExisteException;
    void sairDoSistema();
    void removerTime(Time time) throws TimeNaoRemovidoException;
    Map<String, Jogador> getListaJogadores();
    Map<String, Time> getListaTimes();

}
