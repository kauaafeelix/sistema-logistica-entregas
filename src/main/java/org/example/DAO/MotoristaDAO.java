package org.example.DAO;

import org.example.Conexao.Conexao;
import org.example.model.Motorista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<Motorista> listarMotoristas() throws SQLException{
        List<Motorista>motoristas = new ArrayList<>();
        String sql = "SELECT id, nome, cnh, veiculo, cidade_base FROM Motorista";
        try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)){

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
               int id = rs.getInt("id");
               String nome = rs.getString("nome");
               String cnh = rs.getString("cnh");
               String veiculo = rs.getString("veiculo");
               String cidade_base = rs.getString("cidade_base");

               var motorista = new Motorista(id, nome, cnh, veiculo, cidade_base);
               motoristas.add(motorista);
            }
        }
        return motoristas;
    }

    public List<Motorista> buscarMotorista(String nome) throws SQLException{
        List<Motorista>motoristas = new ArrayList<>();
        String sql = "SELECT id, nome, cnh, veiculo, cidade_base FROM Motorista WHERE nome LIKE ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1,"%"+nome+"%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String nome_banco = rs.getString("nome");
                String cnh = rs.getString("cnh");
                String veiculo = rs.getString("veiculo");
                String cidade_base = rs.getString("cidade_base");

                var motorista = new Motorista(id, nome_banco, cnh, veiculo, cidade_base);
                motoristas.add(motorista);

            }
        }
        return motoristas;
    }

    public void excluirMotorista (int id) throws SQLException{
        String sql = "DELETE FROM Motorista WHERE id = ?";

        try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, id);
            stmt.executeUpdate();

        }
    }
}
