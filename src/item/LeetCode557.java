package item;

import java.util.Arrays;

/**
 * @Author yongz
 * @Date 2020/8/30、1:57
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 * <p>
 * 提示：
 * <p>
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class LeetCode557 {
    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        String s = new LeetCode557().reverseWords(str);
        System.out.println(s);
    }
    private StringBuffer sb = new StringBuffer();

    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            reverse(s1[i],i == s1.length-1);
        }
        return sb.toString();
    }

    public void reverse(String s,boolean flag) {
        char[] chars = s.toCharArray();
        for (int i = chars.length-1; i >= 0; i--) {
           sb.append(chars[i]);
        }
        if (!flag)
            sb.append(" ");
    }

}
