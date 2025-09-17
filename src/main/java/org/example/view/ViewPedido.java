package org.example.view;

import org.example.model.Pedido;

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

}
