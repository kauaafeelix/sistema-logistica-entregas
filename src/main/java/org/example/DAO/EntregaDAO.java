package org.example.DAO;

import org.example.Conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
