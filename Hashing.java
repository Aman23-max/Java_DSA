import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Hashing {

    public static ArrayList<Integer> majorityElement(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);    
        }

        for(int key : map.keySet()) {
            if(map.get(key) > arr.length/3) {
                res.add(key);
            }    
        }

        return res;
    }
    
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("China", 140);
        hm.put("India", 150);
        hm.put("US", 030);
        hm.put("Indonesia", 110);

        // System.out.println(hm);
        hm.remove("China");
        hm.containsKey("US");

        Set<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key +" = "+ hm.get(key));
        }
    }
}
