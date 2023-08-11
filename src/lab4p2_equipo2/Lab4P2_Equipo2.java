/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab4p2_equipo2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dfcm9
 */
public class Lab4P2_Equipo2 {
    
    static Scanner sc = new Scanner(System.in);
    static Scanner scs = new Scanner(System.in);
    static ArrayList<Entrenador> entrenadores = new ArrayList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean resp = true;
        while (resp){
            System.out.println("Menu de Lab 4 - Pokemon");
            System.out.println("1. Registrar Entrenador");
            System.out.println("2. Battle Factory");
            System.out.println("3. Capturar/Entrenar Pokemon");
            System.out.println("4. Añadir Movimientos");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opcion.");
            String op = scs.nextLine();
            while (!checknum(op)){
                System.out.println("Ingrese un NUMERO, por favor.");
                op = scs.nextLine();
            }
            switch (Integer.parseInt(op)) {
                case 1: {
                    addTrainer();
                    break;
                }
                case 2: {
                    if (entrenadores.size()<2){
                        System.out.println("Necesita agregar por lo menos 2 entrenadores para ingresar a esta opcion.");
                    }
                    else{
                        
                    }
                    break;
                }
                case 3: {
                    if (entrenadores.size()<1){
                        System.out.println("Necesita agregar por lo menos 1 entrenador para ingresar a esta opcion.");
                    }
                    else{
                        
                    }
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
                    resp = false;
                    break;
                }
                default:
                {
                    System.out.println("Ingrese un indice valido");
                }
                
            }
            
            
            
        }
    }
    
    public static boolean checknum(String x){
        boolean bueno = true;
        for (int i = 0; i <x.length(); i++) {
            char e = x.charAt(i);
            if (e<48 || e>57){
                bueno = false;
                break;
            }
            
            
        }
        return bueno;
                
    }
    
    public static boolean checkdecimal(String x){
        boolean bueno = true;
        int countpoint = 0;
        for (int i = 0; i <x.length(); i++) {
            char e = x.charAt(i);
            if ((e<48 || e>57) && e!=46){
                bueno = false;
                break;
            }
            if (e == 46){
                countpoint++;
            } 
        }
        
        if(countpoint >1){
            bueno = false;
        }
        return bueno;
                
    }
    
    public static void addTrainer(){
        String nombre, edad, dinero;
        System.out.println("A continuacion agregara un entrenador. Favor ingrese los siguientes datos:");
        System.out.println("Ingrese nombre:");
        nombre = scs.nextLine();
        System.out.println("Ingrese edad: ");
        edad = scs.nextLine();
        while (!checknum(edad)){
                System.out.println("Ingrese un NUMERO valido, por favor.");
                edad = scs.nextLine();
        }
        System.out.println("Ingrese el dinero en su cuenta: ");
        dinero = scs.nextLine();
        while (!checkdecimal(dinero)){
            System.out.println("Ingrese un NUMERO valido, por favor.");
            dinero = scs.nextLine();
        }
        
        Entrenador x = new Entrenador(nombre, Integer.parseInt(edad), Double.parseDouble(dinero));
        entrenadores.add(x);
        System.out.println("El entrenador ha sido agregado exitosamente!");
    }
    
    public static Pokemon addPokemon(){
        System.out.println("Capturo un Pokemon! Ingrese los siguientes datos:");
        System.out.println("Ingrese la especie del pokemon: ");
        String nombre=scs.nextLine();
        Pokemon x = new Pokemon();
        return x;
        
    }
    
}
