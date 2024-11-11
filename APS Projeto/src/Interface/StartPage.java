package Interface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPage extends JFrame{
    private JButton visualizarPokemonsButton;
    private JButton visualizarTiposButton;
    private JPanel StartPage;
    private JButton alterarPokemonsButton;
    private JButton alterarTiposButton;

    public StartPage(){
        setTitle("JavaDex - Inicio");
        setContentPane(StartPage);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,500);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        visualizarPokemonsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new VisuPokes();
            }
        });
        visualizarTiposButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new VisuTipos();
            }
        });
        alterarPokemonsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AltPokes();
            }
        });
        alterarTiposButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AltTipos();
            }
        });
    }
}
