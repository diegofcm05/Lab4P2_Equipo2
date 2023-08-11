/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab4p2_equipo2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author dfcm9
 */
public class Lab4P2_Equipo2 {
    
    static Scanner sc = new Scanner(System.in);
    static Scanner scs = new Scanner(System.in);
    static ArrayList<Entrenador> entrenadores = new ArrayList();
    static ArrayList<Movimiento> Movements = new ArrayList();
    static Random ran=new Random();

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
        System.out.println("Ingrese el nivel de pokemon: ");
        String level=scs.nextLine();
        while (!checknum(level)){
            System.out.println("Ingrese un NUMERO valido: ");
            level=scs.nextLine();
        }
        while(Integer.parseInt(level)<1){
            do{
            System.out.println("Ingrese un NUMERO valido: ");
            level=scs.nextLine();
            }while(!checknum(level));
        }
        System.out.println("Ingrese la cantidad de puntos que necesita el pokemon para subir de nivel: ");
        String ex=scs.nextLine();
        while (!checknum(ex)){
            System.out.println("Ingrese un NUMERO valido: ");
            ex=scs.nextLine();
        }
        while(Integer.parseInt(ex)<1){
            do{
                System.out.println("Ingrese un NUMERO valido: ");
                ex=scs.nextLine();
            }while(!checknum(ex));
        }
        int cont=0;
        String mov="";
        Movimiento[] movi=new Movimiento [4];
        while(cont<4){
            printMovimientos();
            System.out.println("Movimiento de el slot#"+(cont+1));
            System.out.println("Ingrese el indice del movimiento que desea agregarle al pokemon: ");
            mov=sc.nextLine();
            while(!checknum(mov)){
                System.out.println("Ingrese un indice valido: ");
                mov=sc.nextLine();
            }
            while(Integer.parseInt(mov)<1||Integer.parseInt(mov)>Movements.size()){
                do{
                    System.out.println("Ingrese un NUMERO valido: ");
                    mov=scs.nextLine();
                }while(!checknum(mov));
            }
            movi[cont]=Movements.get(Integer.parseInt(mov)-1);
            cont++;
        }
        System.out.println("Ingrese la cantidad de vida del pokemon: ");
        String Hp=sc.nextLine();
        while(!checknum(Hp)){
            System.out.println("Ingrese un Numero valido: ");
            Hp=sc.nextLine();
        }
        while(Integer.parseInt(Hp)<1){
            do{
                System.out.println("Ingrese un NUMERO valido: ");
                Hp=scs.nextLine();
            }while(!checknum(Hp));
        }
        
        System.out.println("Ingrese la cantidad de ataque del pokemon: ");
        String Atk=sc.nextLine();
        while(!checknum(Atk)){
            System.out.println("Ingrese un Numero valido: ");
            Atk=sc.nextLine();
        }
        while(Integer.parseInt(Atk)<1){
            do{
                System.out.println("Ingrese un NUMERO valido: ");
                Atk=scs.nextLine();
            }while(!checknum(Atk));
        }
        
        System.out.println("Ingrese la cantidad de Defensa del pokemon: ");
        String Def=sc.nextLine();
        while(!checknum(Def)){
            System.out.println("Ingrese un Numero valido: ");
            Def=sc.nextLine();
        }
        while(Integer.parseInt(Def)<1){
            do{
                System.out.println("Ingrese un NUMERO valido: ");
                Def=scs.nextLine();
            }while(!checknum(Def));
        }
        
        System.out.println("Ingrese la cantidad de ataque especial del pokemon: ");
        String Sp=sc.nextLine();
        while(!checknum(Sp)){
            System.out.println("Ingrese un Numero valido: ");
            Sp=sc.nextLine();
        }
        while(Integer.parseInt(Sp)<1){
            do{
                System.out.println("Ingrese un NUMERO valido: ");
                Sp=scs.nextLine();
            }while(!checknum(Sp));
        }
        System.out.println("Ingrese la cantidad de velocidad del pokemon: ");
        String vel=sc.nextLine();
        while(!checknum(vel)){
            System.out.println("Ingrese un Numero valido: ");
            vel=sc.nextLine();
        }
        while(Integer.parseInt(vel)<1){
            do{
                System.out.println("Ingrese un NUMERO valido: ");
                vel=scs.nextLine();
            }while(!checknum(vel));
        }
        
        Pokemon x = new Pokemon(nombre, "Neutral", 0, Integer.parseInt(ex),Integer.parseInt(Hp) , Integer.parseInt(Atk), Integer.parseInt(Def), Integer.parseInt(Sp), Integer.parseInt(vel));
        return x;
        
    }
    public static void printMovimientos(){
        for (Movimiento Movement : Movements) {
            System.out.println((Movements.indexOf(Movement)+1)+".- "+Movement);
        }
    }
    
}
