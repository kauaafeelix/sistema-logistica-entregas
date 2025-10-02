package org.example.DAO;

import org.example.Conexao.Conexao;

import java.sql.Connection;
import java.sql.SQLException;

public class HistoricoEntregaDAO {

    public void totalEntregasPorMotorista() throws SQLException {

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

    public void clientesComMaiorVolumeEntregue() throws SQLException {
        String sql = """
                SELECT c.nome AS cliente, SUM(p.volume) AS total_volume
                FROM Cliente c
                JOIN Pedido p ON c.id = p.cliente_id
                JOIN Entrega e ON p.id = e.pedido_id
                GROUP BY c.nome
                ORDER BY total_volume DESC;
                """;

        try (Connection conn = Conexao.conectar();
             var stmt = conn.prepareStatement(sql);
             var rs = stmt.executeQuery()) {

            System.out.printf("%-20s | %-15s%n", "Cliente", "Total Volume");
            System.out.println("---------------------+----------------");

            while (rs.next()) {
                String cliente = rs.getString("cliente");
                double totalVolume = rs.getDouble("total_volume");
                System.out.printf("%-20s | %-15.2f%n", cliente, totalVolume);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void pedidosPendentesPorEstado() throws SQLException {

        String sql = """
                SELECT p.estado AS estado, COUNT(e.id) AS pedidos_pendentes
                FROM Pedido p
                LEFT JOIN Entrega e ON p.id = e.pedido_id AND e.status = 'PENDENTE'
                GROUP BY p.estado
                ORDER BY pedidos_pendentes DESC;
                """;

        try (Connection conn = Conexao.conectar();
             var stmt = conn.prepareStatement(sql);
             var rs = stmt.executeQuery()) {

            System.out.printf("%-20s | %-20s%n", "Estado", "Pedidos Pendentes");
            System.out.println("---------------------+----------------------");

            while (rs.next()) {
                String estado = rs.getString("estado");
                int pedidosPendentes = rs.getInt("pedidos_pendentes");
                System.out.printf("%-20s | %-20d%n", estado, pedidosPendentes);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void entregasAtrasadasPorCidade()throws SQLException{

        String sql = """
                SELECT p.cidade AS cidade, COUNT(e.id) AS entregas_atrasadas
                FROM Pedido p
                JOIN Entrega e ON p.id = e.pedido_id
                WHERE e.data_entrega > e.data_prevista
                GROUP BY p.cidade
                ORDER BY entregas_atrasadas DESC;
                """;

        try (Connection conn = Conexao.conectar();
             var stmt = conn.prepareStatement(sql);
             var rs = stmt.executeQuery()) {

            System.out.printf("%-20s | %-20s%n", "Cidade", "Entregas Atrasadas");
            System.out.println("---------------------+----------------------");
            while (rs.next()) {
                String cidade = rs.getString("cidade");
                int entregasAtrasadas = rs.getInt("entregas_atrasadas");
                System.out.printf("%-20s | %-20d%n", cidade, entregasAtrasadas);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
