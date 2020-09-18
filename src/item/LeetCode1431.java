package item;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yongz
 * @Date 2020/9/10、10:35
 * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 *
 * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
 *
 */
public class LeetCode1431 {

    public static void main(String[] args) {
        int[] test = {2,3,5,1,3};
        List<Boolean> booleans = kidsWithCandies(test, 3);
        System.out.println(booleans);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max = candies[0];
        for (int i = 1; i < candies.length; i++)
            if (candies[i]>max)
                max = candies[i];

        List<Boolean> result = new ArrayList<>(candies.length);

        for (int i = 0; i < candies.length; i++)
            result.add(extraCandies+candies[i] >= max);

        return result;
    }
}
