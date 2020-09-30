package item;

/**
 * @Author yongz
 * @Date 2020/9/27、9:33
 */
public class LeetCode7_整数反转 {
    public static void main(String[] args) {


        LeetCode7_整数反转 test = new LeetCode7_整数反转();


        System.out.println(test.reverse(1534236469));
    }

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }


    public int reverse1(int x) {
        int temp = x < 0 ? x * -1 : x;

        int result = 0;
        System.out.println(Integer.toString(temp));
        int length = Integer.toString(temp).length();
        while (temp > 0) {

            int temp2 = temp % 10;
            System.out.println(temp2);
            for (int j = 0; j < length - 1; j++) {
                temp2 *= 10;
            }

            result += temp2;
//            System.out.println(result);
            length--;
            temp = temp / 10;
        }
        return x < 0 ? result * -1 : result;
    }
}
