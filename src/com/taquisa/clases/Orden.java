/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taquisa.clases;

import com.taquisa.interfaz.IEstado;
import java.util.ArrayDeque;

/**
 *
 * @author SHAVA
 */
public class Orden implements IEstado{
    
    private int id;
    private ArrayDeque<TacosOrden> tacos;
    private boolean cilantro;
    private boolean cebolla;
    private int salsa;
    private boolean pica;
    private String extras;
    private int cantidad;
    private double precio;
    private boolean paLlevar;

    public Orden() {
    }

    public Orden(int id, ArrayDeque<TacosOrden> tacos, boolean cilantro, boolean cebolla, int salsa, boolean pica, String extras, int cantidad, boolean paLlevar) {
        this.id = id;
        this.tacos = tacos;
        this.cilantro = cilantro;
        this.cebolla = cebolla;
        this.salsa = salsa;
        this.pica = pica;
        this.extras = extras;
        this.cantidad = cantidad;
        //this.precio = precio;
        this.paLlevar = paLlevar;
        
    }
    
    @Override
    public String pedido(String estado) {
        return estado;
    }

    @Override
    public String servido(String estado) {
        return estado;
    }

    /**
     * @return the cilantro
     */
    public boolean isCilantro() {
        return cilantro;
    }

    /**
     * @param cilantro the cilantro to set
     */
    public void setCilantro(boolean cilantro) {
        this.cilantro = cilantro;
    }

    /**
     * @return the cebolla
     */
    public boolean isCebolla() {
        return cebolla;
    }

    /**
     * @param cebolla the cebolla to set
     */
    public void setCebolla(boolean cebolla) {
        this.cebolla = cebolla;
    }

    /**
     * @return the salsa
     */
    public int getSalsa() {
        return salsa;
    }

    /**
     * @param salsa the salsa to set
     */
    public void setSalsa(int salsa) {
        this.salsa = salsa;
    }

    /**
     * @return the pica
     */
    public boolean isPica() {
        return pica;
    }

    /**
     * @param pica the pica to set
     */
    public void setPica(boolean pica) {
        this.pica = pica;
    }

    /**
     * @return the extras
     */
    public String getExtras() {
        return extras;
    }

    /**
     * @param extras the extras to set
     */
    public void setExtras(String extras) {
        this.extras = extras;
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

    /**
     * @return the paLlevar
     */
    public boolean isPaLlevar() {
        return paLlevar;
    }

    /**
     * @param paLlevar the paLlevar to set
     */
    public void setPaLlevar(boolean paLlevar) {
        this.paLlevar = paLlevar;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the tacos
     */
    public ArrayDeque<TacosOrden> getTacos() {
        return tacos;
    }

    /**
     * @param tacos the tacos to set
     */
    public void setTacos(ArrayDeque<TacosOrden> tacos) {
        this.tacos = tacos;
    }

    
}
