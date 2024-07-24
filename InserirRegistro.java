import java.sql.*;

public class InserirRegistro {
    public static String cadastrar(String db, String tbl, String campo, String campo2, String campo3, String nome, String email, String senha) {
        String retorno = "Nada aconteceu ainda...";
        try { 
        Connection conexao = MySQLConnector.conectar();
        String strSqlInserirRegistro = "insert into `" + db + "`.`" + tbl + "` (`" + campo + "`, `" + campo2 + "`, `" + campo3 + "`) values ('" + nome + "', '" + email + "', '" + senha + "');";
        Statement stmSqlInserirRegistro = conexao.createStatement();

        // ResultSet resultado =
        stmSqlInserirRegistro.addBatch(strSqlInserirRegistro);
        stmSqlInserirRegistro.executeBatch();
        stmSqlInserirRegistro.close();
        retorno = "Registro inserido com sucesso!";
        System.out.println(retorno);
    } catch (Exception e) {
        retorno = "Ops! Ocorreu um erro: " + e;
        System.out.println(retorno);
       }
       return retorno;
    }
    
}
