import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArraysLeftRotation {
    public static int[] leftRotationstatic(int d, int n,int[] arr) {
        int arrB[] = new int[n];
        for(int i=0 ; i<n ; i++){
            if((i-d)<0){
                arrB[n+i-d]=arr[i];
            }
            else{
                arrB[i-d]=arr[i];
            }
        }    
        return arrB;
}
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int d = input.nextInt();
        
        int arr[] = new int[n];
  

        for (int i=0 ; i<n; i++) {
            arr[i] = input.nextInt();
        }
        
        int[] arrC =  leftRotationstatic(d,n,arr);  
        
        for(int i=0;i<n;i++){
            System.out.print(arrC[i]+" ");
        }
        System.out.println();
    }
}