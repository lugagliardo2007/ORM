package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Alimento> despensa = Control.obtenerAlimentos();
        if (despensa.isEmpty()) {
            Control.guardar(new Alimento("Ensalada", 20, 10, 5, 15));
            Control.guardar(new Alimento("Matambre", 30, 15, 15, 10));
            Control.guardar(new Alimento("Mantecol", 5, 20, 5, -5));
            Control.guardar(new Alimento("Chipa", 15, 20, 5, -10));
            Control.guardar(new Alimento("Manzana", 10, 5, 10, 10));
            despensa = Control.obtenerAlimentos();
        }

        Pou pou = Control.buscarPou(1);
        if (pou == null) {
            System.out.println("No se encontro ningun Pou");
            System.out.print("Escribi el nombre para tu nuevo pou: ");
            String nombrePou = scanner.nextLine();
            pou = new Pou(nombrePou);
            Control.guardar(pou);
        }

        int opcion;
        do {
            System.out.println(" Estado de: " + pou.getNombre().toUpperCase());
            System.out.println("Hambre: " + pou.getHambre() + "/100");
            System.out.println("Felicidad: " + pou.getFelicidad() + "/100");
            System.out.println("Suciedad: " + pou.getSuciedad() + "/100");
            System.out.println("Energia: " + pou.getEnergia() + "/100");

            System.out.println("1. Dar de comer");
            System.out.println("2. Bañar");
            System.out.println("3. Jugar");
            System.out.println("4. Dormir");
            System.out.println("5. Acariciar");
            System.out.println("6. Salir");
            opcion = scanner.nextInt();


            if (opcion >= 1 && opcion <= 5) {
                if (Math.random() < 0.20) {
                    System.out.println("\nmm ña " + pou.getNombre() + " te odia ahre");
                    pou.setFelicidad(pou.getFelicidad() - 10);
                    pou.ajustarLimites();
                    Control.guardar(pou);
                    continue;
                }
            }

            switch (opcion) {
                case 1:
                    System.out.println("Menu");
                    for (int i = 0; i < despensa.size(); i++) {
                        System.out.println((i + 1) + ". " + despensa.get(i).getNombre());
                    }
                    System.out.print("Elegi que queres darle: ");
                    int elegida = scanner.nextInt();

                    if (elegida > 0 && elegida <= despensa.size()) {
                        Alimento al = despensa.get(elegida - 1);
                        pou.setHambre(pou.getHambre() + al.getAportaHambre());
                        pou.setFelicidad(pou.getFelicidad() + al.getAportaFelicidad());
                        pou.setSuciedad(pou.getSuciedad() + al.getAportaSuciedad());
                        pou.setEnergia(pou.getEnergia() + al.getAportaEnergia());
                        System.out.println("Le diste " + al.getNombre() + " a " + pou.getNombre());
                    } else {
                        System.out.println("Emm no esta en el menu eso...");
                    }
                    break;

                case 2:
                    pou.setSuciedad(pou.getSuciedad() - 35);
                    pou.setFelicidad(pou.getFelicidad() + 5);
                    System.out.println("Bañaste a " + pou.getNombre());
                    break;

                case 3:
                    pou.setHambre(pou.getHambre() - 20);
                    pou.setEnergia(pou.getEnergia() - 20);
                    pou.setSuciedad(pou.getSuciedad() + 20);
                    pou.setFelicidad(pou.getFelicidad() + 15);
                    System.out.println("Jugaste a la pelota con " + pou.getNombre());
                    break;

                case 4:
                    pou.setEnergia(pou.getEnergia() + 40);
                    pou.setHambre(pou.getHambre() - 10);
                    System.out.println(pou.getNombre() + " se durmio alta siesta.");
                    break;

                case 5:
                    pou.setFelicidad(pou.getFelicidad() + 15);
                    System.out.println("Le hiciste mimitos a " + pou.getNombre());
                    break;

                case 6:
                    System.out.println("Guardando partida");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }


            pou.ajustarLimites();
            Control.guardar(pou);

        } while (opcion != 6);

        Control.cerrarFactory();
        scanner.close();
    }
}