package fute.sam.dcx;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;

public class CampeonatoBrasileiroTest {
    CampeonatoBrasileiro campeonato = new CampeonatoBrasileiro();
    @Test
    public void testaCadastrarEremoveTime () throws TimeNaoRemovidoException {

        int timesAtuais = campeonato.getListaTimes().size();
        assertEquals(timesAtuais, campeonato.getListaTimes().size());

        Time timeTest = new Time("TimeTeste", "-0015");
        campeonato.cadastrarTime(timeTest);
        int timesCadastrados = campeonato.getListaTimes().size();
        assertEquals(timesAtuais+1, timesCadastrados);
        timesAtuais++;

        campeonato.removerTime(timeTest);
        assertEquals(timesAtuais-1, campeonato.getListaTimes().size());
    }

    @Test
    public void testaCadastrarEremoveJogador() throws JaExisteJogadorExecption, TimeNaoExisteException, JaExisteNumeroCamisaExecption, NaoExisteJogadorException {

        int jogadoresAtuais = campeonato.getListaJogadores().size();
        assertEquals(jogadoresAtuais, campeonato.getListaJogadores().size());

        Jogador jogadorTeste = new Jogador("Jeremias", "20", "-2", "Flamengo", "-0025");
        campeonato.cadatrarJogador(jogadorTeste);

        int jogadoresCadastrados = campeonato.getListaJogadores().size();
        assertEquals(jogadoresAtuais+1, jogadoresCadastrados);
        jogadoresAtuais++;

        campeonato.revomerJogador(jogadorTeste.getCpf());
        assertEquals(jogadoresAtuais-1, campeonato.getListaJogadores().size());

        /** Teste manualmente, tem que saber o tamanho (.size) da lista atualizado, pra tentar manualmente */

//        assertEquals(1, campeonato.getListaJogadores().size()); //saber tamanho atual da lista e modificar
//        Jogador jogadorTeste = new Jogador("Jeremias", "20", "-1", "Flamengo", "0004");
//        campeonato.cadatrarJogador(jogadorTeste);
//        assertEquals(2, campeonato.getListaJogadores().size()); //soma +1 do numero do comentario acima e colocar nesse
//        campeonato.revomerJogador(jogadorTeste.getCpf());
//        assertTrue(campeonato.getListaJogadores().size()==1); //saber o tamanho quando remover

    }

//    @Test
//    public void

    @Test
    public void testaGravacaoJogador() throws JaExisteJogadorExecption, TimeNaoExisteException, JaExisteNumeroCamisaExecption, NaoExisteJogadorException {

        /** teste feito atualmente tendo so 1 jogador na lista, se aumentar os cadastro de jogadores,
        mude de 2 para o tamanho apropiado, pra nao dar bronca. */

        File f = new File("/dados.Jogadores.dat");
        if (f.exists()){
            f.delete();
        }

        // cadastrar jogador e salva, testa que possui 2 jogadores na lista
        Jogador jogadorTeste = new Jogador("Jeremias", "20", "1", "Flamengo", "0004");
        campeonato.cadatrarJogador(jogadorTeste);
        campeonato.salvarDados();
        assertEquals(2, campeonato.getListaJogadores().size());

        /** Remove esse jogador da lista e salva no gravador, se da proxima vez que rodar, ele tiver
        sido apagado no gravador, deu certo rodar 2 vezes pra ter certeza que funcionou */
        campeonato.revomerJogador(jogadorTeste.getCpf());
        campeonato.salvarDados();
        assertEquals(1, campeonato.getListaJogadores().size());
    }

    @Test
    public void testaGravadorTime() throws TimeNaoRemovidoException {
        File f = new File("dados.Times.dat");
        if (f.exists()){
            f.delete();
        }

        Time time = new Time("Timeteste", "pjTeste");
        campeonato.cadastrarTime(time);
        campeonato.salvarDados();
        assertEquals(2, campeonato.getListaTimes().size());

        campeonato.removerTime(time);
        campeonato.salvarDados();
        assertEquals(1, campeonato.getListaTimes().size());
    }
    @Test
    public void testaPesquisarJogadoresTime() throws TimeNaoExisteException, NaoExisteJogadorException {
        CampeonatoBrasileiro campeonato = new CampeonatoBrasileiro();
        String nomeTime = "Flamengo";
        int quantidadeDeJogadoresDesseTime = campeonato.pesquisarJogadoresDoTime(nomeTime).size();
        assertTrue(quantidadeDeJogadoresDesseTime > 0);

        for(Jogador j: campeonato.getListaJogadores()){
            if(j.getNomeTime().startsWith(nomeTime)){
                campeonato.revomerJogador(j.getCpf());
            }
        }
        assertTrue(campeonato.pesquisarJogadoresDoTime(nomeTime).isEmpty());
    }

//    String alteraNumeroJogador(String nomeTime, String cpf, String numeroCamisa) throws TimeNaoExisteException, NaoExisteJogadorException, NumeroDeCamisaJaExisteException;

    @Test
    public void testaAlterarNumeroJogador() throws JaExisteJogadorExecption, TimeNaoExisteException, JaExisteNumeroCamisaExecption, NumeroDeCamisaJaExisteException, NaoExisteJogadorException {


        Jogador jogadorTeste = new Jogador("jogado1", "20","-39", "Flamengo", "-1212");

        //Metodo AlterarNumeroJogador, retorna uma string se o número for alterado com sucesso, se não, lança uma exeção
        campeonato.cadatrarJogador(jogadorTeste);

        //variavel recebendo a String que sera retornada, caso o numero seja alterado.
        String textoAexibir = "Número do jogador " + jogadorTeste.getNome() + " trocado com sucesso!";
        assertEquals(textoAexibir, campeonato.alteraNumeroJogador(jogadorTeste.getNomeTime(), jogadorTeste.getCpf(),
                jogadorTeste.getNumero()));
    }

    @Test
    public void testaListaJogadores(){
        assertFalse(campeonato.getListaJogadores().isEmpty());
    }
    @Test
    public void testaListaTime(){
        assertFalse(campeonato.getListaTimes().isEmpty());
    }

}
