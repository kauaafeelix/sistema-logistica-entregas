package org.example.view;

import org.example.DAO.ClienteDAO;
import org.example.DAO.PedidoDAO;
import org.example.model.Pedido;
import org.example.utils.PedidoUtils;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class ViewPedido {

    static Scanner scNum = new Scanner (System.in);
    static Scanner scStr = new Scanner (System.in);

    public static int menuPedido(){
        System.out.println("========= GERENCIADOR DE PEDIDO =========\n");
        System.out.println("""
                1- Criar Pedido
                2- Atribuir Pedido a um Motorista
                3- Buscar Pedido por CPF/CNPJ do Cliente
                4- Cancelar Pedido
                5- Voltar ao Menu Principal
                """);
        int opcao = scNum.nextInt();
        return opcao;

    }

    public static void criarPedido(){
        System.out.println("========= CRIAR PEDIDO =========\n");

        var pedidoDao = new PedidoDAO();

        int id_cliente = PedidoUtils.existeIdCliente();

        if (id_cliente != -1){

        LocalDate date = PedidoUtils.data();

        System.out.println("Digite o Volume do Pedido (em m³): ");
        double volume_m3 = scNum.nextDouble();

        System.out.println("Digite o Peso do Pedido (em kg): ");
        double peso_kg = scNum.nextInt();


        var pedido = new Pedido(id_cliente, date, volume_m3, peso_kg);

        try{
            pedidoDao.criarPedido(pedido);
            System.out.println("PEDIDO CRIADO COM SUCESSO!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu um Erro no Banco de dados. ");
        }

        }else{
            System.out.println("ID do cliente não encontrado.");
        }


    }

}
