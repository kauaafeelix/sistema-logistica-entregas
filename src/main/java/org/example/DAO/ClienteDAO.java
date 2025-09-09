package org.example.DAO;

import org.example.model.Cliente;
import org.example.Conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
    public void cadastrarCliente(Cliente cliente) throws SQLException{
        String sql = """
                INSERT INTO Cliente(nome,
                 cpf_cnpj,
                 endereco,
                 cidade,
                 estado) VALUES (?,?,?,?,?)
                """;
        try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf_cnpj());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getCidade());
            stmt.setString(5, cliente.getEstado());
            stmt.executeUpdate();
        }
    }
}
