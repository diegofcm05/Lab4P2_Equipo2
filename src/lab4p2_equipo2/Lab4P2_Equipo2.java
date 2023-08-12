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
    static Random ran = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean resp = true;
        while (resp) {
            System.out.println("Menu de Lab 4 - Pokemon");
            System.out.println("1. Registrar Entrenador");
            System.out.println("2. Battle Factory");
            System.out.println("3. Capturar/Entrenar Pokemon");
            System.out.println("4. Añadir Movimientos");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opcion.");
            String op = scs.nextLine();
            while (!checknum(op)) {
                System.out.println("Ingrese un NUMERO, por favor.");
                op = scs.nextLine();
            }
            switch (Integer.parseInt(op)) {
                case 1: {
                    addTrainer();
                    break;
                }
                case 2: {
                    if (entrenadores.size() < 2) {
                        System.out.println("Necesita agregar por lo menos 2 entrenadores para ingresar a esta opcion.");
                    } else {
                        ArrayList<Entrenador> entrenadores1=entrenadores;
                        System.out.println("Seleccione el entrenador con el que desea jugar Jugador 1");
                        for (Entrenador ent : entrenadores1) {
                            System.out.println((entrenadores1.indexOf(ent) + 1) + "- " + ent);
                        }
                        String ind = scs.nextLine();
                        while (!checknum(ind)) {
                            System.out.println("Ingrese un NUMERO, por favor.");
                            ind = scs.nextLine();
                        }
                        while (Integer.parseInt(ind) < 1 || Integer.parseInt(ind) > entrenadores1.size()) {
                            do {
                                System.out.println("Ingrese un NUMERO valido: ");
                                ind = scs.nextLine();
                            } while (!checknum(ind));
                        }
                        Entrenador J1 = entrenadores1.get(Integer.parseInt(ind) - 1);
                        entrenadores1.remove(Integer.parseInt(ind) - 1);
                        Pokemon[] eq = J1.getEquipo();
                        System.out.println("Escoga el pokemon:");
                        for (int i = 0; i < eq.length; i++) {
                            System.out.println((i + 1) + "- " + eq[i]);

                        }
                        String ind2 = scs.nextLine();
                        while (!checknum(ind2)) {
                            do {
                                System.out.println("Ingrese un numero valido, por favor.");
                                ind2 = scs.nextLine();
                            } while (Integer.parseInt(ind2) < 1 || Integer.parseInt(ind2) > eq.length || eq[Integer.parseInt(ind2)] == null);
                        }
                        Pokemon P1 = eq[Integer.parseInt(ind2)-1];

                        System.out.println("Seleccione el entrenador con el que desea jugar Jugador 2");
                        for (Entrenador ent : entrenadores1) {
                            System.out.println((entrenadores1.indexOf(ent) + 1) + "- " + ent);
                        }
                        ind = scs.nextLine();
                        while (!checknum(ind)) {
                            System.out.println("Ingrese un NUMERO, por favor.");
                            ind = scs.nextLine();
                        }
                        while (Integer.parseInt(ind) < 1 || Integer.parseInt(ind) > entrenadores1.size()) {
                            do {
                                System.out.println("Ingrese un NUMERO valido: ");
                                ind = scs.nextLine();
                            } while (!checknum(ind));
                        }
                        Entrenador J2 = entrenadores1.get(Integer.parseInt(ind) - 1);
                        eq = J2.getEquipo();
                        System.out.println("Escoga el pokemon:");
                        for (int i = 0; i < eq.length; i++) {
                            System.out.println((i + 1) + "- " + eq[i]);

                        }
                        ind2 = scs.nextLine();
                        while (!checknum(ind2)) {
                            do {
                                System.out.println("Ingrese un numero valido, por favor.");
                                ind2 = scs.nextLine();
                            } while (Integer.parseInt(ind2) < 1 || Integer.parseInt(ind2) > eq.length || eq[Integer.parseInt(ind2)] == null);
                        }
                        Pokemon P2 = eq[Integer.parseInt(ind2)-1];
                        boolean vel = true;
                        if (P1.getSpe() > P2.getSpe()) {
                            vel = true;
                        } else if (P1.getSpe() == P2.getSpe()) {
                            vel = true;
                        } else if (P1.getSpe() < P2.getSpe()) {
                            vel = false;
                        }
                        while (P1.getHp() > 0 && P2.getHp() > 0) {
                            if (vel) {
                                System.out.println("Turno del Jugador 1: ");
                                for (int i = 0; i < P1.getAtaques().length; i++) {
                                    System.out.println((i + 1) + ".- " + P1.getAtaques()[i]);
                                }
                                System.out.println("Seleccione el movimiento que desea realizar: ");
                                String mov = scs.nextLine();
                                while (!checknum(mov)) {
                                    System.out.println("Ingrese un NUMERO, por favor.");
                                    mov = scs.nextLine();
                                }
                                while (Integer.parseInt(mov) < 1 || Integer.parseInt(mov) > P1.getAtaques().length) {
                                    do {
                                        System.out.println("Ingrese un NUMERO valido: ");
                                        mov = scs.nextLine();
                                    } while (!checknum(mov));
                                }
                                if (P1.getAtaques()[Integer.parseInt(mov) - 1] instanceof Estado) {
                                    if (P1.getAtaques()[Integer.parseInt(mov) - 1].Movement(P1, P2) < 75 && P1.getAtaques()[Integer.parseInt(mov) - 1].Movement(P1, P2) > 1) {
                                        P2.setEstado(((Estado) P1.getAtaques()[Integer.parseInt(mov) - 1]).getProbest());
                                        System.out.println(P2.getEspecie() + " esta en el estado " + ((Estado) P1.getAtaques()[Integer.parseInt(mov) - 1]).getProbest());
                                    }
                                } else {
                                    P2.setHp(P2.getHp() - (P1.getAtaques()[Integer.parseInt(mov) - 1].Movement(P1, P2)));
                                }

                                System.out.println("Turno del Jugador 2: ");
                                for (int i = 0; i < P1.getAtaques().length; i++) {
                                    System.out.println((i + 1) + ".- " + P2.getAtaques()[i]);
                                }
                                System.out.println("Seleccione el movimiento que desea realizar: ");
                                mov = scs.nextLine();
                                while (!checknum(mov)) {
                                    System.out.println("Ingrese un NUMERO, por favor.");
                                    mov = scs.nextLine();
                                }
                                while (Integer.parseInt(mov) < 1 || Integer.parseInt(mov) > P2.getAtaques().length) {
                                    do {
                                        System.out.println("Ingrese un NUMERO valido: ");
                                        mov = scs.nextLine();
                                    } while (!checknum(mov));
                                }
                                if (P2.getAtaques()[Integer.parseInt(mov) - 1] instanceof Estado) {
                                    if (P2.getAtaques()[Integer.parseInt(mov) - 1].Movement(P2, P1) < 75 && P2.getAtaques()[Integer.parseInt(mov) - 1].Movement(P2, P1) > 1) {
                                        P1.setEstado(((Estado) P2.getAtaques()[Integer.parseInt(mov) - 1]).getProbest());
                                        System.out.println(P1.getEspecie() + " esta en el estado " + ((Estado) P2.getAtaques()[Integer.parseInt(mov) - 1]).getProbest());
                                    }
                                } else {
                                    P1.setHp(P1.getHp() - (P2.getAtaques()[Integer.parseInt(mov) - 1].Movement(P2, P1)));
                                }

                            } else {
                                System.out.println("Turno del Jugador 2: ");
                                for (int i = 0; i < P1.getAtaques().length; i++) {
                                    System.out.println((i + 1) + ".- " + P2.getAtaques()[i]);
                                }
                                System.out.println("Seleccione el movimiento que desea realizar: ");
                                String mov = scs.nextLine();
                                while (!checknum(mov)) {
                                    System.out.println("Ingrese un NUMERO, por favor.");
                                    mov = scs.nextLine();
                                }
                                while (Integer.parseInt(mov) < 1 || Integer.parseInt(mov) > P2.getAtaques().length) {
                                    do {
                                        System.out.println("Ingrese un NUMERO valido: ");
                                        mov = scs.nextLine();
                                    } while (!checknum(mov));
                                }
                                if (P2.getAtaques()[Integer.parseInt(mov) - 1] instanceof Estado) {
                                    if (P2.getAtaques()[Integer.parseInt(mov) - 1].Movement(P2, P1) < 75 && P2.getAtaques()[Integer.parseInt(mov) - 1].Movement(P2, P1) > 1) {
                                        P1.setEstado(((Estado) P2.getAtaques()[Integer.parseInt(mov) - 1]).getProbest());
                                        System.out.println(P1.getEspecie() + " esta en el estado " + ((Estado) P2.getAtaques()[Integer.parseInt(mov) - 1]).getProbest());
                                    }
                                } else {
                                    P1.setHp(P1.getHp() - (P2.getAtaques()[Integer.parseInt(mov) - 1].Movement(P2, P1)));
                                }

                                System.out.println("Turno del Jugador 1: ");
                                for (int i = 0; i < P1.getAtaques().length; i++) {
                                    System.out.println((i + 1) + ".- " + P1.getAtaques()[i]);
                                }
                                System.out.println("Seleccione el movimiento que desea realizar: ");
                                mov = scs.nextLine();
                                while (!checknum(mov)) {
                                    System.out.println("Ingrese un NUMERO, por favor.");
                                    mov = scs.nextLine();
                                }
                                while (Integer.parseInt(mov) < 1 || Integer.parseInt(mov) > P1.getAtaques().length) {
                                    do {
                                        System.out.println("Ingrese un NUMERO valido: ");
                                        mov = scs.nextLine();
                                    } while (!checknum(mov));
                                }
                                if (P1.getAtaques()[Integer.parseInt(mov) - 1] instanceof Estado) {
                                    if (P1.getAtaques()[Integer.parseInt(mov) - 1].Movement(P1, P2) < 75 && P1.getAtaques()[Integer.parseInt(mov) - 1].Movement(P1, P2) > 1) {
                                        P2.setEstado(((Estado) P1.getAtaques()[Integer.parseInt(mov) - 1]).getProbest());
                                        System.out.println(P2.getEspecie() + " esta en el estado " + ((Estado) P1.getAtaques()[Integer.parseInt(mov) - 1]).getProbest());
                                    }
                                } else {
                                    P2.setHp(P2.getHp() - (P1.getAtaques()[Integer.parseInt(mov) - 1].Movement(P1, P2)));
                                }

                            }

                        }

                    }
                    break;
                }
                case 3: {
                    if (entrenadores.size() < 1) {
                        System.out.println("Necesita agregar por lo menos 1 entrenador para ingresar a esta opcion.");
                    } 
                    else {
                        System.out.println("A que opcion desea ingresar?");
                        System.out.println("1. Capturar Pokemon");
                        System.out.println("2. Entrenar Pokemon");
                        String indione = scs.nextLine();
                        while (!checknum(indione) || Integer.parseInt(indione) < 1 || Integer.parseInt(indione) > 2) {
                            System.out.println("Ingrese un numero valido, por favor.");
                            indione = scs.nextLine();
                        }
                        if (Integer.parseInt(indione) == 1) {
                            if (Movements.size() > 3) {
                                System.out.println("Seleccione el entrenador");
                                for (Entrenador ent : entrenadores) {
                                    System.out.println((entrenadores.indexOf(ent) + 1) + "- " + ent);
                                }
                                String ind = scs.nextLine();
                                while (!checknum(ind)) {
                                    System.out.println("Ingrese un NUMERO, por favor.");
                                    ind = scs.nextLine();
                                }
                                if (Integer.parseInt(ind) > 0 && Integer.parseInt(ind) <= entrenadores.size()) {
                                    Pokemon a = addPokemon();
                                    int contpok = 0;
                                    for (int i = 0; i < entrenadores.get(Integer.parseInt(ind)-1).getEquipo().length; i++) {
                                            if (!(entrenadores.get(Integer.parseInt(ind)-1).getEquipo()[i] == null)){
                                                    contpok++;
                                            }
                                    }
                                    if (contpok < 6) {
                                        for (int i = 0; i < entrenadores.get(Integer.parseInt(ind)-1).getEquipo().length; i++) {
                                            if (!(entrenadores.get(Integer.parseInt(ind)-1).getEquipo()[i] == null)){
                                                    contpok++;
                                            }
                                        }
                                        entrenadores.get(Integer.parseInt(ind)-1).getEquipo()[contpok] = a;
                                        
                                        System.out.println("Su pokemon ha sido agregado al equipo!");
                                    } else {
                                        entrenadores.get(Integer.parseInt(ind) - 1).getCaja().add(a);
                                        System.out.println("Su pokemon ha sido transferido a la caja!");
                                    }
                                } else {
                                    System.out.println("Indice fuera de rango, regresara al menu.");
                                }
                            }
                        } else {
                            System.out.println("A continuacion entrenara un pokemon!");
                            System.out.println("Seleccione el entrenador");
                            for (Entrenador ent : entrenadores) {
                                System.out.println((entrenadores.indexOf(ent) + 1) + "- " + ent);
                            }
                            String ind = scs.nextLine();
                            while (!checknum(ind)) {
                                System.out.println("Ingrese un NUMERO, por favor.");
                                ind = scs.nextLine();
                            }
                            if (Integer.parseInt(ind) > 0 && Integer.parseInt(ind) <= entrenadores.size()) {
                                System.out.println("Seleccione la ubicacion del Pokemon que desea entrenar: ");
                                System.out.println("1. Esta en el equipo.");
                                System.out.println("2. Esta en la caja.");
                                String opx = scs.nextLine();
                                while (!checknum(opx) || Integer.parseInt(opx) < 1 || Integer.parseInt(opx) > 2) {
                                    System.out.println("Ingrese un numero valido, por favor.");
                                    opx = scs.nextLine();
                                }
                                if (Integer.parseInt(opx) == 1) {
                                    Pokemon[] eq = entrenadores.get(Integer.parseInt(ind) - 1).getEquipo();
                                    System.out.println("Escoga el pokemon:");
                                    for (int i = 0; i < eq.length; i++) {
                                        System.out.println((i + 1) + "- " + eq[i]);

                                    }
                                    String ind2 = scs.nextLine();
                                    while (!checknum(ind2) || Integer.parseInt(opx) < 1 || Integer.parseInt(opx) > eq.length) {
                                        System.out.println("Ingrese un numero valido, por favor.");
                                        ind2 = scs.nextLine();
                                    }
                                    int mult = ran.nextInt(3);
                                    int exp = 100 + ran.nextInt(4900);
                                    System.out.println(mult);
                                    System.out.println(exp);
                                    int expantes = eq[Integer.parseInt(ind2) - 1].getExpacum();
                                    int expnueva = mult * exp;
                                    eq[Integer.parseInt(ind2) - 1].setExpacum(expantes + expnueva);
                                    while (eq[Integer.parseInt(ind2) - 1].getExpacum() > eq[Integer.parseInt(ind2) - 1].getExpne()) {
                                        eq[Integer.parseInt(ind2) - 1].setNivel(eq[Integer.parseInt(ind2) - 1].getNivel() + 1);
                                        System.out.println("Su pokemon ha subido de nivel!");
                                        eq[Integer.parseInt(ind2) - 1].setExpacum(eq[Integer.parseInt(ind2) - 1].getExpacum() - eq[Integer.parseInt(ind2) - 1].getExpne());
                                    }
                                } else {

                                    ArrayList<Pokemon> eq = entrenadores.get(Integer.parseInt(ind)).getCaja();
                                    System.out.println("Escoga el pokemon:");
                                    for (Pokemon pokemon : eq) {
                                        System.out.println((eq.indexOf(pokemon) + 1) + "- " + pokemon);
                                    }
                                    String ind2 = scs.nextLine();
                                    while (!checknum(ind2) || Integer.parseInt(opx) < 1 || Integer.parseInt(opx) > eq.size()) {
                                        System.out.println("Ingrese un numero valido, por favor.");
                                        ind2 = scs.nextLine();
                                    }
                                    int mult = ran.nextInt(3);
                                    int exp = 100 + ran.nextInt(4900);
                                    int expantes = eq.get(Integer.parseInt(ind2) - 1).getExpacum();
                                    int expnueva = mult * exp;
                                    eq.get(Integer.parseInt(ind2) - 1).setExpacum(expantes + expnueva);
                                    while (eq.get(Integer.parseInt(ind2) - 1).getExpacum() > eq.get(Integer.parseInt(ind2) - 1).getExpne()) {
                                        eq.get(Integer.parseInt(ind2) - 1).setNivel(eq.get(Integer.parseInt(ind2) - 1).getNivel() + 1);
                                        System.out.println("Su pokemon ha subido de nivel!");
                                        eq.get(Integer.parseInt(ind2) - 1).setExpacum(eq.get(Integer.parseInt(ind2) - 1).getExpacum() - eq.get(Integer.parseInt(ind2) - 1).getExpne());
                                    }

                                }

                            }

                        }

                    }
                    break;
                }
                case 4: {

                    addMov();
                    break;
                }
                case 5: {
                    resp = false;
                    break;
                }
                default: {
                    System.out.println("Ingrese un indice valido");
                }

            }

        }
    }

    public static boolean checknum(String x) {
        boolean bueno = true;
        for (int i = 0; i < x.length(); i++) {
            char e = x.charAt(i);
            if (e < 48 || e > 57) {
                bueno = false;
                break;
            }

        }
        return bueno;

    }

    public static boolean checkdecimal(String x) {
        boolean bueno = true;
        int countpoint = 0;
        for (int i = 0; i < x.length(); i++) {
            char e = x.charAt(i);
            if ((e < 48 || e > 57) && e != 46) {
                bueno = false;
                break;
            }
            if (e == 46) {
                countpoint++;
            }
        }

        if (countpoint > 1) {
            bueno = false;
        }
        return bueno;

    }

    public static void addMov() {
        System.out.println("Ingrese el nombre del Movimiento: ");
        String nombre = scs.nextLine();
        System.out.println("Ingrese una descripcion del Movimiento: ");
        String desc = scs.nextLine();
        System.out.println("""
		  	      Ingrese el tipo del Movimiento 
			      1.- Especial
			      2.- Fisico
			      3.- Estado""");
        String tip = scs.nextLine();
        while (!checknum(tip)) {
            System.out.println("Ingrese un NUMERO valido: ");
            tip = scs.nextLine();
        }
        while (Integer.parseInt(tip) < 1) {
            do {
                System.out.println("Ingrese un NUMERO valido: ");
                tip = scs.nextLine();
            } while (!checknum(tip));
        }
        if (Integer.parseInt(tip) == 1) {
            System.out.println("Ingrese el poder del ataque: ");
            String power = scs.nextLine();
            while (!checknum(power)) {
                System.out.println("Ingrese un NUMERO valido: ");
                power = scs.nextLine();
            }
            while (Integer.parseInt(power) < 1) {
                do {
                    System.out.println("Ingrese un NUMERO valido: ");
                    power = scs.nextLine();
                } while (!checknum(power));
            }
            System.out.println("Ingrese la presicion del ataque: ");
            String pres = scs.nextLine();
            while (!checknum(pres)) {
                System.out.println("Ingrese un NUMERO valido: ");
                pres = scs.nextLine();
            }
            while (Integer.parseInt(pres) < 1) {
                do {
                    System.out.println("Ingrese un NUMERO valido: ");
                    pres = scs.nextLine();
                } while (!checknum(pres));
            }
            Movements.add(new Especial(Integer.parseInt(power), Integer.parseInt(pres), nombre, desc, "Especial"));
        } else if (Integer.parseInt(tip) == 2) {
            System.out.println("Ingrese el poder del ataque: ");
            String power = scs.nextLine();
            while (!checknum(power)) {
                System.out.println("Ingrese un NUMERO valido: ");
                power = scs.nextLine();
            }
            while (Integer.parseInt(power) < 1) {
                do {
                    System.out.println("Ingrese un NUMERO valido: ");
                    power = scs.nextLine();
                } while (!checknum(power));
            }
            System.out.println("Ingrese la presicion del ataque: ");
            String pres = scs.nextLine();
            while (!checknum(pres)) {
                System.out.println("Ingrese un NUMERO valido: ");
                pres = scs.nextLine();
            }
            while (Integer.parseInt(pres) < 1) {
                do {
                    System.out.println("Ingrese un NUMERO valido: ");
                    pres = scs.nextLine();
                } while (!checknum(pres));
            }
            Movements.add(new Especial(Integer.parseInt(power), Integer.parseInt(pres), nombre, desc, "Fisico"));
        } else if (Integer.parseInt(tip) == 3) {
            System.out.println("""
		  	      Ingrese el estado que causa el movimiento:
			      1.- Dormir
			      2.- Envenenar
			      3.- Paralizar
			      4.- Quemar""");
            String est = scs.nextLine();
            while (!checknum(est)) {
                System.out.println("Ingrese un NUMERO valido: ");
                est = scs.nextLine();
            }
            while (Integer.parseInt(est) < 1 || Integer.parseInt(est) > 4) {
                do {
                    System.out.println("Ingrese un NUMERO valido: ");
                    est = scs.nextLine();
                } while (!checknum(est));
            }
            switch (Integer.parseInt(est)) {
                case 1: {
                    Movements.add(new Estado("Dormir", nombre, desc, "Estado"));
                }
                break;
                case 2: {
                    Movements.add(new Estado("Envenenar", nombre, desc, "Estado"));
                }
                break;
                case 3: {
                    Movements.add(new Estado("Paralizar", nombre, desc, "Estado"));
                }
                break;
                case 4: {
                    Movements.add(new Estado("Quemar", nombre, desc, "Estado"));
                }
                break;

            }
        }

    }

    public static void addTrainer() {
        String nombre, edad, dinero;
        System.out.println("A continuacion agregara un entrenador. Favor ingrese los siguientes datos:");
        System.out.println("Ingrese nombre:");
        nombre = scs.nextLine();
        System.out.println("Ingrese edad: ");
        edad = scs.nextLine();
        while (!checknum(edad)) {
            System.out.println("Ingrese un NUMERO valido, por favor.");
            edad = scs.nextLine();
        }
        System.out.println("Ingrese el dinero en su cuenta: ");
        dinero = scs.nextLine();
        while (!checkdecimal(dinero)) {
            System.out.println("Ingrese un NUMERO valido, por favor.");
            dinero = scs.nextLine();
        }

        Entrenador x = new Entrenador(nombre, Integer.parseInt(edad), Double.parseDouble(dinero));
        entrenadores.add(x);
        System.out.println("El entrenador ha sido agregado exitosamente!");
    }

    public static Pokemon addPokemon() {
        System.out.println("Capturo un Pokemon! Ingrese los siguientes datos:");
        System.out.println("Ingrese la especie del pokemon: ");
        String nombre = scs.nextLine();
        System.out.println("Ingrese el nivel de pokemon: ");
        String level = scs.nextLine();
        while (!checknum(level)) {
            System.out.println("Ingrese un NUMERO valido: ");
            level = scs.nextLine();
        }
        while (Integer.parseInt(level) < 1) {
            do {
                System.out.println("Ingrese un NUMERO valido: ");
                level = scs.nextLine();
            } while (!checknum(level));
        }
        System.out.println("Ingrese la cantidad de puntos que necesita el pokemon para subir de nivel: ");
        String ex = scs.nextLine();
        while (!checknum(ex)) {
            System.out.println("Ingrese un NUMERO valido: ");
            ex = scs.nextLine();
        }
        while (Integer.parseInt(ex) < 1) {
            do {
                System.out.println("Ingrese un NUMERO valido: ");
                ex = scs.nextLine();
            } while (!checknum(ex));
        }
        int cont = 0;
        String mov = "";
        ArrayList<Integer> muv=new ArrayList<>();
        Movimiento[] movi = new Movimiento[4];
        while (cont < 4) {
            printMovimientos();
            System.out.println("Movimiento de el slot#" + (cont + 1));
            System.out.println("Ingrese el indice del movimiento que desea agregarle al pokemon: ");
            mov = scs.nextLine();
            while (!checknum(mov)) {
                System.out.println("Ingrese un indice valido: ");
                mov = scs.nextLine();
            }
            while (Integer.parseInt(mov) < 1 || Integer.parseInt(mov) > Movements.size()||muv.contains(Integer.parseInt(mov))) {
                do {
                    System.out.println("Ingrese un NUMERO valido: ");
                    mov = scs.nextLine();
                } while (!checknum(mov));
            }
            movi[cont] = Movements.get(Integer.parseInt(mov) - 1);
            muv.add(Integer.parseInt(mov));
            cont++;
        }
        System.out.println("Ingrese la cantidad de vida del pokemon: ");
        String Hp = scs.nextLine();
        while (!checknum(Hp)) {
            System.out.println("Ingrese un Numero valido: ");
            Hp = scs.nextLine();
        }
        while (Integer.parseInt(Hp) < 1) {
            do {
                System.out.println("Ingrese un NUMERO valido: ");
                Hp = scs.nextLine();
            } while (!checknum(Hp));
        }

        System.out.println("Ingrese la cantidad de ataque del pokemon: ");
        String Atk = scs.nextLine();
        while (!checknum(Atk)) {
            System.out.println("Ingrese un Numero valido: ");
            Atk = scs.nextLine();
        }
        while (Integer.parseInt(Atk) < 1) {
            do {
                System.out.println("Ingrese un NUMERO valido: ");
                Atk = scs.nextLine();
            } while (!checknum(Atk));
        }

        System.out.println("Ingrese la cantidad de Defensa del pokemon: ");
        String Def = scs.nextLine();
        while (!checknum(Def)) {
            System.out.println("Ingrese un Numero valido: ");
            Def = scs.nextLine();
        }
        while (Integer.parseInt(Def) < 1) {
            do {
                System.out.println("Ingrese un NUMERO valido: ");
                Def = scs.nextLine();
            } while (!checknum(Def));
        }

        System.out.println("Ingrese la cantidad de ataque especial del pokemon: ");
        String Sp = scs.nextLine();
        while (!checknum(Sp)) {
            System.out.println("Ingrese un Numero valido: ");
            Sp = scs.nextLine();
        }
        while (Integer.parseInt(Sp) < 1) {
            do {
                System.out.println("Ingrese un NUMERO valido: ");
                Sp = scs.nextLine();
            } while (!checknum(Sp));
        }
        System.out.println("Ingrese la cantidad de velocidad del pokemon: ");
        String vel = scs.nextLine();
        while (!checknum(vel)) {
            System.out.println("Ingrese un Numero valido: ");
            vel = scs.nextLine();
        }
        while (Integer.parseInt(vel) < 1) {
            do {
                System.out.println("Ingrese un NUMERO valido: ");
                vel = scs.nextLine();
            } while (!checknum(vel));
        }

        Pokemon x = new Pokemon(nombre, Integer.parseInt(level), "Neutral", 0, Integer.parseInt(ex), Integer.parseInt(Hp), Integer.parseInt(Atk), Integer.parseInt(Def), Integer.parseInt(Sp), Integer.parseInt(vel));
        x.setAtaques(movi);
        return x;

    }

    public static void printMovimientos() {
        for (Movimiento Movement : Movements) {
            System.out.println((Movements.indexOf(Movement) + 1) + ".- " + Movement);
        }
    }

}
