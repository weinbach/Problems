package leetcode.solved;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MinMakeTwoStringAnagram {
    //#1347 Minimum Number of Steps to Make Two Strings Anagram
    public static void main(String[] args) {
        System.out.println("res: " + minSteps("friend","family"));
    }

    public static int minSteps(String s, String t) {
        int steps = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map1.containsKey(s.charAt(i)))
                map1.replace(s.charAt(i), (map1.get(s.charAt(i))+1));
            else
                map1.put(s.charAt(i), 1);

            if(map2.containsKey(t.charAt(i)))
                map2.replace(t.charAt(i), (map2.get(t.charAt(i))+1));
            else
                map2.put(t.charAt(i),1);
        }

        Iterator it = map1.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(map2.containsKey(pair.getKey())){
                steps+=Math.abs((int)pair.getValue() - map2.get(pair.getKey()));
                map2.remove(pair.getKey());
            } else {
                steps+=(int)pair.getValue();
            }
            it.remove();
        }
        Iterator it2 = map2.entrySet().iterator();
        while(it2.hasNext()){
            steps+=(int)((Map.Entry)it2.next()).getValue();
            it2.remove();
        }
        return steps/2;
    }

}
