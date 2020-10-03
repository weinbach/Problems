package leetcode.solved.hashTable;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class TwoSum {

    // #1 Two Sum

    public static int[] twoSumBruteForce(int[] nums, int target) {
        int[] result = new int[2];
        for (int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if((nums[i] + nums[j]) == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        throw new IllegalArgumentException("No matching items");
    }

    public static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> ht = new Hashtable<>();
        for(int i=0;i<nums.length;i++){
            ht.put(nums[i], i);
        }

        for(int i=0;i<nums.length;i++){
            Integer a = ht.get(target-nums[i]);
            if(a!=null){
                if(i!=a)
                    return new int[] {i, a};
            }
        }

        throw new IllegalArgumentException("No matching items");
    }

    public static int[] twoSumOnePath(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int a = target - nums[i];
            if(map.containsKey(a))
                return new int[]{map.get(a), i};
            else
                map.put(nums[i], i);
        }
        throw  new IllegalArgumentException("No matching items");
    }

}
