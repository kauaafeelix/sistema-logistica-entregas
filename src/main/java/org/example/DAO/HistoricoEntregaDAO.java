package org.example.DAO;

import org.example.Conexao.Conexao;

import java.sql.Connection;
import java.sql.SQLException;

public class HistoricoEntregaDAO {

    public void totalEntregasPorMotorista() throws SQLException{

        String sql = """
                SELECT m.nome AS motorista, COUNT(e.id) AS total_entregas
                FROM Motorista m
                LEFT JOIN Entrega e ON m.id = e.motorista_id
                GROUP BY m.nome
                ORDER BY total_entregas DESC;
                """;

        try (Connection conn = Conexao.conectar();
             var stmt = conn.prepareStatement(sql);
             var rs = stmt.executeQuery()) {

            System.out.printf("%-20s | %-15s%n", "Motorista", "Total Entregas");
            System.out.println("---------------------+----------------");

            while (rs.next()) {
                String motorista = rs.getString("motorista");
                int totalEntregas = rs.getInt("total_entregas");
                System.out.printf("%-20s | %-15d%n", motorista, totalEntregas);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
