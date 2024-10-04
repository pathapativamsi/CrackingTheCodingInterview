package ArraysAndStrings;

import java.util.*;

public class LootBox {

    private static void lootBox(Map<String,Integer> list1, Map<String,Integer> giftsWithPerson){
        HashMap<String,Integer> currentLootBox = new HashMap<>();
        for (Map.Entry<String,Integer> entry: list1.entrySet()){
            String key = entry.getKey();
            if(giftsWithPerson.containsKey(key)){
                int remaining = giftsWithPerson.get(key)%list1.get(key);
                currentLootBox.put(key,list1.get(key) - remaining);
            }
            else{
                currentLootBox.put(key,entry.getValue());
            }
        }
        //printing current items in lootbox
        for (Map.Entry<String,Integer> entry:
             currentLootBox.entrySet()) {
            System.out.println(entry.getKey() +": "+ entry.getValue());
        }

        //pick a random gift
        Random random = new Random();
        int currPick = random.nextInt(currentLootBox.size());
        Set<String> keys = currentLootBox.keySet();
        List<String> keyList = new ArrayList<>(keys);
        //without any probability
        System.out.println("Current pick is "+ keyList.get(currPick));

        //with probability
        int total = 0;
        for(int x: currentLootBox.values()){
            total += x;
        }
        int r = random.nextInt(total);
        int currWeight = 0;
        for (Map.Entry<String, Integer> entry: currentLootBox.entrySet()){
            currWeight += entry.getValue();
            if(r < currWeight){
                System.out.println("current pick is :"+entry.getKey());
                break;
            }
        }
    }
    public static void main(String[] args) {
        HashMap<String,Integer> list1 = new HashMap<>();
        HashMap<String,Integer> list2 = new HashMap<>();

        list1.put("p1",2);
        list1.put("p2",6);
        list1.put("p3",9);

        list2.put("p1",22);
        list2.put("p2",63);
        list2.put("p3",95);

        lootBox(list1,list2);

    }
}
