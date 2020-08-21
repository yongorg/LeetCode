package item;

/**
 * @Author yongz
 * @Date 2020/8/20、13:40
 */
public class HappyNum {

    public static void main(String[] args) {
        isHappy(100);
    }

    public static void isHappy(int n) {
        if (n == 1) {
            System.out.println(true);
            return ;
        }

        int temp = 0;
        while (true) {
            temp += n % 10 * n % 10;
            n = n / 10;
            if (n == 0) break;
        }
        System.out.println(temp);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isHappy(n);
    }
}
