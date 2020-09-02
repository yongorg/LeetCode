package offer;

/**
 * @Author yongz
 * @Date 2020/9/2、9:36
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 */
public class LeetCode20 {


    public static void main(String[] args) {

        System.out.println(isNumber("84656e656D"));
    }

    public static boolean isNumber(String s) {

        if (s.contains("F") ||s.contains("f") ||s.contains("D")||s.contains("d") ) return false;

        try {
            double v = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
