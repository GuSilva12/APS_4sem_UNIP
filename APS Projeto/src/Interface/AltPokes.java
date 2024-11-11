package Interface;


import Creation.Pokemon;
import Creation.Tipo;
import SQL.DAO.SQLCreate;
import SQL.DAO.SQLSelect;
import SQL.DAO.SQLUpdate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AltPokes extends JFrame{
    private JMenu menu;
    private JMenuItem inicio;
    private JMenuItem visuPoke;
    private JMenuItem visuTipo;
    private JMenuItem altPokes;
    private JMenuItem altTipos;
    private JPanel AltPokes;
    private JTabbedPane tabbedPane1;
    private JTextField tfNome;
    private JComboBox cbTipo1;
    private JComboBox cbTipo2;
    private JTextArea taDesc;
    private JButton adicionarButton;
    private JComboBox cbPokemons;
    private JButton removerButton;

    AltPokes(){
        setTitle("JavaDex - Alterar Pokemons");
        setContentPane(AltPokes);
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,500);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        taDesc.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        taDesc.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "none");

        ArrayList<Pokemon> pokemons = SQLSelect.getPokemons();
        ArrayList<Tipo> tipos = SQLSelect.getTipos();


        //PAGINA ADICIONAR
        for(Tipo tipo : tipos){
            cbTipo1.addItem(tipo.getNome());
            cbTipo2.addItem(tipo.getNome());
        }
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tfNome.getText().isEmpty()){
                    String nome = tfNome.getText();
                    String tipo1 = String.valueOf(cbTipo1.getSelectedItem());
                    String tipo2 = String.valueOf(cbTipo2.getSelectedItem());
                    String desc = taDesc.getText();
                    if(tipo1.equals(tipo2)){
                        SQLCreate.createPokemon(new Pokemon(nome,desc,tipo1,tipo1));
                    }else{
                        SQLCreate.createPokemon(new Pokemon(nome,desc,tipo1,tipo2));
                    }
                    JOptionPane.showMessageDialog(null,"Pokemon criado com sucesso.","Ação Concluida",JOptionPane.INFORMATION_MESSAGE);
                    new AltPokes();
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"O nome não pode ser vazio.","Erro de ação",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //PAGINA PARA REMOVER
        for(Pokemon pokemon : pokemons){
            cbPokemons.addItem(pokemon.getNome());
        }
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean actionPerformed = SQLUpdate.deletePokemon(String.valueOf(cbPokemons.getSelectedItem()));
                if(actionPerformed){
                    JOptionPane.showMessageDialog(null,"Pokemon removido com sucesso.", "Ação Concluida",JOptionPane.INFORMATION_MESSAGE);
                    new AltPokes();
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"Pokemon não foi encontrado.", "Erro de Ação",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //MENU
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
