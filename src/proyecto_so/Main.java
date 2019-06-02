package proyecto_so;

import javax.swing.JOptionPane;


/**
 *
 * @author Rafa G
 */
public class Main {
    
    static Lock l = new Lock();
    Matriz matrizA = new Matriz();
    Matriz matrizB = new Matriz(); 
    
    public void Datos(int fil_A,int col_A,int fil_B,int col_B){
        
        matrizA.setNroColumnas(col_A);
        matrizA.setNroFilas(fil_A);
        matrizA.llenarMatriz();
        matrizB.setNroColumnas(col_B);
        matrizB.setNroFilas(fil_B);
        matrizB.llenarMatriz();
        
        System.out.println("Elementos de la Matrix A:\n");
        for (int i = 0; i<matrizA.getNroFilas(); i++){
            for (int j=0; j<matrizA.getNroColumnas(); j++){
                System.out.println("["+i+","+j+"] = "+matrizA.getValor(i, j));
            }
        }
        
        System.out.println("Elementos de la Matrix B:\n");
        for (int i = 0; i<matrizB.getNroFilas(); i++){
            for (int j=0; j<matrizB.getNroColumnas(); j++){
                System.out.println("["+i+","+j+"] = "+matrizB.getValor(i, j));
            }
        }
    }
    
    public void Hilo(){
        int fil_m1 = matrizA.getNroFilas();
        int col_m1 = matrizA.getNroColumnas();
        int fil_m2 = matrizB.getNroFilas();
        int col_m2 = matrizB.getNroColumnas();
	Matriz resultado = new Matriz(fil_m1, col_m2);
        int ax=1;
        Hilo [] Hilos = new Hilo[5];
        if(col_m1!=fil_m2){
            System.out.println("\n No se pueden multiplicar las matrices");    
        }else{
            //creates 4 Worker threads. Each thread Calculates a Matrix Value and sets it to C matrix        
            for (int i = 0; i<resultado.getNroFilas(); i++){
                for (int j=0; j<resultado.getNroColumnas(); j++){
                    Hilos[ax] = new Hilo(i,j,matrizA,matrizB,resultado,l);
                    Hilos[ax].start();
                    try {
                        Hilos[ax].setName("Hilo "+ ax);
                        Hilos[ax].join();
                        ax ++;
                        if(ax==5){
                            ax=1;
                        }
                    } catch (InterruptedException ex) {
                    }
                }
            }
        } 
    }
    
    public static void main(String[] args) {
        
        int fil_A,col_A,fil_B,col_B;
        
        fil_A = Integer.parseInt(JOptionPane.showInputDialog("Digitar el tamaño de filas de la matriz A"));
        col_A = Integer.parseInt(JOptionPane.showInputDialog("Digitar el tamaño de las columnas de la matriz A"));
        fil_B = Integer.parseInt(JOptionPane.showInputDialog("Digitar el tamaño de filas de la matriz B"));
        col_B = Integer.parseInt(JOptionPane.showInputDialog("Digitar el tamaño de las columnas de la matriz B"));
        Main b = new Main();
        b.Datos(fil_A,col_A,fil_B,col_B);      
        b.Hilo();
    }        
}
