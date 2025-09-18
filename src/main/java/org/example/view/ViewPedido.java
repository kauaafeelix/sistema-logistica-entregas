package org.example.view;

import org.example.model.Pedido;
import org.example.model.enums.StatusPedido;
import org.example.utils.PedidoUtils;

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

        int id_cliente = PedidoUtils.existeIdCliente();
        if (id_cliente != -1){

        LocalDate date = PedidoUtils.data();

        System.out.println("Digite o Volume do Pedido (em m³): ");
        double volume_m3 = scNum.nextDouble();

        System.out.println("Digite o Peso do Pedido (em kg): ");
        double peso_kg = scNum.nextInt();

        System.out.println("Digite o Status do Pedido (PENDENTE, ENTREGUE, CANCELADO): ");
        StatusPedido status = StatusPedido.valueOf(scStr.nextLine());

        }else{
            System.out.println("ID do cliente não encontrado.");
        }

    }

}
