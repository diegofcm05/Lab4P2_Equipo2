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
public class Fisico extends Movimiento{
    
    private int poder;
    private int presicion;

    public Fisico(int poder, int presicion, String nombre, String descripcion) {
        super(nombre, descripcion);
        this.poder = poder;
        this.presicion = presicion;
    }

    public Fisico() {
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
        int rand1=ran1.nextInt(50-1+1)+1;
        if(atacante.getAtk()>Defensor.getDef()){
            rand1*=2;
        }
        else if(atacante.getAtk()<Defensor.getDef()){
            rand1/=2;
        }
        
        return rand1;
    }
    
    
    
}
