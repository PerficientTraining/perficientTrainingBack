import java.util.Hashtable;
//import java.util.Scanner;
//import java.util.function.BiPredicate;


public class HashTablesRansonNote {
    public static String ransonNote(Hashtable<String, Integer> magazine, Hashtable<String, Integer> note){
        int count = 0;
        for (int i=0; i<note.size(); i++){
            
            String a = magazine.get(i).toString();
            System.out.println(a);
            }
        
            
        return "no";
    }
    
    public static void main(String args[]) {
        /**
        Scanner input = new Scanner (System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        
        Hashtable<String, Integer> magazine = new Hashtable<>(a);
        Hashtable<String,Integer> note = new Hashtable<>(b);
        
        for (int i=0; i<a; i++ ){
            magazine.put(input.next(), i);
        }
        
        for (int j=0; j<b; j++){
            magazine.put(input.next(), j);
        }
        */
        int a = 6;
        int b = 5;
        Hashtable<String, Integer> magazine = new Hashtable<>(a);
        Hashtable<String,Integer> note = new Hashtable<>(b);
        magazine.put("two", 1);
        magazine.put("times", 2);
        magazine.put("three", 3);
        magazine.put("is", 4);
        magazine.put("not", 5);
        magazine.put("four", 6);
        
        note.put("two", 1);
        note.put("times", 2);
        note.put("two", 3);
        note.put("four", 3);
        
        System.out.println(magazine);
        System.out.println(note);
        System.out.println(ransonNote(magazine, note));
        
    }
}
