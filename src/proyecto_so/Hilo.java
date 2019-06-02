package proyecto_so;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maru
 */
public class Hilo extends Thread{
    static int cont=1;
    private final int i;
    private final int j;
    float suma = 0;
    private Matriz A;
    private Matriz B;
    private Matriz C;
    private final Lock lock;
    
    public Hilo(int i, int j, Matriz A, Matriz B, Matriz C, Lock lo) {
        this.i = i;
        this.j = j;
        this.A = A;
        this.B = B;
        this.C = C;
        this.lock=lo;
    }
    
    public void run() {
        try {   
                lock.Lock(getName());
                System.out.println("\n Operacion de Multiplicacion para el proceso " + cont + " por el "+ getName() + ", elementos encontrados en la matriz bloqueado "); 
                imprimir();
                for (int k = 0; k < B.getNroColumnas(); k++) {
                    suma += A.getValor(i, k) * B.getValor(k, j);
                        C.setValor(i, j, suma);
                }
                System.out.println("\n\n Matriz tras multiplicacion por el " + getName());
                imprimir();
                System.out.println();
                cont++;
                lock.unlock();
                sleep(1);
            } catch (InterruptedException ex) {
        }
    }   

    
    private void imprimir() { 
        for(int k=0;k<C.getNroFilas();k++){
            System.out.print("\n");
            for(int m=0;m<C.getNroColumnas();m++){
            System.out.print(C.getValor(k,m)+" ");
            }
        }
    }
}
