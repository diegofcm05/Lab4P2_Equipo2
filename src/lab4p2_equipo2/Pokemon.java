/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4p2_equipo2;

/**
 *
 * @author Junnior Sauceda
 */
public class Pokemon {
    private String especie,estado;
    private int expacum,expne,hp,atk,def,sp,spe,nivel;
    private Movimiento [] ataques=new Movimiento [4];

    public Pokemon() {
    }

    public Pokemon(String especie, int nivel, String estado, int expacum, int expne, int hp, int atk, int def, int sp, int spe) {
        this.especie = especie;
        this.nivel = nivel;
        this.estado = estado;
        this.expacum = expacum;
        this.expne = expne;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.sp = sp;
        this.spe = spe;
        
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getExpacum() {
        return expacum;
    }

    public void setExpacum(int expacum) {
        this.expacum = expacum;
    }

    public int getExpne() {
        return expne;
    }

    public void setExpne(int expne) {
        this.expne = expne;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getSpe() {
        return spe;
    }

    public void setSpe(int spe) {
        this.spe = spe;
    }
    
    

    public Movimiento[] getAtaques() {
        return ataques;
    }

    public void setAtaques(Movimiento[] ataques) {
        this.ataques = ataques;
    }

    

    @Override
    public String toString() {
        return "Pokemon{" + "Especie=" + especie + ", Estado Actual=" + estado + ", Experiencia "
                + "Actual=" + expacum + ", Experiencia Necesaria=" + expne + ", HP=" + hp + ", ATK=" + atk + 
                ", DEF=" + def + ", SP=" + sp + ", SPE=" + spe + ", Ataques=" + ataques + '}';
    }
    
    
}
