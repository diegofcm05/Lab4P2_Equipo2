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
public class Estado extends Movimiento{
    
    private String probest;

    public Estado(String probest, String nombre, String descripcion, String tipo) {
        super(nombre, descripcion, tipo);
        this.probest = probest;
    }

   

    public Estado() {
        super();
    }
    

    public String getProbest() {
        return probest;
    }

    public void setProbest(String probest) {
        this.probest = probest;
    }

    @Override
    public String toString() {
        return "Estado{" + "probest=" + probest + '}';
    }
    
    @Override
    public int Movement(Pokemon atacante, Pokemon Defensor) {
        Random ran1=new Random();
        int rand1=ran1.nextInt(100-1+1)+1;
        
        return rand1;
    }
    
    
}
