package org.example.Conexao;
import java.sql.Connection;

public class TesteConexao {

    public static void main(String[] args) {
            try (Connection conn = Conexao.conectar()) {
                if (conn != null) {
                    System.out.println("Conexão realizada com sucesso!");
                } else {
                    System.out.println("Falha na conexão.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
