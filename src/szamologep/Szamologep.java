package szamologep;

import java.util.ArrayList;

public class Szamologep {


    public static void main(String[] args) {

        ArrayList<String> lengyelform = new ArrayList<>();
        //2+6*(9-5) | 2695-*+ | Elvárt eredmény: 26
        lengyelform.add("2");
        lengyelform.add("6");
        lengyelform.add("9");
        lengyelform.add("5");
        lengyelform.add("-");
        lengyelform.add("*");
        lengyelform.add("+");
        System.out.println(lengyelFormSzamit(lengyelform));
    }

    private static float lengyelFormSzamit(ArrayList<String> lengyelform) {

        
        ArrayList<String> segedverem = new ArrayList<>();
        
        String elem;
        for (int i = 0; i < lengyelform.size(); i++) {
            elem = lengyelform.get(i);
            if (elem.equals("1") || elem.equals("2") || elem.equals("3") || elem.equals("4") || elem.equals("5") || elem.equals("6") || elem.equals("7") || elem.equals("8") || elem.equals("9") || elem.equals("0")) {
                segedverem.add(elem);
            }
            if (elem.equals("+") || elem.equals("-") || elem.equals("/") || elem.equals("*")) {
                char művelet = elem.charAt(0);
                float érték1 = Float.parseFloat(segedverem.get(segedverem.size()-1));
                float érték2 = Float.parseFloat(segedverem.get(segedverem.size()-2));
                for (int j = 0; j < 2; j++) {
                    segedverem.remove(segedverem.size()-1);
                }
                float eredmény = kiszámol(érték1, művelet, érték2);
                segedverem.add(String.valueOf(eredmény));
            }
        }
        String végeredmény = segedverem.get(0);
        return Float.parseFloat(végeredmény);
    }
    
    private static float kiszámol(float érték1, char művelet, float érték2) {
        float eredmény = 0;
        switch(művelet) {
            case '-':
                eredmény = érték2-érték1;
                break;
                
            case '+':
                eredmény = érték1+érték2;
                break;
                
            case '/':
                eredmény = érték2/érték1;
                break;
                
            case '*':
                eredmény = érték1*érték2;
                break;               
        }
        return eredmény;
    }
    
}
