package org.example.DAO;

import com.mysql.cj.xdevapi.Client;
import org.example.model.Cliente;
import org.example.Conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Cliente> buscarClientePorCpf(String cpf_cnpj) throws SQLException{
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT id, nome, cpf_cnpj, endereco, cidade, estado FROM Cliente WHERE cpf_cnpj = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, cpf_cnpj);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf_cnpj_banco = rs.getString("cpf_cnpj");
                String endereco = rs.getString("endereco");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");

                var cliente = new Cliente(id, nome, cpf_cnpj_banco, endereco, cidade, estado);
                clientes.add(cliente);
            }
        }
        return clientes;
    }

}
