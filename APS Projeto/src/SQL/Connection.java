package SQL;

import java.sql.DriverManager;
import java.sql.SQLException;

// Classe que gerencia a conexão com o banco de dados
public class Connection {
    // Configurações da conexão com o banco de dados
    private static final String url = "jdbc:mysql://localhost:3306/javadex"; // URL do banco de dados MySQL
    private static final String user = "root"; // Nome de usuário para acessar o banco
    private static final String password = ""; // Senha do banco (nesse caso, vazio)

    // Objeto de conexão que será compartilhado entre chamadas
    private static java.sql.Connection con;

    // Método estático para obter a conexão com o banco de dados
    public static java.sql.Connection getConexao() {
        try {
            // Verifica se a conexão já foi estabelecida
            if (con == null) {
                // Cria uma nova conexão usando as credenciais e URL fornecidos
                con = DriverManager.getConnection(url, user, password);
                return con; // Retorna a conexão recém-criada
            } else {
                return con; // Retorna a conexão existente
            }
        } catch (SQLException e) {
            // Imprime o erro no console, caso a conexão falhe
            e.printStackTrace();
            return null; // Retorna null se a conexão não puder ser estabelecida
        }
    }
}