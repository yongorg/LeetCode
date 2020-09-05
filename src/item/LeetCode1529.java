package item;

/**
 * @Author yongz
 * @Date 2020/9/5、22:23
 */
public class LeetCode1529 {


    public static void main(String[] args) {
        int i = new LeetCode1529().minFlips("101");

        System.out.println(i);
    }

    public int minFlips(String target) {

        int result = 0;
        char[] chars = target.toCharArray();
        for (int i = chars.length - 1; i >= 1; i--) {
            if (chars[i] != chars[i - 1]) {
                 result++;
            }
        }
        if ( chars[0] =='1') result ++;

        return result;
    }


}
