package org.example.utils;

import org.example.DAO.ClienteDAO;
import org.example.DAO.MotoristaDAO;
import org.example.DAO.PedidoDAO;
import org.example.model.Cliente;
import org.example.model.Entrega;
import org.example.model.Motorista;
import org.example.model.Pedido;

import java.sql.SQLException;
import java.util.List;

import java.util.Scanner;

public class EntregaUtils {
    static Scanner scNum = new Scanner(System.in);
    static Scanner scStr = new Scanner(System.in);
    static PedidoDAO pedidoDAO = new PedidoDAO();
    static MotoristaDAO motoristaDAO = new MotoristaDAO();
    static ClienteDAO clienteDAO = new ClienteDAO();


    public static int existeIdPedido() {
        try {
            List<Pedido> pedidos = pedidoDAO.listarPedidos();

            System.out.println("Digite o ID do Pedido");
            int id_pedido = scNum.nextInt();

            for (Pedido p : pedidos) {
                if (p.getId() == id_pedido) {
                    return id_pedido;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int existeIdMotorista() {
        try {
            List<Motorista> motoristas = motoristaDAO.listarMotoristas();

            System.out.println("Digite o ID do Motorista");
            int id_motorista = scNum.nextInt();

            for (Motorista m : motoristas) {
                if (m.getId() == id_motorista) {
                    return id_motorista;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int existeIdCliente() {
        try {
            List<Cliente> clientes = clienteDAO.listarClientes();

            System.out.println("Digite o ID do Cliente");
            int id_cliente = scNum.nextInt();

            for (Cliente c : clientes) {
                if (c.getId() == id_cliente) {
                    return id_cliente;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void exibirEntregas(List<Entrega> entregas) {
        if (entregas.isEmpty() || entregas == null) {
            System.out.println("Nenhuma Entrega cadastrada. ");
        } else {
            for (Entrega e : entregas) {
                System.out.println("\nID DA ENTREGA: " + e.getId());
                System.out.println("ID DO PEDIDO: " + e.getPedido_id());
                System.out.println("NOME DO MOTORISTA:" +e.getMotorista_id());
                System.out.println("DATA_SAIDA (YYYY:MM:DD): " + e.getData_saida());
                System.out.println("DATA DA ENTREGA (YYYY:MM:DD): " + e.getData_entrega());
                System.out.println("STATUS: " + e.getStatus());
            }
        }
    }
}
