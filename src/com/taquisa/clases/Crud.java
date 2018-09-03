/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taquisa.clases;

import java.util.ArrayDeque;

/**
 *
 * @author SHAVA
 */
public class Crud {
    
    ArrayDeque<Orden> ordenes = new ArrayDeque<>();
    ArrayDeque<Taco> tacos = new ArrayDeque<>();
    
    public Crud(){}

    
    public void AgregarTaco(Taco taco){
        tacos.add(taco);
    }
    
    public ArrayDeque<Taco> MostrarTacos(){
        return tacos;
    }
    
    public void AgregarOrden(Orden orden){
        ordenes.add(orden);
    }
    
    
    public Orden MostrarOrdenActual(){
        return ordenes.peek();
    }

    
    public ArrayDeque<Orden> MostrarOrdenes(){
        return ordenes;
    }
   
    
    public void Modificar(ArrayDeque<TacosOrden> tacos, boolean cilantro, 
            boolean cebolla, int salsa, boolean pica, String extras, int cantidad, 
            double precio, boolean paLlevar){
        ordenes.peek().setTacos(tacos);
        ordenes.peek().setCilantro(cilantro);
        ordenes.peek().setCebolla(cebolla);
        ordenes.peek().setSalsa(salsa);
        ordenes.peek().setPica(pica);
        ordenes.peek().setExtras(extras);
        ordenes.peek().setCantidad(cantidad);
        ordenes.peek().setPrecio(precio);
        ordenes.peek().setPaLlevar(paLlevar);
    }
}
