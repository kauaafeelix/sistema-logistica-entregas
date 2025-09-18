package org.example.utils;

import org.example.DAO.ClienteDAO;
import org.example.model.Cliente;
import org.example.model.Pedido;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PedidoUtils {

    static Scanner scStr = new Scanner (System.in);
    static Scanner scNum = new Scanner (System.in);
    static ClienteDAO clienteDAO = new ClienteDAO();

    public static int existeIdCliente(){
       try{
        List<Cliente> clientes = clienteDAO.listarClientes();

        System.out.println("Digite o ID do Cliente");
        int id_cliente = scNum.nextInt();

        for (Cliente c : clientes) {
            if (c.getId() == id_cliente) {
                return id_cliente;
            }
       }
        }catch (SQLException e){
           e.printStackTrace();
       }
        return -1;
    }
    public static LocalDate data(){
        System.out.println("Digite a Data do pedido (yyyy/MM/dd): ");
        String entrada = scStr.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate data_pedido = LocalDate.parse(entrada, formatter);

        return data_pedido;
    }
    public static void exibirPedidos (List<Pedido>pedidos){
        if (pedidos != null && !pedidos.isEmpty()){
            for (Pedido p: pedidos){
                System.out.println("\nID: "+p.getId());
                System.out.println("ID DO CLIENTE: "+p.getCliente_id());
                System.out.println("NOME DO CLIENTE: "+p.getNome_cliente());
                System.out.println("DATA DO PEDIDO (YYYY:MM:DD): "+p.getData_pedido());
                System.out.println("VOLUME: "+p.getVolume_m3()+"m³");
                System.out.println("PESO: "+p.getPeso_kg()+"kg");
            }
        }else{
            System.out.println("Nenhum Pedido cadastrado. ");
        }
    }
}
