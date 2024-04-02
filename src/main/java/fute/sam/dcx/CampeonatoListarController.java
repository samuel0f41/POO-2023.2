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
            opcao =JOptionPane.showInputDialog("Escolha (1/2)\n 1-  Ver Times\n 2- Ver Todos jogadores");
            if(opcao.equals("1")){
                JOptionPane.showMessageDialog(janelaPrincial,campeonato.getListaTimes());
            }else if(opcao.equals("2")){
                JOptionPane.showMessageDialog(janelaPrincial,campeonato.getListaJogadores());
            }
            opcao = "3";
        }


    }

}
