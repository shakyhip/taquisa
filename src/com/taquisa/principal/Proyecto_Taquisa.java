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
        System.out.println("Menu de Taqueria ~La Maciza~");
        System.out.println("1.- Dar de Alta un Tipo de Taco");
        System.out.println("2.- Generar Nueva Orden");
        System.out.println("3.- Mostrar Todas las Ordenes Pendientes");
        System.out.println("4.- Mostrar Orden Actual");
        System.out.println("5.- Modificar Orden Actual");
        System.out.println("6.- Servir Orden Actual");
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
                if(crud.MostrarTacos().isEmpty()){
                    System.out.println("No hay tipos de taco registrados \n Registre alguno(s) primero. \n");
                }else{
                    Taco[] tacos = new Taco[crud.MostrarTacos().size()];
                    System.out.println("~~~ Creando Nueva Orden ~~~");
          
                    ArrayDeque<TacosOrden> tacosDeOrden = agregarTacosAOrden(tacos, crud);
                    
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
                    System.out.println("Salsa? \n 1.- Verde \n 2.- Roja \n 3.- Ambas");
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
                    
                    Orden orden = new Orden(id, tacosDeOrden, siCilantro, siCebolla, 
                            salsa, siPicante, extras, contarTacos(tacosDeOrden), 
                            precioOrden(tacosDeOrden), siLlevar);
                    
                    crud.AgregarOrden(orden);
                    System.out.println(orden.pedido("Orden Agregada"));
                }
                break;
            case 3:
                if(crud.MostrarOrdenes().isEmpty()){
                    System.out.println("No hay ordenes pendientes \n");
                }else{
                    System.out.print("~~~ Todas las Ordenes ~~~");
                    for(Orden orden : crud.MostrarOrdenes()){
                        System.out.print("\n Numero de orden: " + orden.getId() +
                                "\n Total de tacos: " + orden.getCantidad() + 
                                "\n Tacos: ");
                        orden.getTacos().forEach((taco) -> {
                            System.out.print("\n " + taco.getCantidad() + " de " + taco.getTaco().getTipo());
                        });
                        System.out.print("\n Cilantro: " + orden.getCilantro() + 
                                "\n Cebolla: " + orden.getCebolla() + 
                                "\n Salsa: " + orden.getSalsa() + 
                                "\n Picante: " + orden.getPica() +
                                "\n Extras: " + orden.getExtras() +
                                "\n Para llevar: " + orden.getPaLlevar() +
                                "\n Total a Pagar: $" + orden.getPrecio() +
                                "\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n ");   
                    }
                }
                break;
            case 4:
                if(crud.MostrarOrdenes().isEmpty()){
                    System.out.println("No hay ordenes pendientes \n");
                }else{
                    System.out.print("La orden actual es:");
                    Orden ordenActual = crud.MostrarOrdenActual();
                    System.out.print("\n Numero de orden: " + ordenActual.getId() +
                            "\n Total de tacos: " + ordenActual.getCantidad() + 
                            "\n Tacos: ");
                    ordenActual.getTacos().forEach((taco) -> {
                        System.out.print("\n " + taco.getCantidad() + " de " + taco.getTaco().getTipo());
                    });
                    System.out.print("\n Cilantro: " + ordenActual.getCilantro() + 
                            "\n Cebolla: " + ordenActual.getCebolla() + 
                            "\n Salsa: " + ordenActual.getSalsa() + 
                            "\n Picante: " + ordenActual.getPica() +
                            "\n Extras: " + ordenActual.getExtras() +
                            "\n Para llevar: " + ordenActual.getPaLlevar() +
                            "\n Total a Pagar: $" + ordenActual.getPrecio() + 
                            "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n ");
                }
                break;
            case 5:
                if(crud.MostrarOrdenes().isEmpty()){
                    System.out.println("No hay ordenes para modificar\n");
                }else{
                    int op, v, t;
                    Orden ordenActual = crud.MostrarOrdenActual();
                    do{
                        System.out.println("Que Dato de la Orden Desea Modificar?"
                                + "\n 1.- Tacos \n 2.- Cilantro \n 3.- Cebolla \n 4.- Salsa"
                                + "\n 5.- Picante \n 6.- Extras \n 7.- Para llevar \n 8.- Salir");
                        op = scanNum.nextInt();
                        switch(op){
                            case 1:
                                System.out.println("Que Desea Hacer?"
                                        + "\n 1.- Modificar Cantidad de Tacos Existentes"
                                        + "\n 2.- Agregar Más Tacos"
                                        + "\n 3.- Salir");
                                op = scanNum.nextInt();
                                switch(op){
                                    case 1:
                                        System.out.println("Que Tacos desea Modificar?");
                                        TacosOrden[] tacosO = new TacosOrden[ordenActual.getTacos().size()];
                                        int j = 0;
                                        for(TacosOrden taco : ordenActual.getTacos()){
                                            tacosO[j] = taco;
                                            System.out.println(++j + ".-" + taco.getCantidad() + " de " + taco.getTaco().getTipo()); 
                                        }
                                        t = scanNum.nextInt();
                                        System.out.println("Dijite Nueva Cantidad: ");
                                        v = scanNum.nextInt();
                                        tacosO[t-1].setCantidad(v);
                                        
                                        ordenActual.getTacos().clear();
                                        for(int i=0;i<tacosO.length;i++){
                                            ordenActual.getTacos().add(tacosO[i]);
                                        }
                                        ordenActual.setPrecio(precioOrden(ordenActual.getTacos()));
                                        ordenActual.setCantidad(contarTacos(ordenActual.getTacos()));
                                        break;
                                    case 2:
                                        Taco[] tacos = new Taco[crud.MostrarTacos().size()];
                                        ordenActual.getTacos().addAll(agregarTacosAOrden(tacos,crud));
                                        ordenActual.setPrecio(precioOrden(ordenActual.getTacos()));
                                        ordenActual.setCantidad(contarTacos(ordenActual.getTacos()));
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            case 2:
                                System.out.println("Con Cilantro? \n 1.- Si \n 2.- No");
                                int cilantro = scanNum.nextInt();
                                boolean siCilantro = false;
                                if(cilantro == 1)
                                    siCilantro = true;
                                ordenActual.setCilantro(siCilantro);
                                break;
                            case 3:
                                System.out.println("Con Cebolla? \n 1.- Si \n 2.- No");
                                int cebolla = scanNum.nextInt();
                                boolean siCebolla = false;
                                if(cebolla == 1)
                                    siCebolla = true;
                                ordenActual.setCebolla(siCebolla);
                                break;
                            case 4:
                                System.out.println("Con Salsa? \n 1.- Verde \n 2.- Roja \n 3.- Ambas");
                                int salsa = scanNum.nextInt();
                                ordenActual.setSalsa(salsa);
                                break;
                            case 5:
                                System.out.println("Con Picante? \n 1.- Si \n 2.- No");
                                int picante = scanNum.nextInt();
                                boolean siPicante = false;
                                if(picante == 1)
                                    siPicante = true;
                                ordenActual.setPica(siPicante);
                                break;
                            case 6:
                                System.out.println("Extras:");
                                String extras = scanLine.nextLine();
                                ordenActual.setExtras(extras);
                                break;
                            case 7:
                                System.out.println("Es para llevar? \n 1.- Si \n 2.- No");
                                int llevar = scanNum.nextInt();
                                boolean siLlevar = false;
                                if(llevar == 1)
                                    siLlevar = true;
                                ordenActual.setPaLlevar(siLlevar);
                                break;
                            default:
                                break;
                        }
                        System.out.println("Desea Modificar otra cosa? \n 1.- Si \n 2.- No");
                        op = scanNum.nextInt();
                    }while(op == 1);
                    crud.Modificar(ordenActual.getTacos(),ordenActual.isCilantro(),
                            ordenActual.isCebolla(), ordenActual.valueSalsa(), 
                            ordenActual.isPica(), ordenActual.getExtras(), ordenActual.getCantidad(), 
                            ordenActual.getPrecio(), ordenActual.isPaLlevar());
                }
                break;
            case 6:
                if(crud.MostrarOrdenes().isEmpty()){
                    System.out.println("No hay más ordenes pendientes \n");
                }else{
                    Orden ordenActual = crud.MostrarOrdenActual();
                    System.out.println(ordenActual.servido("Orden " + ordenActual.getId() + " Servida"));
                    crud.MostrarOrdenes().pop();
                }
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    } 

    private static double precioOrden(ArrayDeque<TacosOrden> tacosDeOrden) {
        double precio = 0;
        for(TacosOrden taco : tacosDeOrden){
            precio += taco.getCantidad() * taco.getTaco().getPresioU();
        }
        return precio;
    }

    private static ArrayDeque<TacosOrden> agregarTacosAOrden(Taco[] tacos,Crud crud) {
        Scanner scanNum = new Scanner(System.in);
        Scanner scanLine = new Scanner(System.in);
        int opc;
        ArrayDeque<TacosOrden> tacosDeOrden = new ArrayDeque<>();
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
                    
            System.out.println("Agregar más tacos? \n 1.- Si \n 2.- No");
            opc = scanNum.nextInt();
        }while(opc == 1);
        return tacosDeOrden;
    }

    private static int contarTacos(ArrayDeque<TacosOrden> tacosDeOrden) {
        int total = 0;
        for(TacosOrden tacos : tacosDeOrden){
            total += tacos.getCantidad();
        }
        return total;
    }
    
    
}
