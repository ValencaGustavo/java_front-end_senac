import java.sql.*;

public class MySQLConnector {

    public static Connection conectar() {
        String status = "Nada aconteceu...";
        String host = "127.0.0.1";
        String db = "db_mysql_connector";
        String user = "root";
        String password = "senac@02";
        String Port = "3306";
        String Url = "jdbc:mysql://" + host + ":" + Port + "/" + db + "?user=" + user + "&password=" + password;
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(Url);
            status = "Conexão realizada com sucesso!";
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            status = "Ops! Algo de errado não está certo com a conexão com o banco de dados MySQL! Mensagem do servidor: " + e;
        }
        System.out.println(status);
        // System.out.println("status");
        return conn;
    }
}
