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
                status)
                VALUES (?, ?, CURRENT_DATE, 'EM_ROTA');
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
                SELECT e.id, e.pedido_id, e.motorista_id, e.data_entrega, e.status
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
                String statusEntrega = rs.getString("status");

                System.out.println("\nID ENTREGA: " + idEntrega);
                System.out.println("ID PEDIDO: " + pedidoId);
                System.out.println("ID MOTORISTA: " + motoristaId);
                System.out.println("DATA ENTREGA: " + dataEntrega);
                System.out.println("STATUS: " + statusEntrega);
            }
        }
    }

    public List<Entrega> listarTodasEntregas() throws SQLException {
        List<Entrega> entregas = new ArrayList<>();

        String sql = """
                SELECT
                    e.id AS entrega_id,
                    e.motorista_id,
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
                int id = rs.getInt("entrega_id");                int pedidoId = rs.getInt("pedido_id");
                int motoristaId = rs.getInt("motorista_id");
                LocalDate dataSaida = rs.getDate("data_saida").toLocalDate();
                LocalDate dataEntrega = rs.getDate("data_entrega").toLocalDate();
                String statusEntrega = rs.getString("status");

                Entrega entrega = new Entrega(id, pedidoId, motoristaId, dataSaida, dataEntrega, StatusEntrega.valueOf(statusEntrega));
                entregas.add(entrega);
            }
        }
        return entregas;
    }

    public List<Entrega>buscarEntregaPorId(int id) throws SQLException{
        List<Entrega>entregas = new ArrayList<>();

        String sql = """
        SELECT
            e.id AS entrega_id,
            e.pedido_id,
            e.motorista_id, 
            e.data_saida,
            e.data_entrega,
            e.status
        FROM Entrega e
        INNER JOIN Motorista m ON e.motorista_id = m.id
        INNER JOIN Pedido p ON e.pedido_id = p.id
        WHERE e.id = ?
    """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idEntrega = rs.getInt("entrega_id");
                int pedidoId = rs.getInt("pedido_id");
                int motoristaId = rs.getInt("motorista_id");                LocalDate dataSaida = rs.getDate("data_saida").toLocalDate();
                LocalDate dataEntrega = rs.getDate("data_entrega").toLocalDate();
                String statusEntrega = rs.getString("status");

                Entrega entrega = new Entrega(idEntrega, pedidoId, motoristaId, dataSaida, dataEntrega, StatusEntrega.valueOf(statusEntrega));
                entregas.add(entrega);
            }
        }
        return entregas;
    }

    public void registrarEventoDeEntrega(int idEntrega, StatusEntrega novoStatus) throws SQLException {
        String sql = "UPDATE Entrega SET status_entrega = ?, data_entrega = CURRENT_DATE WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novoStatus.name());
            stmt.setInt(2, idEntrega);
            stmt.executeUpdate();
        }
    }

    public void excluirEntrega(int idEntrega) throws SQLException {
        String sql = "DELETE FROM Entrega WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idEntrega);
            stmt.executeUpdate();
        }
    }

}
