package item;

/**
 * @Author yongz
 * @Date 2020/9/5、22:13
 */
public class LeetCode {

    public static void main(String[] args) {
        int[] a = {4,5,6,7,0,2,1,3};
        System.out.println(restoreString("codeleet",a));
    }
    public static String restoreString(String s, int[] indices) {

        char[] chars = s.toCharArray();
        char[] rel2 =  new  char[indices.length];
        StringBuffer rel= new StringBuffer();
        for (int i = 0; i < indices.length; i++)
            rel2[indices[i]] = chars[i];

        for (int i = 0; i < rel2.length; i++)
            rel.append(rel2[i]);

        return rel.toString();
    }
}
