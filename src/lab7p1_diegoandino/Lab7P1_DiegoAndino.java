
package lab7p1_diegoandino;

import java.util.Scanner;
import java.util.Random;

public class Lab7P1_DiegoAndino {
static Scanner leer = new Scanner(System.in);
    static Random aleatorio = new Random();
    public static void main(String[] args) {
       int opcion = menu();
       
        do{
        switch(opcion){
            case 1:
                System.out.println("PORTRAIT...");
                System.out.println("Ingrese M: ");
                int M1 = leer.nextInt();
                
                System.out.println("Ingrese N: ");
                int N1 = leer.nextInt();
                
                int[][] RAN1 =lector(M1,N1);
                System.out.print(imprimir(RAN1));
                System.out.print("El número generado es:" + imprimir(ROTATE(RAN1,M1,N1)));
                
                break;
//------------------------------------------------------------------------------
            case 2:
                
                System.out.println("NUMERO MAGICO...");
                System.out.println("Ingrese M: ");
                int M2 = leer.nextInt();
                
                System.out.println("Ingrese N: ");
                int N2 = leer.nextInt();
                
                int[][] RAN2 =lector(M2,N2);
                System.out.print(imprimir(RAN2));
                System.out.print("El número generado es:" + MAGICO(RAN2));
                
                
                break;
//------------------------------------------------------------------------------
            case 3:
                System.out.println("SUBSECUEBCIA...");
                System.out.println("Ingrese Cadena 1: ");
                String cad1 = leer.next();
                String cadline1 = GUION(cad1); 
                System.out.println("Ingrese Cadena 2: ");
                String cad2 = leer.next();
                String cadline2 = GUION(cad2);
                System.out.print(SUB(cadline1, cadline2));
                break;
//------------------------------------------------------------------------------
        }
        opcion = menu();
        }while(opcion != 4);
         
        }
    public static int menu(){
        int opcion;
        System.out.println("MENU");
        System.out.println("1<- Portrait");
        System.out.println("2<- Número mágico");
        System.out.println("3<- Subsecuencia");
        System.out.println("4<- Salida");
        System.out.println("Ingrese su opcion:");

        opcion = leer.nextInt();
         return opcion;
    }
    public static int[][] lector(int fil, int col) {
        int temp[][] = new int[fil][col];
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                temp[i][j] = 0 + aleatorio.nextInt(9);
            }
        }

        return temp;
    }
    public static String imprimir(int[][] mat) {
        String str = "";
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                str += "[" + mat[i][j] + "]" + " ";
            }
            str += "\n";
        }

        return str;
    }
    public static int MAGICO(int[][]mat){
       int opcion1 = 0;
       int opcion2 = 1;
       int respuesta = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (i == 0 || j == 0 || i == mat.length - 1 || j == mat.length - 1) {
                    opcion1 += mat[i][j];
                }
                else{
                    opcion2 *= mat[i][j];
                }
                
            }
        }
        System.out.println("OP. 1: " + opcion1);
        System.out.println("OP. 2: " + opcion2);
        respuesta = opcion1 + opcion2;
        return respuesta;
   }
    public static int [][] ROTATE(int[][]mat, int M, int N){
        int [][] portmat = new int [M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                portmat[j][i] = mat[mat.length-i-1][j]; 
            }   
        }
                return portmat;    
        }
    public static String GUION(String cad){
        String newcad = "-" + cad;
        
        return newcad;
    }
    public static int SUB (String cad1, String cad2){
        int fila = cad1.length();
        int columna = cad2.length();
        
        int [][]mat = new int[fila][columna];
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                char char1 = cad1.charAt(i);
                char char2 = cad2.charAt(j);
                
                if(char1 == '-' || char2 == '-'){
                    mat[i][j]= 0;
                }
                else if(cad1.charAt(i) == cad2.charAt(j)){
                    mat[i][j] += mat[i-1][j-1]+1;
                }
                else{
                    mat[i][j] = Math.max(mat[i][j-1],mat[i-1][j]);
                    
                }

                }
                
            }
        System.out.println(imprimir(mat));
        return mat[mat.length-1][mat[0].length-1];
    } 
}
        
    
    
    
            

