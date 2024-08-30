import java.sql.*;

public class NavegadorDeRegistro {
    public static String[] FirstRegister(String db, String tbl) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqlPrimeiroRegistro = "select * from `" + db + "`.`" + tbl + "` order by `id` asc limit 1;";
        Statement stmSqlPrimeiroRegistro = conexao.createStatement();
        ResultSet rstSqlPrimeiroRegistro = stmSqlPrimeiroRegistro.executeQuery(strSqlPrimeiroRegistro);
        rstSqlPrimeiroRegistro.next();
        String[] resultado = {
            rstSqlPrimeiroRegistro.getString("id"),
            rstSqlPrimeiroRegistro.getString("nome"),
            rstSqlPrimeiroRegistro.getString("email")
        };
        stmSqlPrimeiroRegistro.close();
        return resultado;
    }

    public static String[] PreviousRegister(String db, String tbl, String id) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        int idPessoa = Integer.parseInt(id);
        int proximoId = idPessoa - 1;
        if (proximoId >= 1) {
            String strSqlRegistroAnterior = "select * from `" + db + "`.`" + tbl + "` where `id` < " + id + " order by `id` desc limit 1;";
            Statement stmSqlRegistroAnterior = conexao.createStatement();
            String[] resultado = {"","",""};
            try {
                ResultSet rstSqlRegistroAnterior = stmSqlRegistroAnterior.executeQuery(strSqlRegistroAnterior);
                rstSqlRegistroAnterior.next();
                resultado[0] = rstSqlRegistroAnterior.getString("id");
                resultado[1] = rstSqlRegistroAnterior.getString("nome");
                resultado[2] = rstSqlRegistroAnterior.getString("email");
            } catch (Exception e) {
                System.out.println("Ops! Parece que já está no primeiro registro. Veja o erro: " + e);
                return null;
            }
            stmSqlRegistroAnterior.close();
            return resultado;
        } else {
            return null;
        }
    }

    public static String[] NextRegister(String db, String tbl, String id) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        try {
            String strSqlProximoRegistro = "select * from `" + db + "`.`" + tbl + "` where `id` > " + id + " order by `id` asc limit 1;";
            Statement stmSqlProximoRegistro = conexao.createStatement();
            String[] resultado = {"","",""};
            try {
                ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
                rstSqlProximoRegistro.next();
                resultado[0] = rstSqlProximoRegistro.getString("id");
                resultado[1] = rstSqlProximoRegistro.getString("nome");
                resultado[2] = rstSqlProximoRegistro.getString("email");
                stmSqlProximoRegistro.close();
            } catch (Exception e) {
                System.out.println("Ops! Parece que já está no último registro...");
                return null;
            }
            return resultado;
        } catch (Exception e) {
            return null;
        }
    }

    public static String[] LastRegister(String db, String tbl) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        try {
            String strSqlUltimoRegistro = "select * from `" + db + "`.`" + tbl + "` order by `id` desc limit 1;";
            Statement stmSqlUltimoRegistro = conexao.createStatement();
            ResultSet rstSqlUltimoRegistro = stmSqlUltimoRegistro.executeQuery(strSqlUltimoRegistro);
            rstSqlUltimoRegistro.next();
            String[] resultado = {
                rstSqlUltimoRegistro.getString("id"),
                rstSqlUltimoRegistro.getString("nome"),
                rstSqlUltimoRegistro.getString("email")
            };
            stmSqlUltimoRegistro.close();
            return resultado;
        } catch (Exception e) {
            return null;
        }
    }

    public static String[] irParaId(String db, String tbl, String id) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        try {
            String strSqlRegistro = "select * from `" + db + "`.`" + tbl + "` where `id` = " + id + ";";
            Statement stmSqlRegistro = conexao.createStatement();
            ResultSet rstSqlRegistro = stmSqlRegistro.executeQuery(strSqlRegistro);
            rstSqlRegistro.next();
            String[] resultado = {
                rstSqlRegistro.getString("id"),
                rstSqlRegistro.getString("nome"),
                rstSqlRegistro.getString("email")
            };
            stmSqlRegistro.close();
            return resultado;
        } catch (Exception e) {
            return null;
        }
    }

    public static String[] search(String db, String tbl, String nome, String email) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        try {
            String strSqlPesquisarNome = "select * from `" + db + "`.`" + tbl + "` where `nome` like '%" + nome + "%' and `email` like '%" + email + "%' order by `id` asc limit 1;";
            Statement stmSqlPesquisarNome = conexao.createStatement();
            ResultSet rstSqlPesquisarNome = stmSqlPesquisarNome.executeQuery(strSqlPesquisarNome);
            rstSqlPesquisarNome.next();
            String[] resultado = {
                rstSqlPesquisarNome.getString("id"),
                rstSqlPesquisarNome.getString("nome"),
                rstSqlPesquisarNome.getString("email")
            };
            stmSqlPesquisarNome.close();
            return resultado;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean updateCadastro(String db, String tbl, String id, String nome, String email, char[] senha) throws Exception {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlUltimoRegistro = "update `" + db + "`.`" + tbl + "` set `nome` = '" + nome + "', `email` = '" + email + "', `senha` = '" + String.valueOf(senha) + "' where `id` = " + id + ";";
            Statement stmSqlUltimoRegistro = conexao.createStatement();
            stmSqlUltimoRegistro.addBatch(strSqlUltimoRegistro);
            stmSqlUltimoRegistro.executeBatch();
            stmSqlUltimoRegistro.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static boolean createRegister(String db, String tbl, String nome, String email, char[] senha) throws Exception {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlCadastrarRegistro = "insert into `" + db + "`.`" + tbl + "` (`nome`,`email`,`senha`) values ('" + nome + "','" + email + "','" + String.valueOf(senha) +"');";
            Statement stmSqlCadastrarRegistro = conexao.createStatement();
            stmSqlCadastrarRegistro.addBatch(strSqlCadastrarRegistro);
            stmSqlCadastrarRegistro.executeBatch();
            stmSqlCadastrarRegistro.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static String[] deleteRegister(String db, String tbl, String id) throws Exception {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlDeletarRegistro = "delete from `" + db + "`.`" + tbl + "`  where `id` = " + id + ";";
            Statement stmSqlDeletarRegistro = conexao.createStatement();
            stmSqlDeletarRegistro.addBatch(strSqlDeletarRegistro);
            stmSqlDeletarRegistro.executeBatch();
            stmSqlDeletarRegistro.close();

            String strSqlProximoRegistro = "select * from `" + db + "`.`" + tbl + "`  where `id` >= " + id + ";";
            Statement stmSqlProximoRegistro = conexao.createStatement();
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            rstSqlProximoRegistro.next();
            String[] resultado = {
                rstSqlProximoRegistro.getString("id"),
                rstSqlProximoRegistro.getString("nome"),
                rstSqlProximoRegistro.getString("email")
            };
            stmSqlProximoRegistro.close();
            return resultado;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
/* MYSQL TELAS (CADASTRO/LOGIN) */

public static String cadastrar1(String db, String tbl, String campo, String campo2, String campo3, String nome, String email, String senha) {
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