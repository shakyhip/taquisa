/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taquisa.principal;

import com.taquisa.clases.Orden;
import com.taquisa.clases.Taco;
import com.taquisa.clases.Crud;
import com.taquisa.clases.TacosOrden;
import java.util.ArrayDeque;
import java.util.Scanner;

/**
 *
 * @author SHAVA
 */
public class Proyecto_Taquisa {
    
    public static void main(String[] args) {
        Crud crud = new Crud();
        int opcion;
        do{
            opcion = Menu();
            opcionesSwitch(opcion, crud);
        }while(opcion!=0);
        
    }

    private static int Menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Menu de Tacos");
        System.out.println("1.- Dar de alta un tipo de Taco");
        System.out.println("2.- Generar Nueva Orden");
        System.out.println("3.- Mostrar Orden Actual");
        System.out.println("4.- Todas las Ordenes Pendientes");
        System.out.println("5.- Modificar Orden");
        System.out.println("6.- Cancelar Orden");
        System.out.println("0.- Salir");
        int opc = scan.nextInt();
        return opc;
    }

    private static void opcionesSwitch(int opcion, Crud crud) {
        Scanner scanNum = new Scanner(System.in);
        Scanner scanLine = new Scanner(System.in);
        int opc;
        switch(opcion){
            case 0:
                System.out.println("Sale bye :D ");
                break;
            case 1:
                do{
                    System.out.println("Tipo de Taco (Carne):");
                    String tipo = scanLine.nextLine();
                    
                    System.out.println("Precio Establecido?: ");
                    int precio = scanNum.nextInt();
                    
                    Taco taco = new Taco(tipo, precio);
                    
                    crud.AgregarTaco(taco);
                    
                    System.out.println("Dar de alta otro taco? \n 1.- Si \n 2.- No");
                    opc = scanNum.nextInt();
                }while(opc == 1);
                break;
            case 2:
                ArrayDeque<TacosOrden> tacosDeOrden = new ArrayDeque<>();
                Taco[] tacos = new Taco[crud.MostrarTacos().size()];
                do{
                    int i = 0;
                    System.out.println("Cuantos?");
                    int cuantos = scanNum.nextInt();
                    
                    System.out.println("De que?");
                    for(Taco taco : crud.MostrarTacos()){
                        tacos[i] = taco;
                        System.out.println(++i + ".-" + taco.getTipo()); 
                    }
                    
                    int deque = scanNum.nextInt();
                    TacosOrden tacosOrden = new TacosOrden(tacos[deque-1], cuantos);
                    tacosDeOrden.add(tacosOrden);
                    
                    System.out.println("Más tacos? \n 1.- Si \n 2.- No");
                    opc = scanNum.nextInt();
                }while(opc == 1);
                System.out.println("Cilantro? \n 1.- Si \n 2.- No");
                int cilantro = scanNum.nextInt();
                boolean siCilantro = false;
                if(cilantro == 1){
                    siCilantro = true;
                }
                System.out.println("Cebolla? \n 1.- Si \n 2.- No");
                int cebolla = scanNum.nextInt();
                boolean siCebolla = false;
                if(cebolla == 1){
                    siCebolla = true;
                }
                System.out.println("Salsa \n 1.- Verde \n 2.- Roja \n 3.- Ambas");
                int salsa = scanNum.nextInt();
                System.out.println("Picante? \n 1.- Si \n 2.- No");
                int picante = scanNum.nextInt();
                boolean siPicante = false;
                if(picante == 1){
                    siPicante = true;
                }
                System.out.println("Extras:");
                String extras = scanLine.nextLine();
                System.out.println("Para llevar? \n 1.- Si \n 2.- No");
                int llevar = scanNum.nextInt();
                boolean siLlevar = false;
                if(llevar == 1){
                    siLlevar = true;
                }
                System.out.println("Numero de orden:");
                int id = scanNum.nextInt();
                Orden orden = new Orden(id, tacosDeOrden, siCilantro, siCebolla, salsa, siPicante, extras, tacosDeOrden.size(), siLlevar);
                crud.AgregarOrden(orden);
                System.out.println(orden.pedido("Orden Agregada"));

                break;
            case 3:
                System.out.println("La orden actual es...");
                Orden ordenActual = crud.MostrarOrden();
                System.out.println(ordenActual.getId());
                //Perrito[] perritos = lista.Mostrar();
                //for(Perrito perrito : perritos)
                //{
                    //System.out.println(" Nombre: "+ perrito.getNombre() + 
                                    //"\n Raza: " + perrito.getRaza() + 
                            //"\n Pedigree: " + (perrito.isPedigri() ? "Si" : "No"));
                    //System.out.println("****************************************");
               // }
                break;
            case 4:
                System.out.println("id del perrito a buscar?");
                //int id  = scan.nextInt();
                //if(lista.Verificar(id))
                //{
                    //Perrito perrito = lista.Buscar(id);
                    //System.out.println(" Nombre: "+ perrito.getNombre() +
                            //"\n Raza: " + perrito.getRaza() +
                            //"\n Pedigree: " + (perrito.isPedigri() ? "Si" : "No"));
                    //System.out.println("****************************************");
                //}
                //else{
                    //System.out.println("Este perro no existe");
                    //System.out.println("****************************************");
                //}
                break;
            case 5:
                break;
            case 6:
                break;
            
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }   
}
