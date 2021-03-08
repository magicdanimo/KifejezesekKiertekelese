package szamologep;

import java.util.ArrayList;
import java.util.Scanner;

public class Szamologep {


    public static void main(String[] args) {
        System.out.println("Hello there");
       
        Scanner sc = new Scanner(System.in);
        System.out.print("Adj meg egy matematikai kifejezést: ");
        String matematikai = sc.nextLine();
        
        lengyelFormAlakit(matematikai);
    }

    private static ArrayList lengyelFormAlakit(String matematikai) {
        ArrayList<String> lengyelform = new ArrayList<>();
        ArrayList<String> verem = new ArrayList<>();
        
        int N = matematikai.length();
        for (int i = 0; i < N; i++) {
            char akt = matematikai.charAt(i);
            if (akt == '(') {
                verem.add(akt+"");
            }
            //48-57
            if ((int)akt <= 57 && (int)akt >= 48) {
                lengyelform.add(akt+"");
            }
            if (akt == '*' || akt == '/' || akt == '-' || akt == '+') {
                if (verem.isEmpty()) {
                    verem.add(akt+"");
                } else {
                    //todo
                }
            }
            if (akt == ')') {
                verem.add(akt+"");
                //todo
            }
            
        }
        while(!verem.isEmpty()) {
            //todo
        }
        return lengyelform;
    }
    
}
