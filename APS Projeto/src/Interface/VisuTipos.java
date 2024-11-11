package Interface;

import Creation.Tipo;
import SQL.DAO.SQLSelect;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VisuTipos extends JFrame{
    private JMenu menu;
    private JMenuItem inicio;
    private JMenuItem visuPoke;
    private JMenuItem visuTipo;
    private JPanel VisuTipos;
    private JMenuItem altPokes;
    private JMenuItem altTipos;
    private JScrollPane TablePane;
    private JComboBox cbView;
    private JButton visualizarButton;

    VisuTipos(){
        setTitle("JavaDex - Visualizar Tipos");
        setContentPane(VisuTipos);
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,500);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        ArrayList<Tipo> tipos = SQLSelect.getTipos();

        for (Tipo tipo : tipos){
            cbView.addItem(tipo.getNome());
        }

        visualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tipo tipo = SQLSelect.getTipo(String.valueOf(cbView.getSelectedItem()));
                String res = "Nome:" + tipo.getNome();
                res += "\nForças:" + tipo.getForc();
                res += "\nFraquezas:" + tipo.getFraq();
                JOptionPane.showMessageDialog(null,res,"Visão Extendida de " + tipo.getNome(),JOptionPane.INFORMATION_MESSAGE);
            }
        });

        TipoTableModel tipoTableModel = new TipoTableModel(tipos);
        JTable tipoTable = new JTable(tipoTableModel);
        TablePane.setViewportView(tipoTable);



        inicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StartPage();
            }
        });
        visuPoke.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new VisuPokes();
            }
        });
        visuTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new VisuTipos();
            }
        });
        altPokes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AltPokes();
            }
        });
        altTipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AltTipos();
            }
        });
    }
}
