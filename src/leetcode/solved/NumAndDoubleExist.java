package leetcode.solved;

import java.util.HashMap;

public class NumAndDoubleExist {
    //#1346 Check If N and Its Double Exist
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer,Integer> m  = new HashMap<Integer, Integer>();
        for(int i=0;i<arr.length;i++){

            if (m.containsKey(arr[i]*2) || (m.containsKey(arr[i]/2) && (arr[i] % 2 == 0))){
                return true;
            } else{
                m.put(arr[i], i);
            }
        }

        return false;
    }
}
