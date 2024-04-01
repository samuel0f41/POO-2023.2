package fute.sam.dcx;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class CampeonatoSearchController implements ActionListener {
    private SistemaCampeonato campeonato;
    private JFrame janelaPrincipal;

    public CampeonatoSearchController(SistemaCampeonato campeonato, JFrame janela){
        this.campeonato = campeonato;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e){
        String nomeTime = JOptionPane.showInputDialog(janelaPrincipal,
                "Time: ");
        try {
            JOptionPane.showMessageDialog(janelaPrincipal, "Jogadores do "+ nomeTime+ ": \n" +
                    campeonato.pesquisarJogadoresDoTime(nomeTime));
        } catch (TimeNaoExisteException ex) {
            throw new RuntimeException(ex);
        }

    }

}
