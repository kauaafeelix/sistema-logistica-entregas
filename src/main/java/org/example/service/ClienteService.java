package org.example.service;

import org.example.model.Cliente;
import org.example.view.ViewCliente;
import org.example.view.ViewGeral;

public class ClienteService {
    public void gerenciadorCliente(){
        ViewCliente cliente = new ViewCliente();
        int opcao = cliente.menuCliente();

        switch (opcao){
            case 1->{
                cliente.cadastrarCliente();
            }
            case 2->{}
            case 3->{}
            case 4->{}
            case 5->{}
            case 0->{}

        }
    }
}
