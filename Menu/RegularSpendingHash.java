package Menu;


import java.util.HashMap;

public class RegularSpendingHash {
    HashMap<String, Double> spendingMap = new HashMap<>();

    public void viewHash(){
        spendingMap.put("Оплата за интернет", (double) 900);
        spendingMap.put("Оплата комунальных услуг", (double) 3500);
        spendingMap.put("Оплата подписок на сервисы", (double) 1200);

        System.out.println(spendingMap);
    }




}
