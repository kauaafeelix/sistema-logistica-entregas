package org.example;

import org.example.service.GeralService;

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// Java
public class Main {
    public static void main(String[] args) {
        GeralService gerenciador = new GeralService();
        int opcao;
        do {
            opcao = gerenciador.gerenciadorService();
        } while (opcao != 0);
    }
}
