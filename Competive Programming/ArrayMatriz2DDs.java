
import java.util.Scanner;

public class ArrayMatriz2DDs {
    
    public static int suma(int[][] arr){
        int ultraSum = -999999999;
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++ ){
                int sum = 0;
                int a = arr[i][j];
                int b = arr[i][j+1];
                int c = arr[i][j+2];
                
                int d = arr[i+1][j+1];
                
                int e = arr[i+2][j];
                int f = arr[i+2][j+1];
                int g = arr[i+2][j+2];
                sum = a+b+c+d+e+f+g;
                if (sum>ultraSum){
                    ultraSum = sum;
                    
                }
                
            
            }
        }
        return ultraSum;
    }
        
    


    public static void main(String args[]) {
        Scanner input = new Scanner (System.in);
        int arr [][] = new int [6][6];
     
        for (int i=0; i<6; i++){
            for (int j=0; j<6; j++ ){
                arr[i][j] = input.nextInt();
            }
        }
        
        System.out.println(suma(arr));
        
    }
}
