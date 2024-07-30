import java.sql.*;

public class ConsultarRegistro {
    public static String consultar(String db, String tbl, String campo, String campo2, String campo3, String nome, String email, String senha) {
        String retorno = "Nada aconteceu ainda...";
        try { 
        Connection conexao = MySQLConnector.conectar();
        String strSqlConsultarRegistro = "select * from `" + db + "`.`" + tbl + ";";

        Statement stmSqlPrimeiroRegistro = conexao.createStatement();
        ResultSet resultadoPrimeiroRegistro = stmSqlPrimeiroRegistro.executeQuery(strSqlConsultarRegistro);
        resultadoPrimeiroRegistro.first();
        String[] resultado = {
            resultadoPrimeiroRegistro.getString("id"),
            resultadoPrimeiroRegistro.getString("nome"),
            resultadoPrimeiroRegistro.getString("email"),
            resultadoPrimeiroRegistro.getString("senha")
        };
        stmSqlPrimeiroRegistro.close();

        while (resultadoPrimeiroRegistro.next()) {
            System.out.println(resultadoPrimeiroRegistro.getString("email"));
        }
        retorno = "Consulta realizada com sucesso!";
        System.out.println(retorno);
    } catch (Exception e) {
        retorno = "Ops! Ocorreu um erro > ";
        System.out.println(retorno + e);
       }
       return retorno;
    }
    
}
