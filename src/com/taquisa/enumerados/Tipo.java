/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taquisa.enumerados;

/**
 *
 * @author SHAVA
 */
public enum Tipo {
    BISTEK(8), SUADERO(8), CHORIZO(7), ADOBADA(8), LENGUA(10), PASTOR(9), BARBCOA(11);
    
    int precioUnitario;

    Tipo(){}
    
    Tipo(int precioUnitario){
        this.precioUnitario = precioUnitario;
    }
    /**
     * @return the calorias
     */
    public int getPrecioUnitario() {
        return precioUnitario;
    }
}
