package Interface;

import Creation.Tipo;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.stream.Collectors;

// Classe que extende AbstractTableModel para modelar dados em uma tabela (TableModel) personalizada
public class TipoTableModel extends AbstractTableModel {
    // Lista de objetos do tipo "Tipo" que serão exibidos na tabela
    private final List<Tipo> tipos;
    // Array de strings com os nomes das colunas da tabela
    private final String[] colunas = {"Nome", "Forças", "Fraquezas"};

    // Construtor que recebe uma lista de tipos e inicializa o atributo "tipos"
    public TipoTableModel(List<Tipo> tipos) {
        this.tipos = tipos;
    }

    // Método que retorna o número de linhas da tabela (quantidade de elementos na lista "tipos")
    @Override
    public int getRowCount() {
        return tipos.size();
    }

    // Método que retorna o número de colunas da tabela (tamanho do array "colunas")
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    // Método que retorna o valor exibido em uma célula específica da tabela (linha e coluna)
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Obtém o objeto "Tipo" da linha especificada
        Tipo tipo = tipos.get(rowIndex);
        // Verifica a coluna para retornar o valor correspondente
        switch (columnIndex) {
            case 0:
                return tipo.getNome(); // Retorna o nome do tipo para a coluna 0
            case 1:
                return String.join(", ", tipo.getForc()); // Junta e retorna as forças como uma string separada por vírgulas
            case 2:
                return String.join(", ", tipo.getFraq()); // Junta e retorna as fraquezas como uma string separada por vírgulas
            default:
                return null; // Caso não seja uma coluna válida, retorna null
        }
    }

    // Método que retorna o nome de uma coluna com base no índice
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}

