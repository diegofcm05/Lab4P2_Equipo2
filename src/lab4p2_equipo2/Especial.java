/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4p2_equipo2;

import java.util.Random;

/**
 *
 * @author dfcm9
 */
public class Especial extends Movimiento{
    
    private int poder;
    private int presicion;

    public Especial(int poder, int presicion, String nombre, String descripcion, String tipo) {
        super(nombre, descripcion, tipo);
        this.poder = poder;
        this.presicion = presicion;
    }

    

    public Especial() {
        super();
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public int getPresicion() {
        return presicion;
    }

    public void setPresicion(int presicion) {
        this.presicion = presicion;
    }

    @Override
    public String toString() {
        return "Fisico{" + "poder=" + poder + ", presicion=" + presicion + '}';
    }

    @Override
    public int Movement(Pokemon atacante, Pokemon Defensor) {
        Random ran1=new Random();
        Random ran2=new Random();
        int rand1=ran1.nextInt(50-1+1)+1;
        int rand2=ran1.nextInt(500-100+1)+1;
        int suma=atacante.getSp()+Defensor.getSp();
        if(suma==rand2){
            rand1*=2;
        }
        
        return rand1;
    }
    
    
    
    
    
}
