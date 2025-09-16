package org.example.service;

import org.example.view.ViewCliente;
import org.example.view.ViewGeral;
import org.example.view.ViewMotorista;

public class MotoristaService {
    public void gerenciadorMotorista(){
        int opcao = ViewMotorista.menuMotorista();

        switch (opcao){
            case 1->{
                ViewMotorista.cadastrarMotorista();
            }
            case 2->{
                ViewMotorista.listarMotoristas();
            }
            case 3->{
                ViewMotorista.buscarMotorista();
            }
            case 4->{
                ViewMotorista.excluirMotorista();
            }
            case 0->{
                ViewGeral.menuGeral();
            }
        }
    }
}
