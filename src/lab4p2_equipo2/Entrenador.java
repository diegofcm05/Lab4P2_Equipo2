/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4p2_equipo2;

import java.util.ArrayList;

/**
 *
 * @author dfcm9
 */
public class Entrenador {

    private String nombre;
    private int edad;
    private double dinero;
    private Pokemon[] equipo = new Pokemon[6];
    private ArrayList<Pokemon> caja = new ArrayList();

    public Entrenador(String nombre, int edad, double dinero) {
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
    }

    public Entrenador() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public Pokemon[] getEquipo() {
        return equipo;
    }

    public void setEquipo(Pokemon[] equipo) {
        this.equipo = equipo;
    }

    public ArrayList<Pokemon> getCaja() {
        return caja;
    }

    public void setCaja(ArrayList<Pokemon> caja) {
        this.caja = caja;
    }

    @Override
    public String toString() {
        if (equipo[0] != null) {
            String eq = "[";
            for (int i = 0; i < equipo.length; i++) {
                if(equipo[i]==null){
                    
                }
                else{
                eq += ((Pokemon) equipo[i]).toString() + ", ";
                }
            }
            eq += "]";
            return "Entrenador{" + "nombre=" + nombre + ", edad=" + edad + ", dinero=" + dinero + ", equipo=" + eq + ", caja=" + caja + '}';
        }
        else{
            return "Entrenador{" + "nombre=" + nombre + ", edad=" + edad + ", dinero=" + dinero + ", equipo=" + "[]" + ", caja=" + caja + '}';
        }
    }

}
