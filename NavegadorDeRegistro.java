import java.sql.*;

public class NavegadorDeRegistro {
    public static String[] FirstRegister(String db, String tbl) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqlFirstRegister = "select * from `" + db + "`.`" + tbl + "`;";
        Statement stmFirstRegister = conexao.createStatement();
        ResultSet rstSqlFirstRegiter = stmFirstRegister.executeQuery(strSqlFirstRegister);
        rstSqlFirstRegiter.next();
        String[] result = {
            rstSqlFirstRegiter.getString("id"),
            rstSqlFirstRegiter.getString("nome"),
            rstSqlFirstRegiter.getString("email"),
            rstSqlFirstRegiter.getString("senha")
        };
        stmFirstRegister.close();
        return result;
    }

    public static String[] LastRegister(String db, String tbl) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqlLastRegister = "select * from `" + db + "`.`" + tbl + "` order by id desc limit 1;";
        Statement stmLastRegister = conexao.createStatement();
        ResultSet rstSqlLastRegiter = stmLastRegister.executeQuery(strSqlLastRegister);
        rstSqlLastRegiter.next();
        String[] result = {
            rstSqlLastRegiter.getString("id"),
            rstSqlLastRegiter.getString("nome"),
            rstSqlLastRegiter.getString("email"),
            rstSqlLastRegiter.getString("senha")
        };
        rstSqlLastRegiter.close();
        return result;
    }
}

