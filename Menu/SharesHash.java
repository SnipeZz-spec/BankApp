package Menu;

import java.util.HashMap;

public class SharesHash {
    public HashMap<String, Double> sharesHashMap = new HashMap<>();


    public void viewShares() {
        sharesHashMap.put("DoDo Pizza" , 0.15);
        sharesHashMap.put("VTB" , 0.25);
        sharesHashMap.put("Sber" , 0.75);
        sharesHashMap.put("Autodesk" , 0.75);
        sharesHashMap.put("Amazon" , 2.25);
        sharesHashMap.put("American Airlines" , 3.0);
        sharesHashMap.put("American Electrical Co" , 3.25);
        sharesHashMap.put("CocaCola Co" , 3.75);
        sharesHashMap.put("Electronic Arts" , 5.15);
        sharesHashMap.put("Apple" , 75.25);
        sharesHashMap.put("Tesla" , 100.25);

        System.out.println(sharesHashMap);
    }




}
