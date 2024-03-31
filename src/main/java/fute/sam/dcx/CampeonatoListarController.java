package fute.sam.dcx;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CampeonatoListarController implements ActionListener {
    private CampeonatoBrasileiro campeonato;
    private JFrame janelaPrincial;
    public CampeonatoListarController(CampeonatoBrasileiro campeonato, JFrame janela) {
        this.campeonato = campeonato;
        this.janelaPrincial = janela;
    }

    public void actionPerformed(ActionEvent e) {

        String opcao = "0";
        while(!opcao.equals("3")){
            opcao =JOptionPane.showInputDialog("Escolha (1/2 ou 3 para voltar ao menu)\n 1- Listar jogadores\n 2- Listar Times");
            if(opcao.equals("1")){
                JOptionPane.showMessageDialog(janelaPrincial,campeonato.getListaJogadores());
            }else if(opcao.equals("2")){
                JOptionPane.showMessageDialog(janelaPrincial,campeonato.getListaTimes());
            }
        }


    }

}
