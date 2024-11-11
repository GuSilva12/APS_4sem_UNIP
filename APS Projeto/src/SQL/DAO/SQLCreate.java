package SQL.DAO;

import Creation.Pokemon;
import Creation.Tipo;
import SQL.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

// Classe que define métodos para criar (inserir) dados no banco de dados
public class SQLCreate {

    // Método para inserir um novo Pokémon no banco de dados
    public static void createPokemon(Pokemon pokemon) {
        // Comando SQL para inserir um Pokémon na tabela "pokemon"
        String str = "INSERT INTO pokemon (Nome, Tipo1, Tipo2, Descrição) VALUES (?,?,?,?)";

        // Objeto PreparedStatement que será utilizado para executar a inserção
        PreparedStatement ps = null;

        try {
            // Obtém a conexão com o banco e prepara a declaração SQL
            ps = Connection.getConexao().prepareStatement(str);
            // Define os valores para cada campo da tabela
            ps.setString(1, pokemon.getNome()); // Define o nome do Pokémon
            ps.setInt(2, SQLSelect.getTipoID(pokemon.getTipo1())); // Define o ID do Tipo1 do Pokémon
            ps.setInt(3, SQLSelect.getTipoID(pokemon.getTipo2())); // Define o ID do Tipo2 do Pokémon
            ps.setString(4, pokemon.getDesc()); // Define a descrição do Pokémon
            ps.execute(); // Executa a inserção no banco de dados
            ps.close(); // Fecha o PreparedStatement para liberar recursos
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime o erro caso ocorra uma exceção SQL
        }
    }

    // Método para inserir um novo Tipo no banco de dados
    public static void createTipo(Tipo tipo) {
        // Comando SQL para inserir um Tipo na tabela "tipo"
        String str = "INSERT INTO tipo (Nome, Força, Fraqueza) VALUES (?,?,?)";

        PreparedStatement ps = null;

        try {
            // Obtém a conexão com o banco e prepara a declaração SQL
            ps = Connection.getConexao().prepareStatement(str);
            // Define os valores para cada campo da tabela
            ps.setString(1, tipo.getNome()); // Define o nome do Tipo
            ps.setString(2, tipo.getForc()); // Define a lista de forças do Tipo
            ps.setString(3, tipo.getFraq()); // Define a lista de fraquezas do Tipo
            ps.execute(); // Executa a inserção no banco de dados
            ps.close(); // Fecha o PreparedStatement para liberar recursos
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime o erro caso ocorra uma exceção SQL
        }
    }
}
