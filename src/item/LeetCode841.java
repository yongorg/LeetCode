package item;

import util.ListUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author yongz
 * @Date 2020/8/31、17:12
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 * <p>
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 * <p>
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 * <p>
 * 你可以自由地在房间之间来回走动。
 * <p>
 * 如果能进入每个房间返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释:
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * 示例 2：
 * <p>
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * 提示：
 * <p>
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * 所有房间中的钥匙数量总计不超过 3000。
 */
public class LeetCode841 {
    public static void main(String[] args) {
        int[][] rooms = {
                {1,3, 2},
                {},
                {1}

        };
        List<List<Integer>> dbList = ListUtil.getDBList(rooms);
        System.out.println(dbList);

        System.out.println(new LeetCode841(). canVisitAllRooms(dbList));
    }

    public Set<Integer> hash = new HashSet();

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms .size() <= 1) return true; //如果就一个房间直接返回true
        // 先找第一房间的钥匙
        getKeys(rooms , 0); //搜索钥匙

        for (int i = 1; i < rooms.size(); i++) {
            if (!hash .contains(i)) return false;
        }

        return true;
    }

    public void getKeys(List<List<Integer>> rooms , int key) { // 获取当前房间的所有钥匙
        if (hash.contains(key)) return; //如果已经有钥匙了说明已经搜索过了

        hash.add(key); //当前房间存起来

        List<Integer> room = rooms.get(key);//当前房间的所有钥匙
        for (int j = 0; j < room.size(); j++) {
            getKeys(rooms , room.get(j)) ;// 并去找下一个房间的钥匙
        }
    }

}
