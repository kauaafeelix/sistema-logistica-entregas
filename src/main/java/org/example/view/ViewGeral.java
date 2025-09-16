package org.example.view;


import java.util.Scanner;

public class ViewGeral {
    static Scanner scNum = new Scanner (System.in);
    static Scanner scStr = new Scanner(System.in);

    public static int menuGeral(){
        System.out.println("""
                \n========= BEM VINDO A KAFE ENTREGAS =========
                1- Gerenciar Clientes
                2- Gerenciar Motoristas
                3- Gerenciar Pedidos
                4- Gerenciar Entregas
                5- Registros
                0 - Sair
                Digite sua opção: 
                """);
        int opcao = scNum.nextInt();
        return opcao;
    }
}
