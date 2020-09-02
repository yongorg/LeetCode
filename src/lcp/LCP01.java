package lcp;

/**
 * @Author yongz
 * @Date 2020/9/2、14:04
 */
public class LCP01 {
    public static void main(String[] args) {

    }

    public int game1(int[] guess, int[] answer) {

        int count = 0;
        for (int i = 0; i < 3; i++)
            if (guess[i] == answer[i])
                count += 1;

        return count;
    }



}
