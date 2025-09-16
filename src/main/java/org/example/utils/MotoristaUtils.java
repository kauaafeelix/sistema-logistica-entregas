package org.example.utils;

import org.example.model.Cliente;
import org.example.model.Motorista;

import java.util.List;

public class MotoristaUtils {
    public static void exibirMotoristas(List<Motorista>motoristas){
        if (motoristas!= null && !motoristas.isEmpty()){
            for (Motorista motorista : motoristas) {
                System.out.println("\nID: " + motorista.getId());
                System.out.println("NOME: " + motorista.getNome());
                System.out.println("CNH: " + motorista.getCnh());
                System.out.println("VEÍCULO: " + motorista.getVeiculo());
                System.out.println("CIDADE_BASE: " + motorista.getCidade_base());
            }
        } else {
            System.out.println("Nenhum Motorista cadastrado.");
        }
    }
}
