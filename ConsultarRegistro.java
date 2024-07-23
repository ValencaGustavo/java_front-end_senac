import java.sql.*;

public class ConsultarRegistro {
    public static void main(String[] args) throws Exception {
        try { 
        Connection conexao = MySQLConnector.conectar();
        String strSqlConsultarRegistro = "select * from `db_teste`.`tbl_teste` where `nome`='Teste';";

        Statement stmSqlConsultarRegistro = conexao.createStatement();
        ResultSet resultado = stmSqlConsultarRegistro.executeQuery(strSqlConsultarRegistro);

        while (resultado.next()) {
            System.out.println(resultado.getString("email"));
        }
        System.out.println("Consulta realizada com sucesso!");
    } catch (Exception e) {
        System.out.println("Ops! Ocorreu um erro > " + e);
       }
    }
    
}
