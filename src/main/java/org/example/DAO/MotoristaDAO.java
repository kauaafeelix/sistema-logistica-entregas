package org.example.DAO;

import org.example.Conexao.Conexao;
import org.example.model.Motorista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MotoristaDAO {
    public void cadastrarMotorista(Motorista motorista) throws SQLException {
        String sql = """
                INSERT INTO Motorista (nome,
                 cnh,
                 veiculo,
                 cidade_base)
                 VALUES (?, ?, ?, ?)
                """;
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, motorista.getNome());
            stmt.setString(2, motorista.getCnh());
            stmt.setString(3, motorista.getVeiculo());
            stmt.setString(4, motorista.getCidade_base());
            stmt.executeUpdate();
        }
    }
}
