package Buscaminas;

public class Logica {
    public char[][] minas;
    public char[][] prog;
    public boolean[][] visited;

    /**
     * Constructor de la clase Logica, inicializa las tablas de minas, progreso y visited. 
     * El array minas es la solucion del tablero, el array prog es el progreso del tablero y el array visited es para saber si una casilla ya fue visitada.
     * Para la creacion de las tablas se necesita el numero de filas y columnas del tablero que son los parametros cy y cx.
     */
    public Logica(int cy, int cx) {

        //Creacion de tablas y almacenamiento de los datos
        this.minas= new char[cy][cx];//Solucion de la tabla
        this.prog= new char[cy][cx];//Progreso de la tabla
        this.visited = new boolean[cy][cx];//Casillas visitadas
        
    }

    /**
     * Metodo que descubre cuantas minas hay cerca de la celda seleccionada y la sobre escribe con este numero. 
     * Este metodo devuelve un string que es "GAME OVER" si la celda seleccionada es una mina, de lo contrario devuelve un string vacio.
     */
    public String procesarCelda(char[][] minas, char[][] prog,boolean[][] visited, int y, int x) {

        if (visited[y][x]) {
            return "";
        }

        visited[y][x] = true;

        char c = minas[y][x];
        int mc = 0;    //Minas cercanas

        if (c == '*'){
            prog[y][x] = minas[y][x];
            return("GAME OVER");
        }

        if (c == '-') {
            if (y > 0) {
                if (minas[y - 1][x] == '*') { // arriba
                    mc++;
                }
                if (x > 0) {
                    if (minas[y - 1][x - 1] == '*') { // arriba izquierda
                        mc++;
                    }
                }
                if (x < minas[y - 1].length - 1) {
                    if (minas[y - 1][x + 1] == '*') { // arriba derecha
                        mc++;
                    }
                }
            }
            if (x > 0) {
                if (minas[y][x - 1] == '*') { // izquierda
                    mc++;
                }
            }
            if (x < minas[y].length - 1) {
                if (minas[y][x + 1] == '*') { // derecha
                    mc++;
                }
            }

            if (y < minas.length - 1) {
                if (x > 0) {
                    if (minas[y + 1][x - 1] == '*') { // abajo izquierda
                        mc++;
                    }
                }
                if (minas[y + 1][x] == '*') { // abajo
                    mc++;
                }
                if (x < minas[y + 1].length - 1) {
                    if (minas[y + 1][x + 1] == '*') { // abajo derecha
                        mc++;
                    }
                }
            }
        }

        if (mc == 0) {
            if (y < minas.length - 1) {
                if (x < minas[y + 1].length - 1) {
                    if (prog[y + 1][x + 1] == 'X') {
                        procesarCelda(minas, prog, visited, y + 1, x + 1);
                    }
                }
                if (prog[y + 1][x] == 'X') {
                    procesarCelda(minas, prog, visited, y + 1, x);
                }
                if (x > 0) {
                    if (prog[y + 1][x - 1] == 'X') {
                        procesarCelda(minas, prog, visited, y + 1, x - 1);
                    }
                }
            }
            if (x < minas[y].length - 1) {
                if (prog[y][x + 1] == 'X') {
                    procesarCelda(minas, prog, visited, y, x + 1);
                }
            }
            if (x > 0) {
                if (prog[y][x - 1] == 'X') {
                    procesarCelda(minas, prog, visited, y, x - 1);
                }
            }
            if (y > 0) {
                if (x < minas[y - 1].length - 1) {
                    if (prog[y - 1][x + 1] == 'X') {
                        procesarCelda(minas, prog, visited, y - 1, x + 1);
                    }
                }
                if (x > 0) {
                    if (prog[y - 1][x - 1] == 'X') {
                        procesarCelda(minas, prog, visited, y - 1, x - 1);
                    }
                }
                if (prog[y - 1][x] == 'X') {
                    procesarCelda(minas, prog, visited, y - 1, x);
                }
            }
        }

        this.prog[y][x] = mc > 0 ? (char) (mc + '0') : minas[y][x];
        return "";
    }
}