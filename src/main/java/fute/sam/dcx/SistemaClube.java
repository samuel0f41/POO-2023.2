package fute.sam.dcx;

import java.util.List;
import java.util.Map;

public interface SistemaClube {

    String cadatrarJogador(Jogador jogador) throws JaExisteJogadorExecption, JaExisteNumeroCamisaExecption;
    String cadastrarTime(Time time);
    String revomerJogador(String cpf) throws NaoExisteJogadorException;
    String alteraNumeroJogador(String nomeTime, String cpf, String numeroCamisa) throws TimeNaoExisteException, NaoExisteJogadorException, NumeroDeCamisaJaExisteException;
    List<Jogador> pesquisarJogadoresDoTime(String nomeTime) throws TimeNaoExisteException;
    void sairDoSistema();
    void removerTime(Time time) throws TimeNaoRemovidoException;
    Map<String, Jogador> getListaJogadores();
    Map<String, Time> getListaTimes();

}
