package org.example.service;

import org.example.view.ViewCliente;
import org.example.view.ViewMotorista;

public class MotoristaService {
    ViewMotorista motorista = new ViewMotorista();
    public void gerenciadorMotorista(){
        int opcao = ViewMotorista.menuMotorista();

        switch (opcao){
            case 1->{
                motorista.cadastrarMotorista();
            }
            case 2->{}
            case 3->{}
            case 4->{}
            case 0->{}
        }
    }
}
