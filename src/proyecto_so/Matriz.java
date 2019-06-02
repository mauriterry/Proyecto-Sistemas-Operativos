package proyecto_so;

import java.util.Random;

public class Matriz {

    //ATRIBUTOS
    private float M[][];
    private Integer nroFilas;
    private Integer nroColumnas;
    private float mult;

    //CONSTRUCTOR
    public Matriz() { /*constructor sin parametros*/
        /*para inicializar los valores*/
        M = new float[100][100];
    }

    public Matriz(Integer nroFilas, Integer nroColumnas) {/*constructor con parametros*/
        M = new float[nroFilas][nroColumnas];
        this.setNroFilas(nroFilas);
        this.setNroColumnas(nroColumnas);
        this.mult=0;
    }
    
    public void llenarMatriz() {
        for (int i = 0; i < nroFilas; i++) {
            for (int j = 0; j < nroColumnas; j++) {
                M[i][j] = (float) (Math.random() * 100);
            }
        }
    }

    //METODOS
	/*set es para asignar*/
    public void setValor(Integer fila, Integer columna, float x) {
        M[fila][columna] = x;
    }
    /*get es para retornar*/

    public synchronized float getValor(Integer fila, Integer columna) {
        return M[fila][columna];
    }

    public Integer getNroColumnas() {
        return nroColumnas;
    }

    public void setNroColumnas(Integer nroColumnas) {
        this.nroColumnas = nroColumnas;
    }

    public Integer getNroFilas() {
        return nroFilas;
    }

    public void setNroFilas(Integer nroFilas) {
        this.nroFilas = nroFilas;
    }
    
    public synchronized void sumaMulti(float mult) {
        this.mult = this.mult + mult;

    }
    
    public float getMulti() {
        return mult;
    }
}