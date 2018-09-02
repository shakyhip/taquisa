/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taquisa.clases;

import com.taquisa.claseabstracta.Alimento;

/**
 *
 * @author SHAVA
 */
public class Taco extends Alimento{
    private String tipo;
    private int presioU;

    public Taco(){}

    public Taco(String tipo, int presioU) {
        this.tipo = tipo;
        this.presioU = presioU;
    }
    
    @Override
    public String toString(){
        return getTipo();
    }
    
    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the presioU
     */
    public int getPresioU() {
        return presioU;
    }

    /**
     * @param presioU the presioU to set
     */
    public void setPresioU(int presioU) {
        this.presioU = presioU;
    }

}
