package SQL.DAO;

import SQL.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

// Classe que define métodos para atualizar e deletar dados no banco de dados
public class SQLUpdate {

    // Método para deletar um Tipo do banco de dados, dado o nome do Tipo
    public static boolean deleteTipo(String tipo) {
        // Obtém o ID do Tipo usando o nome fornecido
        int tp = SQLSelect.getTipoID(tipo);
        // Comando SQL para deletar o Tipo com o ID especificado
        String str = "DELETE FROM tipo WHERE Id = '" + tp + "'";

        PreparedStatement ps = null;

        try {
            // Prepara e executa o comando de deleção
            ps = Connection.getConexao().prepareStatement(str);
            ps.execute();
            ps.close(); // Fecha o PreparedStatement para liberar recursos
            return true; // Retorna true se a deleção for bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime o erro em caso de falha SQL
        }
        return false; // Retorna false se houver uma exceção
    }

    // Método para deletar um Pokémon do banco de dados, dado o nome do Pokémon
    public static boolean deletePokemon(String pokemon) {
        // Comando SQL para deletar o Pokémon com o nome especificado
        String str = "DELETE FROM pokemon WHERE Nome = '" + pokemon + "'";

        PreparedStatement ps = null;

        try {
            // Prepara e executa o comando de deleção
            ps = Connection.getConexao().prepareStatement(str);
            ps.execute();
            ps.close(); // Fecha o PreparedStatement para liberar recursos
            return true; // Retorna true se a deleção for bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime o erro em caso de falha SQL
        }
        return false; // Retorna false se houver uma exceção
    }
}
