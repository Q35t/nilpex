package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConexaoJdbc {

    //atributo JDBC como constante recebendo Driver Mysql
    final private static String JDBC = "com.mysql.jdbc.Driver";
    //Local do Banco de dados
    final private static String URL = "jdbc:mysql://localhost:3306/nilpex";
    //atributo Usuario recebendo o usuario do banco de dados
    final private static String USUARIO = "wellington";
    //atributo senha recebe senha do usuario
    final private static String SENHA = "@2w3n#";
    //atributo de conexao
    private static Connection con;
    public static ResultSet rs;

    //metodo para conectar ao banco
    public static Connection getConexao() {
        try {
            //recebendo o drive mysql para a comunicação
            Class.forName(JDBC);
            con = null;
            //atributo con recebe local do banco usuario e senha
            con = (Connection) DriverManager.getConnection(URL, USUARIO, SENHA);
            //retorna respota caso tenha conectado ao banco de dados
            System.out.println("Conexao realizada com Sucesso!");
        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
        return con;
    }
    //metodo para fechar a conexao com o banco de dados

    public boolean getFecharConexao() {
        try {
            //fechando a conexao com o banco
            ConexaoJdbc.getConexao().close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexao (" + e + ")");
        }
        return true;
    }

    //metodo para onsulta de SQL
    public static void executarSQL(String sql) {
        Statement st;
        try {
            st = ConexaoJdbc.getConexao().createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
            ResultSet rst = st.executeQuery(sql);
            rs = rst;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String args[]) {
        //teste de conexão com banco de dados
        // ConexaoJdbc.getConexao();
    }
}
