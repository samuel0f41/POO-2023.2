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
        String cpf = JOptionPane.showInputDialog(janelaPrincipal, "Digite CPF: ");
        try {
            JOptionPane.showMessageDialog(janelaPrincipal, campeonato.revomerJogador(cpf));
        } catch (NaoExisteJogadorException ex) {
            throw new RuntimeException(ex);
        }
    }
}

