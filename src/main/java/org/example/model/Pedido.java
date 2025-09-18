package org.example.model;

import org.example.model.enums.StatusPedido;

import java.time.LocalDate;

public class Pedido {
    private int id;
    private int cliente_id;
    private LocalDate data_pedido;
    private double volume_m3;
    private double peso_kg;
    private StatusPedido status;

    public Pedido(int id, int cliente_id, LocalDate data_pedido, double volume_m3, double peso_kg, StatusPedido status) {
        this.id = id;
        this.cliente_id = cliente_id;
        this.data_pedido = data_pedido;
        this.volume_m3 = volume_m3;
        this.peso_kg = peso_kg;
        this.status = status;
    }

    public Pedido(int cliente_id, LocalDate data_pedido, double volume_m3, double peso_kg) {
        this.cliente_id = cliente_id;
        this.data_pedido = data_pedido;
        this.volume_m3 = volume_m3;
        this.peso_kg = peso_kg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public LocalDate getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(LocalDate data_pedido) {
        this.data_pedido = data_pedido;
    }

    public double getVolume_m3() {
        return volume_m3;
    }

    public void setVolume_m3(double volume_m3) {
        this.volume_m3 = volume_m3;
    }

    public double getPeso_kg() {
        return peso_kg;
    }

    public void setPeso_kg(double peso_kg) {
        this.peso_kg = peso_kg;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
