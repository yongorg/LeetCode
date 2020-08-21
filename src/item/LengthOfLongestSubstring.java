package item;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class LengthOfLongestSubstring {


    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring2(str));
    }

    /**
     *
     * @param s
     * @return
     */
    public static  int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int result=0;
        int index=0;
        HashMap<Object,Integer> hash = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            if (hash.containsKey(chars[i])){
                result = index>result? index :result;
                index=1;
                i = hash.get(chars[i])+1; //相当于又要重新遍历导致时间消耗
                hash=new HashMap<>();
            }else {
                index ++;
            }
            hash.put(chars[i],i);

        }
        chars=null;
        return index>result? index :result;
    }

    /**
     *
     * @param s
     * @return
     */
    public static  int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        int result=0;
        int start=0;//记录开始点
        int end=0;//记录结束点
        HashMap<Object,Integer> hash = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (hash.containsKey(chars[i]) && hash.get(chars[i])+1 >start){
                result = end - start >result? end - start :result;
                start=hash.get(chars[i])+1;

            }
            end ++;
            hash.put(chars[i],i);

        }
        chars=null;
        return end - start >result? end - start :result;
    }
}
