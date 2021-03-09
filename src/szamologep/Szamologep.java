package szamologep;

import java.util.ArrayList;
import java.util.Scanner;

public class Szamologep {

    public static void main(String[] args) {
        System.out.println("Hello there");
        ArrayList<String> segedverem = new ArrayList<>();
        ArrayList<String> lengyelForm = new ArrayList<>();
//        //2+6*(9-5) | 2695-*+ | Elvárt eredmény: 26
//        lengyelForm.add("2");
//        lengyelForm.add("6");
//        lengyelForm.add("9");
//        lengyelForm.add("5");
//        lengyelForm.add("-");
//        lengyelForm.add("*");
//        lengyelForm.add("+");
//        segedverem.clear();
//
//        for (int i = 0; i < lengyelForm.size(); i++) {
//
//        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Adj meg egy matematikai kifejezést: ");
        String matematikai = sc.nextLine();

        lengyelForm = lengyelFormAlakit(matematikai);
        
        for (String akt : lengyelForm) {
            System.out.print(akt);
        }
        System.out.println("");
    }

    private static ArrayList lengyelFormAlakit(String matematikai) {
        ArrayList<String> lengyelform = new ArrayList<>();
        ArrayList<String> verem = new ArrayList<>();

        int N = matematikai.length();
        for (int i = 0; i < N; i++) {
            char akt = matematikai.charAt(i);
            if (akt == '(') {
                verem.add(akt + "");
            }
            //48-57
            if ((int) akt <= 57 && (int) akt >= 48) {
                lengyelform.add(akt + "");
            }
            if (akt == '*' || akt == '/' || akt == '-' || akt == '+') {
                if (verem.isEmpty()) {
                    verem.add(akt + "");
                } else {
//                    String utolsoElem =
                    while (!verem.isEmpty() /*&& todo*/) {
                        String utolsoElem = verem.get(verem.size() - 1);
                        if (utolsoElem.equals("(")) {
                            verem.add(akt+"");
                            break;
//                            verem.remove(utolsoElem);
                        } 
                        else if(utolsoElem.equals("*") || utolsoElem.equals("/")) {
                            lengyelform.add(utolsoElem);
                            verem.remove(verem.size() - 1);
                        } 
                        else if ((utolsoElem.equals("+") || utolsoElem.equals("-")) && !(akt == '*' || akt == '/')) {
                            lengyelform.add(utolsoElem);
                            verem.remove(verem.size() - 1);
                            
                        }
                        System.out.println(utolsoElem);
                    }
//                    verem.add(akt + "");
                   
                }
            }
            if (akt == ')') {
//                verem.add(akt + "");
                String kivettElem = "";
                do {
                    if (verem.size() > 0) {
                        kivettElem = verem.get(verem.size() - 1);
                        if (!kivettElem.equals("(")) {
                            lengyelform.add(kivettElem);
                            verem.remove(verem.size() - 1);
                        }
                    }    
                    System.out.println(kivettElem);
                    System.out.println(verem.size());
                    
                } while (!kivettElem.equals("("));
                verem.remove(verem.size() - 1);
            }

        }
        while (!verem.isEmpty()) {
            lengyelform.add(verem.get(verem.size() - 1));
            verem.remove(verem.size() - 1);
        }
        return lengyelform;
    }

//        Verem.ürít
//Ciklus amíg (nem üres lengyel_forma)
//	elem: lengyel_forma.elso_elem
//	ha (elem típusa adat)
//		verembe(elem)
//	 ha (elem típusa művelet)
//		érték1=veremből()
//		érték2=veremből()
//		eredmény=kiszámol(érték2, művelet, érték1) (figyelni kell, érték2-érték1)
//		verembe(eredmény)
//	elágazás vége
//Ciklus vége
//Végeredmény=veremből()
}
