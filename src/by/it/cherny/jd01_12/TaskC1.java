package by.it.cherny.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        TreeMap<Object, Object> map = new TreeMap<>();
        for(;;){
            String value = sc.next();
            if (!value.equals("end")){
                map.put(getRandomKey(map.keySet()), value);
            } else {
                break;
            }
        }
        System.out.println(map);
        TreeMap<Object, Object> newMap = removeDuplicates(map);
        System.out.println(newMap);
    }

    private static TreeMap<Object, Object> removeDuplicates(Map<Object, Object> map) {
        TreeMap<Object, Object> map1 = new TreeMap<>();
        for (Iterator<Object> it = map.keySet().iterator(); it.hasNext();) {
            Object key = it.next();
            Object val = map.get(key);
            if (!map1.containsValue(val)) {
                map1.put(key, val);
            }
        }
//        System.out.println(map1+"map1");
//        map.clear();
//        for (Iterator<Object> it = map1.keySet().iterator(); it.hasNext();) {
//            Object key = it.next();
//            map.put(key, map1.get(key));
//        }
        return map1;
    }

    private static Object getRandomKey(Collection<Object> keySet) {
        int random;
        do {
            random = (int) ((Math.random()*(999999-100000))+100000);
        } while(keySet.contains(random));
        return random;
    }
}
