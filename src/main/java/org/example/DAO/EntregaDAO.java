package org.example.DAO;

import org.example.Conexao.Conexao;
import org.example.model.Entrega;
import org.example.model.enums.StatusEntrega;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EntregaDAO {

    public void gerarEntrega(int idPedido, int idMotorista) throws SQLException {

        String sql = """
                INSERT INTO Entrega (
                pedido_id,
                motorista_id,
                data_entrega,
                status_entrega)
                VALUES (?, ?, CURRENT_DATE, 'PENDENTE')
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, idPedido);
            stmt.setInt(2, idMotorista);
            stmt.executeUpdate();

        }
    }

    public void listarEntregasPorClienteEMotorista(int idCliente, int idMotorista) throws SQLException {
        String sql = """
                SELECT e.id, e.pedido_id, e.motorista_id, e.data_entrega, e.status_entrega
                FROM Entrega e
                JOIN Pedido p ON e.pedido_id = p.id
                WHERE p.cliente_id = ? AND e.motorista_id = ?
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCliente);
            stmt.setInt(2, idMotorista);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idEntrega = rs.getInt("id");
                int pedidoId = rs.getInt("pedido_id");
                int motoristaId = rs.getInt("motorista_id");
                var dataEntrega = rs.getDate("data_entrega").toLocalDate();
                String statusEntrega = rs.getString("status_entrega");

                System.out.println("\nID ENTREGA: " + idEntrega);
                System.out.println("ID PEDIDO: " + pedidoId);
                System.out.println("ID MOTORISTA: " + motoristaId);
                System.out.println("DATA ENTREGA: " + dataEntrega);
                System.out.println("STATUS ENTREGA: " + statusEntrega);
            }
        }
    }

    public List<Entrega> listarTodasEntregas() throws SQLException {
        List<Entrega> entregas = new ArrayList<>();

        String sql = """
                SELECT
                    e.id AS entrega_id,
                    m.nome AS motorista_nome,
                    e.pedido_id,
                    e.status,
                    e.data_saida,
                    e.data_entrega
                FROM Entrega e
                INNER JOIN Motorista m ON e.motorista_id = m.id
                ORDER BY e.data_saida DESC;
                
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int pedidoId = rs.getInt("pedido_id");
                int motoristaId = rs.getInt("motorista_id");
                LocalDate dataSaida = rs.getDate("data_saida").toLocalDate();
                LocalDate dataEntrega = rs.getDate("data_entrega").toLocalDate();
                String statusEntrega = rs.getString("status_entrega");

                Entrega entrega = new Entrega(id, pedidoId, motoristaId, dataSaida, dataEntrega, StatusEntrega.valueOf(statusEntrega));
                entregas.add(entrega);
            }
        }
        return entregas;
    }
}
