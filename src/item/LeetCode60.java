package item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yongz
 * @Date 2020/9/5、19:12
 * 60. 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class LeetCode60 {
    public static void main(String[] args) {
        String permutation = new LeetCode60().getPermutation(4, 9);
        System.out.println(permutation);
    }


    // 通过数学计算出来
    public   String getPermutation(int n, int k) {
        if(n==1) return "1";
        List<Integer> arrays = new ArrayList<>();
        int x = 1;
        for (int i = 0; i < n; i++)
            arrays.add(i + 1);

        // test(arrays, n, k) 该方法获取结果的第一值
        return permutation(arrays, n, k-1);
    }

    public   String permutation(List arrays, int n, int k) {


        if (n  == 1){
            // 把数组中最后一个值返回即为最后一个
            return arrays.get(0).toString();
        }
        int factorial = n - 1;
        //计算(n-1)!
        for (int j = factorial - 1; j >= 1; j--) {
            factorial = factorial * j;
        }
        //其实第一个值对应的索引其实就是等于 k/(n-1)!  % n
        int index = k / factorial ;

        // 这就是第一个值，然后再把该数组这个值移除点
        Object remove = arrays.remove(index);

        // 然后再去被找移除掉上一个值的新数组中。新数组的长度就是n-1；新数组的第k%(n-1)!排列
        return remove+ permutation(arrays, n - 1,  k % factorial);
    }
}
