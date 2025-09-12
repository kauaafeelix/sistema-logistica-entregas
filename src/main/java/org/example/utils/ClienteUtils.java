package org.example.utils;

import org.example.model.Cliente;

import java.util.List;

public class ClienteUtils {
    public static void exibirClientes(List<Cliente> clientes) {
        if (!clientes.isEmpty()) {

            for (Cliente cliente : clientes) {
                System.out.println("\nID: " + cliente.getId());
                System.out.println("NOME: " + cliente.getNome());
                System.out.println("CPF/CNPJ: " + cliente.getCpf_cnpj());
                System.out.println("ENDEREÇO: " + cliente.getEndereco());
                System.out.println("CIDADE: " + cliente.getCidade());
                System.out.println("ESTADO: " + cliente.getEstado());
            }
        } else {
            System.out.println("Nenhum Cliente cadastrado.");
        }
    }
}
