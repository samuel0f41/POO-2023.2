package fute.sam.dcx;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CampeonatoAddController implements ActionListener {
    private SistemaCampeonato campeonato;
    private JFrame janelaPrincipal;

    public CampeonatoAddController(SistemaCampeonato campeonato, JFrame janela){
        this.campeonato = campeonato;
        this.janelaPrincipal = janela;
    }
    public void actionPerformed(ActionEvent e){
        String opcao = "0";
        while(!opcao.equals("3")){
            opcao = JOptionPane.showInputDialog("Escola (1/2 ou 3 para voltar) " +
                    "\n1- Cadastrar um Time \n2- Cadastrar Jogador");

            if(opcao.equals("1")){
                String nome = JOptionPane.showInputDialog(janelaPrincipal, " Digite nome do Time");
                String pj = JOptionPane.showInputDialog(janelaPrincipal, "CNPJ: ");
                Time novoTime = new Time(nome, pj);
                JOptionPane.showMessageDialog(janelaPrincipal, campeonato.cadastrarTime(novoTime));

            }else if (opcao.equals("2")){
                String nome = JOptionPane.showInputDialog(janelaPrincipal, " Digite nome do jogador");
                String idade = JOptionPane.showInputDialog(janelaPrincipal, "Digite idade: ");
                String numero = JOptionPane.showInputDialog(janelaPrincipal, "Número da camisa: ");
                String nomeTime = JOptionPane.showInputDialog(janelaPrincipal, "Time: ");
                String cpf = JOptionPane.showInputDialog(janelaPrincipal, "CPF: ");

                try{
                    Jogador jogador = new Jogador(nome,idade,numero,nomeTime,cpf);
                    JOptionPane.showMessageDialog(janelaPrincipal, campeonato.cadatrarJogador(jogador));
                }catch (JaExisteJogadorExecption ex) {
                    throw new RuntimeException(ex);
                } catch (JaExisteNumeroCamisaExecption ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

    }


}
