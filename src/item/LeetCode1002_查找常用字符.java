package item;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author yongz
 * @Date 2020/9/22、16:46
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 */
public class LeetCode1002_查找常用字符 {
    public static void main(String[] args) {
        LeetCode1002_查找常用字符 ltcode = new LeetCode1002_查找常用字符();
        String[] test = {"bella","label","roller"};
        List<String> strings = ltcode.commonChars2(test);
        System.out.println(strings);
    }

    // 暴力解决
    public List<String> commonChars(String[] A) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = A[0].toCharArray();
        for (char aChar : chars)
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);

        for (int i = 1; i < A.length; i++) {
            for (Character character : map.keySet()) {
                char[] chars2 = A[i].toCharArray();
                int aCount = map.get(character);
                if (aCount == 0) continue;
                int count = 0;
                for (int j = 0; j < chars2.length; j++) {
                    if (character.equals(chars2[j]))
                        count++;
                }
                map.put(character, aCount > count?count:aCount);
            }
        }


        ArrayList<String> list = new ArrayList<>();

        for (Character character : map.keySet()) {
            for (int i = 0; i < map.get(character); i++) {
                list.add(character.toString());
            }
        }
        return list;

    }

    // 矩阵
    public List<String> commonChars2(String[] A) {
        int[][] temp = new int[26][A.length];
        for (int i = 0; i < A.length; i++) {
            for (byte aByte : A[i].getBytes()) {
                temp[aByte - 97][i]++;
            }
        }
        List<String> list = new LinkedList<>();
        for (int i = 0; i < temp.length; i++) {
            int count = 100;
            for (int i1 = 0; i1 < A.length; i1++) {
                if(temp[i][i1]<count) count = temp[i][i1];
            }
            for (int j = 0; j < count; j++) {
                list.add(Character.toString((char)(i+97)));
            }
        }
        return list;
    }


}
