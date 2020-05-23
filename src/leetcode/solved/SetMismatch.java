package leetcode.solved;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SetMismatch {
    //#645 Set Mismatch
    public static int[] findErrorNums(int[] nums) {
        int actualSum = 0;
        int doubledNumber = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            actualSum += nums[i];
            if (nums[i] == nums[i + 1]) {
                doubledNumber = nums[i];
            }
        }
        actualSum += nums[nums.length - 1];
        return new int[]{doubledNumber, (doubledNumber - actualSum + (((1 + nums.length) * nums.length) / 2))};
    }

    public static void main(String[] args) {
        int[] asd = findErrorNums(new int[]{1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10, 12});
        System.out.println("result: " + asd[0] + " " + asd[1]);
    }


    public int[] findErrorNumss(int[] nums) {
        int actualSum = 0;
        int doubledNumber = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            actualSum += nums[i];
            if (map.containsKey(nums[i])) {
                doubledNumber = nums[i];
            }
            if (doubledNumber == 0)
                map.put(nums[i], i);
        }
        return new int[]{doubledNumber, (doubledNumber - actualSum + (((1 + nums.length) * nums.length) / 2))};
    }
}
