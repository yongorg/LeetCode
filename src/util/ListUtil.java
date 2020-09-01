package util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yongz
 * @Date 2020/8/31、17:16
 */
public class ListUtil {
    // 二维数组构建二维list
    public static List<List<Integer>> getDBList(int[][] data){
        ArrayList<List<Integer>> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList1;
        for (int i = 0; i < data.length; i++) {
            arrayList1   = new ArrayList<>();
            for (int j = 0; j < data[i].length; j++) {
                arrayList1.add(data[i][j]);
            }
            arrayList.add(arrayList1);
        }
        return arrayList;
    }

}
