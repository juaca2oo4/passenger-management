package ui;

import model.Controller;

import java.util.Scanner;

public class Main {
    private Controller controller;
    public static Scanner lector = new Scanner(System.in);

    public Main() {
        controller = new Controller();
    }

    public static void main(String[] args) {
        Main objMain = new Main();
    

        objMain.readTxt();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Ingresar llegada");
            System.out.println("2. Mostrar orden de ingreso");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            int option = lector.nextInt();

            if (option == 1) {
                objMain.Register();

            } else if (option == 0) {
                break;
            } else if (option == 2) {
                objMain.printIngress();
                break;
            } else {
                System.out.println("Opción inválida, por favor ingrese 1 o 2.");
            }
        }
    }

    public void readTxt(){
        System.out.println("ingrese la direccion de un archivo txt donde cargaremos y guardaremos los datos.");
        String direction = lector.next();
        System.out.println("ingrese el numero de pasajeros.");
        int amount = lector.nextInt();
        controller.LoadPassenger(direction, amount);

    }

    public void Register(){
        System.out.println("ingrese lista de llegada ");
        String txt= lector.next();
        controller.ArriveP(txt);
    }



    

}