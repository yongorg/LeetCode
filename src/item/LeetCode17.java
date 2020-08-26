package item;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author yongz
 * @Date 2020/8/26、13:41
 */
public class LeetCode17 {
    public final static char[][] DICTIONARIES = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'},
    };

    public static char[] chars;

    public static void main(String[] args) {
        String digits = "234";
        letterCombinations(digits);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits==null || "".equals(digits)) return list;
        chars = digits.toCharArray();
        int index = 0;
//        char[] dictionary = DICTIONARIES[Integer.parseInt(String.valueOf(chars[index++])) - 2];
        char[] dictionary = DICTIONARIES[chars[index++] - 50];
        for (int i = 0; i < dictionary.length; i++) {
            getList(list, index, String.valueOf(dictionary[i])); // 递归
        }

        return list;
    }

    public static void getList(List<String> list, int index, String str) {
        if (index >= chars.length) {
            list.add(str);
            return;
        }
//        char[] dictionary = DICTIONARIES[Integer.parseInt(String.valueOf(chars[index++])) - 2];
        char[] dictionary = DICTIONARIES[chars[index++] - 50];
        for (int i = 0; i < dictionary.length; i++) {
            getList(list, index, str + dictionary[i]);
        }
    }

}
