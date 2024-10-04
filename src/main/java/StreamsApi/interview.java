//package StreamsApi;
//
//import java.util.*;
//
//public class interview {
//    public class LRUCache<K,V>{
//        private int max_limit = 10;
//        HashMap<K,V> cachedData = new HashMap<>();
//        LinkedHashMap<K,Integer> dataCount = new LinkedHashMap<>();
//        public V getfromCache(K key){
//            if(!cachedData.containsKey(key)) return null;
//            dataCount.put(key,dataCount.get(key) + 1);
//            return cachedData.get(key);
//        }
//
//        public V insertIntoCache(K key, V value){
//            if(cachedData.size() == max_limit){
//                K leastUsedKey = getLeastUsedKey();
//                cachedData.remove(leastUsedKey);
//            }
//            else {
//                dataCount.put(key,dataCount.get(key) + 1);
//                cachedData.put(key,value);
//            }
//            return cachedData.get(key);
//        }
//
//        private K leastUsedKey(){
//            int min = Integer.MAX_VALUE;
//            K leastKey = null;
//            for(Map.Entry<K,Integer> entry: dataCount.entrySet()){
//                if(entry.getValue() < min){
//                    leastKey = entry.getKey();
//                    min = entry.getValue();
//                }
//            }
//           Optional<> val=  dataCount.entrySet().stream().min(Comparator.comparing(x -> x.getValue()));
//            return leastKey;
//        }
//    }
//    //least recently used cache
//
//}
//
////a3 b2 c1 d1
