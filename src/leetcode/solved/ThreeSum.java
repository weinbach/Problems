package leetcode.solved;

import java.util.*;

public class ThreeSum {
    //#15 3Sum
    public static List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> lists = new HashSet<>();
        Map<Integer, Integer> map = new Hashtable<>();

        for(int i=0;i<nums.length;i++)
            map.put(nums[i], i);

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                Integer a = map.get(-nums[i]-nums[j]);
                if(a!=null){
                    if(a!=j && a!=i){
                        ArrayList<Integer> arr = new ArrayList<>();
                        arr.add(nums[i]);
                        arr.add(nums[j]);
                        arr.add(nums[a]);
                        Collections.sort(arr);
                        lists.add(arr);
                    }
                }
            }
        }

        return new ArrayList<>(lists);
    }
}
