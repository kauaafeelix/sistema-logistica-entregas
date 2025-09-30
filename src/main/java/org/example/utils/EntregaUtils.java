package org.example.utils;

import org.example.DAO.MotoristaDAO;
import org.example.DAO.PedidoDAO;
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
}
