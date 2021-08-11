import java.util.Scanner;
public class WarmUpJumpingOnTheClouds {
    public static int jumpingOnTheClouds(int[] arr) {
        int res = 0;
        for (int position = arr.length - 1; position > 0; ) {
          
            if (position - 2 >= 0 && arr[position-2] == 0) {
                position = position -2;
                res ++;
            }
            else{
                position=position-1;
                res ++;
            }
            
        }
        return res;
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        System.out.print(jumpingOnTheClouds(arr));
    }
}