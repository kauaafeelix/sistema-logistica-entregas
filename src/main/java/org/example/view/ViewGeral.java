package org.example.view;


import java.util.Scanner;

public class ViewGeral {
    static Scanner scNum = new Scanner (System.in);
    static Scanner scStr = new Scanner(System.in);

    public static int menuGeral(){
        System.out.println("""
                \n========= BEM VINDO A KAFE ENTREGAS =========\n
                1- Gerenciar Clientes\n
                2- Gerenciar Motoristas\n
                3- Gerenciar Pedidos\n
                4- Gerenciar Entregas\n
                0 - Sair\n
                \nDigite sua opção: 
                """);
        int opcao = scNum.nextInt();
        return opcao;
    }
}
