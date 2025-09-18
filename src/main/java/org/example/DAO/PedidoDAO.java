package org.example.DAO;

import org.example.Conexao.Conexao;
import org.example.model.Pedido;
import org.example.model.enums.StatusPedido;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {
    public void criarPedido(Pedido pedido) throws SQLException {
        String sql = """
                INSERT INTO Pedido (
                cliente_id,
                data_pedido,
                volume_m3,
                peso_kg) 
                VALUES (?,?,?,?)
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pedido.getCliente_id());
            stmt.setDate(2, Date.valueOf(pedido.getData_pedido()));
            stmt.setDouble(3, pedido.getVolume_m3());
            stmt.setDouble(4, pedido.getPeso_kg());
            stmt.executeUpdate();

        }

    }

    public List<Pedido> listarPedidos() throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();

        String sql = "SELECT p.id, p.cliente_id, c.nome AS cliente_nome, " +
                "p.data_pedido, p.volume_m3, p.peso_kg, p.status " +
                "FROM Pedido p " +
                "JOIN Cliente c ON p.cliente_id = c.id";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int clienteId = rs.getInt("cliente_id");
                String clienteNome = rs.getString("cliente_nome");
                LocalDate dataPedido = rs.getDate("data_pedido").toLocalDate();
                double volume = rs.getDouble("volume_m3");
                double peso = rs.getDouble("peso_kg");
                StatusPedido status = StatusPedido.valueOf(rs.getString("status"));

                var pedido = new Pedido(id, clienteNome, dataPedido, volume, peso, status);

                pedidos.add(pedido);
            }
        }
        return pedidos;
    }

    public List<Pedido> buscarPedidoPorCpfCnpjDoCliente(String cpf_cnpj) throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();

        String sql = "SELECT p.id, p.cliente_id, c.nome AS cliente_nome, " +
                "p.data_pedido, p.volume_m3, p.peso_kg, p.status " +
                "FROM Pedido p " +
                "JOIN Cliente c ON p.cliente_id = c.id " +
                "WHERE c.cpf_cnpj = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf_cnpj);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                int clienteId = rs.getInt("cliente_id");
                String clienteNome = rs.getString("cliente_nome");
                LocalDate dataPedido = rs.getDate("data_pedido").toLocalDate();
                double volume = rs.getDouble("volume_m3");
                double peso = rs.getDouble("peso_kg");
                StatusPedido status = StatusPedido.valueOf(rs.getString("status"));

                var pedido = new Pedido(id, clienteNome, dataPedido, volume, peso, status);
                pedidos.add(pedido);
            }
        }
        return pedidos;
    }
    public void atualizarStatusPedido(int idPedido, String novoStatus) throws SQLException {
        String sql = "UPDATE Pedido SET status = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoStatus.toUpperCase());
            stmt.setInt(2, idPedido);
            stmt.executeUpdate();
        }
    }

    public void cancelarPedido (int idPedido) throws SQLException{
        String sql = "UPDATE Pedido SET status = 'CANCELADO' WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, idPedido);
            stmt.executeUpdate();
        }
    }

}