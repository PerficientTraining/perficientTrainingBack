
import java.util.Scanner;
public class WarmUpCountingValleys {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int nNumberSteps = input.nextInt();
        String steps = input.nextLine();
        int currElevation = 0;
        int valleyCount = 0;
        int state = 0;

        for (int i = 0; i < nNumberSteps; i++) {
            String s = steps.substring(i, i+1);
            if (s.compareTo("U") == 0) {
                currElevation++;
            }
            else {
                currElevation--;
            }
            
            if (state >= 0 && currElevation < 0) {
                valleyCount++;
            }
            state = currElevation;
        }
        System.out.println(valleyCount);
        input.close();
    }
}