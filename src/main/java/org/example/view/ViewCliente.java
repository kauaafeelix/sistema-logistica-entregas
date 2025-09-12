package org.example.view;

import org.example.DAO.ClienteDAO;
import org.example.model.Cliente;
import org.example.utils.ClienteUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewCliente {
    static Scanner scStr = new Scanner (System.in);
    static Scanner scNum = new Scanner (System.in);

    public static int menuCliente(){
        System.out.println("========= GERENCIADOR DE CLIENTE =========\n");

        System.out.println("""
                1- Cadastrar Cliente
                2- Listar Todas as Entregas
                3- Clientes com Maior Volume Entregue
                4- Buscar Pedido por CPF/CNPJ do Cliente
                5- Excluir Cliente
                0- Voltar ao Menu Inicial 
                Digite sua opção:
                """);
        int opcao = scNum.nextInt();
        return opcao;
    }



    public static void cadastrarCliente(){
        System.out.println("========= CADASTRO DE CLIENTE =========\n");

        var clienteDao = new ClienteDAO();

            System.out.println("Digite o Nome do cliente: ");
            String nome = scStr.nextLine();

            System.out.println("Digite o CPF ou CNPJ do cliente: ");
            String cpf_cnpj = scStr.nextLine();

            System.out.println("Digite o Endereço do cliente: ");
            String endereco = scStr.nextLine();

            System.out.println("Digite a Cidade do cliente: ");
            String cidade = scStr.nextLine();

            System.out.println("Digite o Estado do cliente (ex: SC) : ");
            String estado = scStr.nextLine();

            var cliente = new Cliente(nome, cpf_cnpj, endereco, cidade, estado);

        try{
            clienteDao.cadastrarCliente(cliente);
            System.out.println("\nCLIENTE CADASTRADO COM SUCESSO!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("\nOcorreu um erro no Banco de Dados.");
        }

    }

    public static void buscarCliente(){
        System.out.println("========= BUSCAR CLIENTE =========\n");

        System.out.println("Digite o CPF ou CNPJ do Cliente: ");
        String cpf_cnpj = scStr.nextLine();

        List<Cliente> clientes = new ArrayList<>();

        try{
            var clienteDao = new ClienteDAO();
            clienteDao.buscarClientePorCpf(cpf_cnpj);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu um Erro no Banco de Dados.");
        }
        ClienteUtils.exibirClientes(clientes);
    }


}
