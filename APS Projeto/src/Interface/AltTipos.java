package Interface;

import Creation.Tipo;
import SQL.DAO.SQLCreate;
import SQL.DAO.SQLSelect;
import SQL.DAO.SQLUpdate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AltTipos extends JFrame{
    private JMenu menu;
    private JMenuItem inicio;
    private JMenuItem visuPoke;
    private JMenuItem visuTipo;
    private JMenuItem altPokes;
    private JMenuItem altTipos;
    private JPanel AltTipos;
    private JTabbedPane TabAltTipo;
    private JTextField tfNome;
    private JComboBox TiposCBox;
    private JScrollPane CheckBoxForcasPanel;
    private JPanel ckForcasPanel;
    private JTextField tfForca;
    private JPanel ckFraquezasPan;
    private JScrollPane CheckBoxFraquezasPan;
    private JTextField tfFraq;
    private JButton adicionarButton;
    private JButton removerButton;
    private JPanel removeTipo;
    private JScrollPane ckFraquezasPanel;
    private Map<JRadioButton, Tipo> ckForcas = new HashMap<>();
    private Map<JRadioButton, Tipo> ckFraquezas = new HashMap<>();

    AltTipos(){
        setTitle("JavaDex - Alterar Tipos");
        setContentPane(AltTipos);
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,500);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        ArrayList<Tipo> tipos = SQLSelect.getTipos();
        //PAGINA DE ADICIONAR
        ckForcasPanel.setLayout(new BoxLayout(ckForcasPanel, BoxLayout.Y_AXIS));
        ckForcasPanel.setBorder(null);
        for (Tipo tipo : tipos) {
            JRadioButton radioBtn = new JRadioButton(tipo.getNome());
            ckForcas.put(radioBtn, tipo);
            ckForcasPanel.add(radioBtn);
        }

        ckFraquezasPan.setLayout(new BoxLayout(ckFraquezasPan, BoxLayout.Y_AXIS));
        ckFraquezasPan.setBorder(null);
        for (Tipo tipo : tipos) {
            JRadioButton radioBtn = new JRadioButton(tipo.getNome());
            ckFraquezas.put(radioBtn, tipo);
            ckFraquezasPan.add(radioBtn);
        }

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = tfNome.getText();
                String forc = null;
                String fraq = null;
                if (!nome.isEmpty()){
                    //Verificacao de CheckBoxes
                    for (Map.Entry<JRadioButton, Tipo> dado : ckForcas.entrySet()){
                        if(dado.getKey().isSelected()){
                            forc = dado.getValue().getNome();
                            break;
                        }
                    }
                    //Verificacao de Outro
                    if(!tfForca.getText().isEmpty()){
                        forc = tfForca.getText();
                    }
                    //Verificacao Checkboxes
                    for (Map.Entry<JRadioButton, Tipo> dado : ckFraquezas.entrySet()){
                        if(dado.getKey().isSelected()){
                            fraq = dado.getValue().getNome();
                        }
                    }
                    //Verificacao de Outro
                    if(!tfFraq.getText().isEmpty()){
                        fraq = tfFraq.getText();
                    }
                    SQLCreate.createTipo(new Tipo(nome,forc,fraq));
                    JOptionPane.showMessageDialog(null,"Tipo criado com sucesso.","Ação Concluida",JOptionPane.INFORMATION_MESSAGE);
                    new AltTipos();
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"O nome não pode ser vazio.","Erro de ação",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //PAGINA DE REMOVER
        for (Tipo tipo : tipos){
            TiposCBox.addItem(tipo.getNome());
        }
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = String.valueOf(TiposCBox.getSelectedItem());
                boolean actionPerformed = SQLUpdate.deleteTipo(value);
                if(actionPerformed){
                    JOptionPane.showMessageDialog(null,"Tipo removido com sucesso.", "Ação Concluida",JOptionPane.INFORMATION_MESSAGE);
                    new AltTipos();
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"Tipo não foi encontrado.", "Erro de Ação",JOptionPane.ERROR_MESSAGE);
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
