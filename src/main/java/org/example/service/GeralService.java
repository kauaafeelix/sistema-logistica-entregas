package org.example.service;


import org.example.view.ViewCliente;
import org.example.view.ViewGeral;

import org.example.view.ViewGeral;
import org.example.view.ViewMotorista;

public class GeralService {
    public void gerenciadorService(){

        int opcao = ViewGeral.menuGeral();

        switch (opcao){
            case 1-> {
                ClienteService clienteService = new ClienteService();
                clienteService.gerenciadorCliente();
            }
            case 2->{
                MotoristaService motoristaService = new MotoristaService();
                motoristaService.gerenciadorMotorista();
            }
            case 3->{}
            case 4->{}
            case 5->{}
            case 0->{}

        }
    }
}
