/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4p2_equipo2;

/**
 *
 * @author dfcm9
 */
public class Estado extends Movimiento{
    
    private String probest;

    public Estado(String probest, String nombre, String descripcion) {
        super(nombre, descripcion);
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
    
    
    
    
}
