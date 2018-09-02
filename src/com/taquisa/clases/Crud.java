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
    
    
    public Orden MostrarOrden(){
        return ordenes.peek();
    }
    
    public void Buscar(int id){
    }
    
    public boolean Verificar(int id){
      
        return false;    
    }
    
    public void Modificar(int id){
        
    }
    
    public void Eliminar(int id){
        
    }
}
