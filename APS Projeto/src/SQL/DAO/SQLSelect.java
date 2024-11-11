package SQL.DAO;

import Creation.Pokemon;
import Creation.Tipo;
import SQL.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// Classe que define métodos para selecionar dados no banco de dados
public class SQLSelect {

    // Método que retorna o ID de um Tipo com base no nome do Tipo
    public static int getTipoID(String tipo) {
        String str = "SELECT Id FROM Tipo WHERE Nome = '" + tipo + "'";
        PreparedStatement ps = null;
        try {
            ps = Connection.getConexao().prepareStatement(str);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                System.out.println(result.getInt("Id")); // Imprime o ID no console
                return result.getInt("Id"); // Retorna o ID do tipo encontrado
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime o erro em caso de falha de SQL
        }
        return -1; // Retorna -1 se o tipo não for encontrado
    }

    // Método que retorna o nome de um Tipo com base no ID do Tipo
    public static String getTipoNome(int tipo) {
        String str = "SELECT Nome FROM Tipo WHERE Id = '" + tipo + "'";
        PreparedStatement ps = null;
        try {
            ps = Connection.getConexao().prepareStatement(str);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                return result.getString("Nome"); // Retorna o nome do tipo encontrado
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ""; // Retorna uma string vazia se o tipo não for encontrado
    }

    // Método que retorna uma lista de todos os Tipos no banco de dados
    public static ArrayList<Tipo> getTipos() {
        ArrayList<Tipo> tipos = new ArrayList<>();
        String str = "SELECT * FROM Tipo";
        PreparedStatement ps = null;

        try {
            ps = Connection.getConexao().prepareStatement(str);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                // Cria um novo objeto Tipo com os dados obtidos e adiciona à lista
                Tipo tipo = new Tipo(
                        result.getString("Nome"),
                        result.getString("Força"),
                        result.getString("Fraqueza")
                );
                tipos.add(tipo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipos; // Retorna a lista de tipos
    }

    // Método que retorna uma lista de todos os Pokémons no banco de dados
    public static ArrayList<Pokemon> getPokemons() {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        String str = "SELECT * FROM Pokemon";
        PreparedStatement ps = null;

        try {
            ps = Connection.getConexao().prepareStatement(str);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                // Cria um novo objeto Pokémon com os dados obtidos e adiciona à lista
                Pokemon poke = new Pokemon(
                        result.getString("Nome"),
                        result.getString("Descrição"),
                        SQLSelect.getTipoNome(result.getInt("Tipo1")), // Obtém o nome do Tipo1
                        SQLSelect.getTipoNome(result.getInt("Tipo2"))  // Obtém o nome do Tipo2
                );
                pokemons.add(poke);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pokemons; // Retorna a lista de pokémons
    }

    // Método que retorna um Pokémon específico pelo nome
    public static Pokemon getPokemon(String nome) {
        String str = "SELECT * FROM Pokemon WHERE Nome = '" + nome + "'";
        PreparedStatement ps = null;

        try {
            ps = Connection.getConexao().prepareStatement(str);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                // Cria e retorna o Pokémon encontrado
                return new Pokemon(
                        result.getString("Nome"),
                        result.getString("Descrição"),
                        SQLSelect.getTipoNome(result.getInt("Tipo1")),
                        SQLSelect.getTipoNome(result.getInt("Tipo2"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retorna null se o Pokémon não for encontrado
    }

    // Método que retorna um Tipo específico pelo nome
    public static Tipo getTipo(String nome) {
        String str = "SELECT * FROM Tipo WHERE Nome = '" + nome + "'";
        PreparedStatement ps = null;

        try {
            ps = Connection.getConexao().prepareStatement(str);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                // Cria e retorna o Tipo encontrado
                return new Tipo(
                        result.getString("Nome"),
                        result.getString("Força"),
                        result.getString("Fraqueza")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retorna null se o tipo não for encontrado
    }
}