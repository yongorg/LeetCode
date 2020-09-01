package util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yongz
 * @Date 2020/8/31、22:24
 */
public class ListUtil {

    public static List<List<Integer>> getDBList(int[][] data) {
        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> integers ;

        for (int i = 0; i <data.length; i++) {
            integers = new ArrayList<>();
            for (int j = 0; j < data[i].length; j++) {
                integers.add(data[i][j]);
            }
            lists.add(integers);
        }
        return lists;
    }
}
