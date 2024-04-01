package fute.sam.dcx;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CampeonatoRemoveController implements ActionListener {
        private SistemaCampeonato campeonato;
        private JFrame janelaPrincipal;

    public CampeonatoRemoveController(SistemaCampeonato campeonato, JFrame janela){
            this.campeonato = campeonato;
            this.janelaPrincipal = janela;
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opcao = "0";

        while (!opcao.equals("3")){
            opcao = JOptionPane.showInputDialog(janelaPrincipal, "REMOVER escolha (1/2) \n" +
                    "1- Time\n 2- Jogador");
            if(opcao.equals("1")){
                String nome = JOptionPane.showInputDialog(janelaPrincipal, "Nome do Time: ");
                String cnpj = JOptionPane.showInputDialog(janelaPrincipal, "CNPJ: ");
                Time timeRemover = new Time(nome, cnpj);
                try {
                    JOptionPane.showMessageDialog(janelaPrincipal, campeonato.removerTime(timeRemover));
                } catch (TimeNaoRemovidoException ex) {
                    throw new RuntimeException(ex);
                }
            }else if (opcao.equals("2")){
                String cpf = JOptionPane.showInputDialog(janelaPrincipal, "Digite CPF: ");
                try {
                    JOptionPane.showMessageDialog(janelaPrincipal, campeonato.revomerJogador(cpf));
                } catch (NaoExisteJogadorException ex) {
                    throw new RuntimeException(ex);
                }
            }
            opcao = "3";
        }

    }
}

