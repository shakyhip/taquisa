/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taquisa.clases;

/**
 *
 * @author SHAVA
 */
public class TacosOrden {
    private Taco taco;
    private int cantidad;

    public TacosOrden() {
    }

    public TacosOrden(Taco taco, int cantidad) {
        this.taco = taco;
        this.cantidad = cantidad;
    }

    /**
     * @return the taco
     */
    public Taco getTaco() {
        return taco;
    }

    /**
     * @param taco the taco to set
     */
    public void setTaco(Taco taco) {
        this.taco = taco;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
