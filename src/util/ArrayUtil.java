package util;

import java.util.Random;

/**
 * @Author yongz
 * @Date 2020/8/19、23:17
 */
public class ArrayUtil {

    public static int[] getRandomArray(int size){
        int[] ints = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            ints[i] = random.nextInt(size);
        }

        return ints;
    }
}
