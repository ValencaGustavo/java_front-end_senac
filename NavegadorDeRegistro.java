import java.sql.*;
public class NavegadorDeRegistro {
    public static String[] FirstRegister(String db, String tbl) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqlFirstRegister = "select * from `" + db + "`.`" + tbl + "`;";
        Statement stmFirstRegister = conexao.createStatement();
        ResultSet rstSqlFirstRegister = stmFirstRegister.executeQuery(strSqlFirstRegister);
        rstSqlFirstRegister.next();
        String[] result = {
            rstSqlFirstRegister.getString("id"),
            rstSqlFirstRegister.getString("nome"),
            rstSqlFirstRegister.getString("email"),
            rstSqlFirstRegister.getString("senha")
        };
        stmFirstRegister.close();
        return result;
    }

    public static String[] PreviousRegister(String db, String tbl, String id) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        int idPerson = Integer.parseInt(id);
        int nextID = idPerson - 1;
        if (nextID >= 1) {
                String strSqlLastRegister = "select * from `" + db + "`.`" + tbl + "` order by `id` desc;";
                Statement stmNextRegister = conexao.createStatement();
                ResultSet rstSqlNextRegister = stmNextRegister.executeQuery(strSqlLastRegister);
                String[] result = {"", "", "", ""};

                while (rstSqlNextRegister.next()) {
                    if (id.equals(rstSqlNextRegister.getString("id"))) {
                        rstSqlNextRegister.next();
                        result[0] = rstSqlNextRegister.getString("id");
                        result[1] = rstSqlNextRegister.getString("nome");
                        result[2] = rstSqlNextRegister.getString("email");
                        result[3] = rstSqlNextRegister.getString("senha");
                        break;

                    }
                }
                rstSqlNextRegister.close();
                if (result[0] == "") {
                    return null;
                } else {
                    return result;
                }
        } else {
            return null;
        }
    }

    public static String[] NextRegister(String db, String tbl, String id) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        int idPerson = Integer.parseInt(id);
        int nextID = idPerson + 1;
        if (nextID >= 1) {
                String strSqlLastRegister = "select * from `" + db + "`.`" + tbl + "` order by `id` asc;";
                Statement stmNextRegister = conexao.createStatement();
                ResultSet rstSqlNextRegister = stmNextRegister.executeQuery(strSqlLastRegister);
                String[] result = {"", "", "", ""};

                while (rstSqlNextRegister.next()) {
                    if (id.equals(rstSqlNextRegister.getString("id"))) {
                        rstSqlNextRegister.next();
                        result[0] = rstSqlNextRegister.getString("id");
                        result[1] = rstSqlNextRegister.getString("nome");
                        result[2] = rstSqlNextRegister.getString("email");
                        result[3] = rstSqlNextRegister.getString("senha");
                        break;

                    }
                }
                rstSqlNextRegister.close();
                if (result[0] == "") {
                    return null;
                } else {
                    return result;
                }
        } else {
            return null;
        }
    }

    public static String[] LastRegister(String db, String tbl) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqlLastRegister = "select * from `" + db + "`.`" + tbl + "` order by id desc limit 1;";
        Statement stmLastRegister = conexao.createStatement();
        ResultSet rstSqlLastRegister = stmLastRegister.executeQuery(strSqlLastRegister);
        rstSqlLastRegister.next();
        String[] result = {
            rstSqlLastRegister.getString("id"),
            rstSqlLastRegister.getString("nome"),
            rstSqlLastRegister.getString("email"),
            rstSqlLastRegister.getString("senha")
        };
        rstSqlLastRegister.close();
        return result;
    }

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
    public static String descadastrar(String db, String tbl, String campo, String campo2, String campo3, String nome, String email, String senha) {
        String retorno = "Nada aconteceu ainda...";
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlExcluirRegistro = "delete from `" + db + "`.`" + tbl + "` where `" + campo + "` = ? and `" + campo2 + "` = ? and `" + campo3 + "` = ?;";
            PreparedStatement rstExcluirRegistro = conexao.prepareStatement(strSqlExcluirRegistro);
            rstExcluirRegistro.setString(1, nome);
            rstExcluirRegistro.setString(2, email);
            rstExcluirRegistro.setString(3, senha);
            int linhasRegistro = rstExcluirRegistro.executeUpdate();
            rstExcluirRegistro.close();
            conexao.close();
            if (linhasRegistro > 0) {
                retorno = "Registro excluído com sucesso!";
            } else {
                retorno = "Nenhum registro encontrado para excluir.";
            }
        } catch (Exception e) {
            retorno = "Ops! Ocorreu um erro: " + e;
            System.out.println(retorno);
        }
        return retorno;
    }
}
