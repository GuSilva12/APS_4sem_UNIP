package Interface;

import Creation.Pokemon;                        //representa o Pokemon
import Creation.Tipo;                           //representa o tipo do Pokemon

import javax.swing.table.AbstractTableModel;    //classe base para criar modelos de tabela personalizados
import java.util.ArrayList;                     //armazenar uma colecao de objetos pokemon
import java.util.List;                          //armazenar uma colecao de objetos pokemon

public class PokemonTableModel extends AbstractTableModel {

    //DECLARACAO DE VARIAVEIS

    private final List<Pokemon> pokemons;                                           //uma lista imutável de objetos Pokemon, contem os dados a serem exibidos na tabela
    private final String[] colunas = {"Nome", "Tipo 1", "Tipo 2", "Descrição"};     //array imutável de strings que representa os nomes das colunas da tabela


    //CONSTRUTOR COM A LISTA DE POKEMONES
    public PokemonTableModel(ArrayList<Pokemon> pokemons){                          //recebe uma lista Pokemon e armazena no atributo pokemons
        this.pokemons = pokemons;
    }


    @Override
    public int getRowCount() {                                                      //retorna o numero de linhas da tabela - é igual o numero de pokemons na lista
        return this.pokemons.size();
    }

    @Override
    public int getColumnCount() {                                                   //retorna o numero de colunas da tabela - é igual o numero de elementos dentro do array 'colunas'
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {                       //retorna o valor de uma celula especifica da tabela
        Pokemon pokemon = this.pokemons.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pokemon.getNome();
            case 1:
                return pokemon.getTipo1();
            case 2:
                return pokemon.getTipo2();
            case 3:
                return pokemon.getDesc();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {                                       //retorna o nome da coluna com base no índice fornecido
        return colunas[column];
    }
}
