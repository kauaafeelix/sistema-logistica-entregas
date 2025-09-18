package org.example.DAO;

import org.example.Conexao.Conexao;
import org.example.model.Pedido;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoDAO {
    public void criarPedido(Pedido pedido) throws SQLException{
        String sql = """
                INSERT INTO Pedido (
                cliente_id,
                data_pedido,
                volume_m3,
                peso_kg,
                status
                VALUES (?,?,?,?,?)
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, pedido.getCliente_id());
            stmt.setDate(2, Date.valueOf(pedido.getData_pedido()));
            stmt.setDouble(3, pedido.getVolume_m3());
            stmt.setDouble(4, pedido.getPeso_kg());
            stmt.setString(5, String.valueOf(pedido.getStatus()));
            stmt.executeUpdate();

        }
    }
}
