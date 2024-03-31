package fute.sam.dcx;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestaCampeonato {
    public static void main(String [] args) throws NaoExisteJogadorException, TimeNaoExisteException, NumeroDeCamisaJaExisteException, TimeNaoRemovidoException, JaExisteJogadorExecption, JaExisteNumeroCamisaExecption {
        SistemaCampeonato campeonato = new CampeonatoBrasileiro();

        String x = JOptionPane.showInputDialog("Menu \n1- Cadastrar \n2- Remover \n3- Pequisar jogadores do Time " +
                "\n4- Alterar numero do jogador\n5- Lista de jogadores e time\n6- sair" );
        while(!x.equals("7")){

            if(x.equals("1")){

                String y = JOptionPane.showInputDialog("1- Cadastrar Time \n2- Cadastrar jogador");
                if(y.equals("1")){
                    String nome = JOptionPane.showInputDialog(null, "Digite nome do time: ");
                    String PJ = JOptionPane.showInputDialog(null, "Digite CNJP: ");
                    Time time = new Time(nome, PJ);
                    campeonato.cadastrarTime(time);
                }else if(y.equals("2")){
                    String nome = JOptionPane.showInputDialog(null, "Digite nome do jogador: ");
                    String idade = JOptionPane.showInputDialog(null, "idade: ");
                    String numeroCamisa = JOptionPane.showInputDialog(null, "Numero da camisa: ");
                    String nomeDoTime = JOptionPane.showInputDialog(null, "Time de atuação: ");
                    String PF = JOptionPane.showInputDialog(null, "CPF: ");
                    Jogador j = new Jogador(nome, idade, numeroCamisa, nomeDoTime, PF);
                    campeonato.cadatrarJogador(j);
                }
            }else if(x.equals("2")){
                String y = JOptionPane.showInputDialog("1- Remover Time \n 2- Remover jogador do Time");
                if(y.equals("1")){
                    String nomeTime = JOptionPane.showInputDialog(null, "Digite Nome do Time: ");
                    String PJ = JOptionPane.showInputDialog(null, "Digite CPF do jogador: ");
                    Time t = new Time(nomeTime, PJ);
                    campeonato.removerTime(t);
                }else if(y.equals("2")){
                    String PF = JOptionPane.showInputDialog(null, "CPF do jogador: ");
                    campeonato.revomerJogador(PF);
                }

            }else if(x.equals("3")){
                String nomeTime = JOptionPane.showInputDialog(null, "Nome do Time: ");
                Collection<Jogador> jogadoresTime = campeonato.pesquisarJogadoresDoTime(nomeTime);
                JOptionPane.showMessageDialog(null, jogadoresTime );

            }else if(x.equals("4")){
                String nomeTime = JOptionPane.showInputDialog(null, "Nome do Time: ");
                String nomeJogador = JOptionPane.showInputDialog(null, "Nome do jogador: ");
                String numeroCamisa = JOptionPane.showInputDialog(null, "Novo Numero da camisa:");
                campeonato.alteraNumeroJogador(nomeTime, nomeJogador, numeroCamisa);
            }else if(x.equals("5")){
                String y = JOptionPane.showInputDialog("1- Listar todos os Times \n2- Listar todos jogadores");
                if (y.equals("1")) {
                    List<Time> times = new ArrayList<>(campeonato.getListaTimes().values());
                    JOptionPane.showMessageDialog(null, times);
                } else if (y.equals("2")) {
                    List<Jogador> jogadores = new ArrayList<>(campeonato.getListaJogadores().values());
                    JOptionPane.showMessageDialog(null, jogadores);
                }
            }else if(x.equals("6")){
                campeonato.sairDoSistema();
                x = "7";
            }
            if(!x.equals("7")){
                x = JOptionPane.showInputDialog("Menu \n1- Cadastrar \n2- Remover \n3- Pequisar jogadores do Time " +
                        "\n4- Alterar numero do jogador\n5- Lista de jogadores e time\n6- sair" );
            }

        }//FIM DO WHILE
    }//FIM DO MAIN
}//FIM DA CLASS
