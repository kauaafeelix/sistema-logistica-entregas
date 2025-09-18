package org.example.view;

import org.example.DAO.ClienteDAO;
import org.example.DAO.PedidoDAO;
import org.example.model.Pedido;
import org.example.model.enums.StatusPedido;
import org.example.utils.PedidoUtils;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewPedido {

    static Scanner scNum = new Scanner (System.in);
    static Scanner scStr = new Scanner (System.in);

    public static int menuPedido(){
        System.out.println("========= GERENCIADOR DE PEDIDO =========\n");
        System.out.println("""
                1 - CRIAR PEDIDO
                2 - LISTAR PEDIDOS
                3 - BUSCAR PEDIDO POR CPF/CNPJ DO CLIENTE
                4 - ATUALIZAR STATUS DO PEDIDO
                5 - CANCELAR PEDIDO
                6 - EXCLUIR PEDIDO
                0 - VOLTAR AO MENU PRINCIPAL
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

        }else {
            System.out.println("ID do cliente não encontrado.");
        }


    }

    public static void listarPedidos(){
        System.out.println("========= LISTA DE PEDIDOS =========\n");

        List<Pedido>pedidos = new ArrayList<>();

        try{
            var pedidoDao = new PedidoDAO();
            pedidos = pedidoDao.listarPedidos();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu um Erro no Banco de Dados. ");
        }
        PedidoUtils.exibirPedidos(pedidos);
    }

    public static void buscarPedido(){
        List<Pedido>pedidosCpfCnpj = new ArrayList<>();

        System.out.println("========= BUSCA DE PEDIDOS =========\n");

        System.out.println("Digite o CPF ou CNPJ do Cliente que deseja ver o Pedido: ");
        String cpf_cnpj = scStr.nextLine();
        try{
            var pedidoDao = new PedidoDAO();
            pedidosCpfCnpj = pedidoDao.buscarPedidoPorCpfCnpjDoCliente(cpf_cnpj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PedidoUtils.exibirPedidos(pedidosCpfCnpj);
    }

    public static void atualizarPedido(){
        System.out.println("========= ATUALIZAR STATUS DO PEDIDO =========\n");

        System.out.println("========= PEDIDOS JÁ CADASTRADOS =========\n");

        List<Pedido>pedidos = new ArrayList<>();
        try{
            var pedidoDao = new PedidoDAO();
            pedidos = pedidoDao.listarPedidos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PedidoUtils.exibirPedidos(pedidos);
        System.out.println("\n================================");
        if (pedidos != null && !pedidos.isEmpty()) {
            System.out.println("\nDigite o ID do Pedido que deseja: ");
            int id_pedido = scNum.nextInt();

            System.out.println("\nDigite o novo Status que deseja atualizar (Cancelado, Entregue): ");
            String status = scStr.nextLine();

            try {
                var pedidoDao = new PedidoDAO();
                pedidoDao.atualizarStatusPedido(id_pedido, status);
                System.out.println("\nPEDIDO ATUALIZADO COM SUCESSO.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("OCORREU UM ERRO NO BANCO DE DADOS.");
            }
        }
    }
}
