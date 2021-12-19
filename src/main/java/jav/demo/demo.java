package jav.demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class demo {
    private void show(int[][] nums){
        for (int[] unit: nums) {
            System.out.print(unit[1] + ", ");
        }
    }
    @Test
    public void numArrayAdd(){ // 二维数组lambda表达式排序
        int[][] nums = {{1,2},{1,3},{1,1},{1,10},{1,8},{1,5}};
        show(nums);
        Arrays.sort(nums, (o1, o2) -> o1[1] - o2[1]);
        System.out.println("\n=====排序后======");
        show(nums);
    }
}
