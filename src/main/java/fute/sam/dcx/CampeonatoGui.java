package fute.sam.dcx;

import javax.swing.*;
import java.awt.*;
public class CampeonatoGui extends JFrame {
    JLabel linha1, linha2;
    ImageIcon brasileirao;
    CampeonatoBrasileiro campeonato = new CampeonatoBrasileiro();
    JMenuBar barraMenu = new JMenuBar();
    public CampeonatoGui(){

        setTitle("Gerenciador do campeonato Brasileiro 2024");
        setSize(950, 650);
        setLocation(300,110);
        setResizable(false);
        setBackground(Color.white);

        brasileirao = new ImageIcon("./imgs/bra2.png");

        Image imagemOriginal = brasileirao.getImage();
        Image imagemRedimensionada = imagemOriginal.getScaledInstance(875, 455, Image.SCALE_SMOOTH);
        brasileirao = new ImageIcon(imagemRedimensionada);

        linha1 = new JLabel("Campeonato Brasileiro 2024", JLabel.CENTER);
        linha1.setForeground(Color.blue);
        linha1.setFont(new Font("Serif", Font.BOLD, 40));
        add(linha1, BorderLayout.NORTH);

        linha2 = new JLabel(brasileirao, JLabel.CENTER);
        add(linha2, BorderLayout.CENTER);
        // Setando o fundo da linha2 como transparente para que a imagem de fundo do JFrame seja visível
        linha2.setOpaque(false);

        setJMenuBar(barraMenu);
        setVisible(true);

        add(linha1);
        add(linha2);
        add(new JLabel());
        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenuItem menuCadastrarTimeEJogadores = new JMenuItem("Time ou Jogador");
        menuCadastrar.add(menuCadastrarTimeEJogadores);

        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuPesquisarJogador = new JMenuItem("Jogadores do Time");
        menuPesquisar.add(menuPesquisarJogador);

        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverJogador = new JMenuItem("Time ou Jogador");
        menuRemover.add(menuRemoverJogador);

        JMenu menuAlteraNumero = new JMenu("Alterar");
        JMenuItem menuAlteraNumeroJogador = new JMenuItem("Numero Jogador");
        menuAlteraNumero.add(menuAlteraNumeroJogador);

        JMenu menuListar = new JMenu("Listar");
        JMenuItem menuListarTimeOUjogador = new JMenuItem("Time ou jogador");
        menuListar.add(menuListarTimeOUjogador);

        JMenu menuSalvar = new JMenu("Salvar");
        JMenuItem menuSalvarDados = new JMenuItem("Dados atuais");
        menuSalvar.add(menuSalvarDados);

        menuPesquisarJogador.addActionListener( new CampeonatoSearchController(campeonato, this));
        menuCadastrarTimeEJogadores.addActionListener(new CampeonatoAddController(campeonato, this));
        menuRemoverJogador.addActionListener(new CampeonatoRemoveController(campeonato, this));
        menuAlteraNumeroJogador.addActionListener(new CampeonatoAlteraNumController(campeonato, this));
        menuListarTimeOUjogador.addActionListener(new CampeonatoListarController(campeonato, this));
        menuSalvarDados.addActionListener((ae) -> {
            campeonato.salvarDados();
        });

        barraMenu.add(menuCadastrar);
        barraMenu.add(menuPesquisar);
        barraMenu.add(menuRemover);
        barraMenu.add(menuAlteraNumero);
        barraMenu.add(menuListar);
        barraMenu.add(menuSalvar);
        setJMenuBar(barraMenu);

    }

    public static void main(String [] args){
        JFrame janela = new CampeonatoGui();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
