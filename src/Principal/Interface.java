package Principal;

import java.util.Scanner;

import Buscaminas.*;

public class Interface {
    public static void main(String[] args) {
        
        Interface interfaz = new Interface();
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese las dimensiones del tablero");
        int cy = sc.nextInt();
        int cx = sc.nextInt();

        Logica logica = new Logica(cy, cx);

        System.out.println("Ingrese el tablero");
        interfaz.lecturaArray(logica, cy, cx);

        //Lectura de casos de prueba
        System.out.println("Ingrese el numero de casos de prueba");
        int repe = sc.nextInt();

        //repeticiones de casos de prueba
        for (int i = 0;i < repe;i++){

            System.out.print("y = ");
            int y = sc.nextInt()-1;//coordenada y

            System.out.print("x = ");
            int x = sc.nextInt()-1;//coordenada x
            
            if(logica.procesarCelda(logica.minas,logica.prog,logica.visited,y,x) == "GAME OVER"){
                System.out.print("GAME OVER");
            }
        }
        
        interfaz.escrituraArray(logica, cy, cx);
    }

    public void lecturaArray(Logica logica,int cy, int cx) {
        Scanner sc = new Scanner(System.in);
        // Lectura tablero
        for (int i = 0; i < cy; i++) {
            String row = sc.next();
            for (int j = 0; j < cx; j++) {
                logica.minas[i][j] = row.charAt(j);
                logica.prog[i][j] = 'X';
            }
        }
    }

    public void escrituraArray(Logica logica, int cy, int cx) {
        System.out.println();
        for (int i = 0; i < cy; i++) {
            for (int j = 0; j < cx; j++) {
                System.out.print(logica.prog[i][j]);
            }
            System.out.println();
        } 
    }

}
