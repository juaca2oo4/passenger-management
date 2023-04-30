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
            System.out.println("3. Mostrar orden de salida");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            int option = lector.nextInt();


            if (option == 1) {
                objMain.Register();

            } else if (option == 0) {
                break;
            } else if (option == 2) {
                objMain.printIngress();
            } else if (option == 3) {
                objMain.out();
            }else {
                System.out.println("Opción inválida, por favor ingrese 1 o 2.");
            }
        }
    }
    // C:\\Users\\shern\\OneDrive\\Documentos\\discretas2\\TI1final\\passenger-management\\src\\prueba.txt
    // C:\\Users\\shern\\OneDrive\\Documentos\\discretas2\\TI1final\\passenger-management\\src\\orden_de_llegada.txt
    public void readTxt() {
        boolean x = true;
        while (x) {
            System.out.println("ingrese la direccion de un archivo txt donde cargaremos y guardaremos los datos.");
            String direction = lector.next();
            System.out.println("ingrese el numero de pasajeros.");
            int amount = lector.nextInt();
            controller.LoadPassenger(direction, amount);
            if (!controller.HashEmpty()) {
                break;
            } else {
                System.out.println("debes ingresar una lista con por lo menos un pasajero");
            }

        }

    }

    public void Register() {
        boolean x = true;
        while (x) {
            System.out.println("ingrese lista de llegada ");
            String txt = lector.next();
            controller.ArriveP(txt);
            if (controller.IngressEmpty()) {
                System.out.println("debes ingresar por lo menos un pasajero");
            } else {
                x = false;
            }
        }

    }



    public void printIngress() {
        controller.showOrderIngress();
    }

    public void out(){
        controller.Out();
    }



    

}