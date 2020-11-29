package Menu;


import java.util.HashMap;

public class RegularSpendingHash {
    public HashMap<String, Double> spendingMap = new HashMap<>();

    public void viewHash(){
        spendingMap.put("Интернет", (double) 900);
        spendingMap.put("Комуналка", (double) 3500);
        spendingMap.put("Сервисы", (double) 1200);

        System.out.println(spendingMap);
    }




}
