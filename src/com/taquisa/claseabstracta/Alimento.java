/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taquisa.claseabstracta;

/**
 *
 * @author SHAVA
 */
public abstract class Alimento {
    private String origen;

    //Contructor sin parametros
    public Alimento() {
    }
    
//Contructor con parametros
    public Alimento(String origen) {
        this.origen = origen;
    }

    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }
}
