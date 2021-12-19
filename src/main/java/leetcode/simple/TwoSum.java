package leetcode.simple;

import javax.print.attribute.HashAttributeSet;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     *使用Map存储，键为数组中数字，值为索引
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (valIndex.containsKey(target - nums[i])) {
                return new int[]{i, valIndex.get(target - nums[i])};
            }
            valIndex.put(nums[i], i);
        }
        return new int[2];
    }
}
