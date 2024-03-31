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
            Collection<Jogador> jogadores = campeonato.pesquisarJogadoresDoTime(nomeTime);
            JOptionPane.showMessageDialog(janelaPrincipal, "Jogador encontrado: ");
            for(Jogador j: jogadores){
                JOptionPane.showMessageDialog(janelaPrincipal, j.toString());
            }
        } catch (TimeNaoExisteException ex) {
            throw new RuntimeException(ex);
        }

    }

}
