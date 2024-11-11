package Interface;

import Creation.Pokemon;
import SQL.DAO.SQLSelect;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VisuPokes extends JFrame{
    private JMenu menu;
    private JMenuItem inicio;
    private JMenuItem visuPoke;
    private JPanel VisuPokes;
    private JMenuItem visuTipo;
    private JMenuItem altPokes;
    private JMenuItem altTipos;
    private JScrollPane TablePane;
    private JComboBox cbView;
    private JButton visualizarButton;

    VisuPokes(){
        setTitle("JavaDex - Visualizar Pokemons");
        setContentPane(VisuPokes);
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,500);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        ArrayList<Pokemon> pokemons = SQLSelect.getPokemons();

        for (Pokemon pokemon : pokemons){
            cbView.addItem(pokemon.getNome());
        }

        visualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pokemon pokemon = SQLSelect.getPokemon(String.valueOf(cbView.getSelectedItem()));
                String res = "Nome:" + pokemon.getNome();
                res += "\nTipo 1:" + pokemon.getTipo1();
                if (!pokemon.getTipo2().isEmpty()){
                    res += "\nTipo 2:" + pokemon.getTipo2();
                }
                res += "\nDesc:" + pokemon.getDesc();
                JOptionPane.showMessageDialog(null,res,"Visão Extendida de " + pokemon.getNome(),JOptionPane.INFORMATION_MESSAGE);
            }
        });

        PokemonTableModel pokemonTableModel = new PokemonTableModel(pokemons);
        JTable pokemonTable = new JTable(pokemonTableModel);
        TablePane.setViewportView(pokemonTable);

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
