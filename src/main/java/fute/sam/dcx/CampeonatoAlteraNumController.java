package fute.sam.dcx;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CampeonatoAlteraNumController implements ActionListener {
    private SistemaCampeonato campeonato;
    private JFrame janelaPrincipal;

    public CampeonatoAlteraNumController(SistemaCampeonato campeonato, JFrame janela){
        this.campeonato = campeonato;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog("Nome do jogador: ");
        String cpf = JOptionPane.showInputDialog("CPF: ");
        String numero = JOptionPane.showInputDialog("Novo numero para jogador: ");

        try {
            JOptionPane.showMessageDialog(janelaPrincipal, campeonato.alteraNumeroJogador(nome, cpf, numero));
        } catch (TimeNaoExisteException ex) {
            throw new RuntimeException(ex);
        } catch (NaoExisteJogadorException ex) {
            throw new RuntimeException(ex);
        } catch (NumeroDeCamisaJaExisteException ex) {
            throw new RuntimeException(ex);
        }
    }



}
