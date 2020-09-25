package item;

import util.TreeNode;

public class LeetCode968_监控二叉树 {
    int result = 0;

    public int minCameraCover(TreeNode root) {
        result = 0;
        int i = minCameraCover2(root);
        if (i == 0 )
            result++;
        return result;
    }

    // 定义
    //      1为已经被监视或者待监视
    //      2为监视摄像头的位置
    //      0为没有监视到的
    private int minCameraCover2(TreeNode node) {
        if (node == null) {
            return 1;
        }
        int left=minCameraCover2(node.left);
        int right=minCameraCover2(node.right);
        if (left == 0 || right == 0) {
            result++;
            return 2;
        }
        if(left==1&&right==1){
            return 0;
        }
        if(left==2 ||right==2){
            return 1;
        }
        return -1;
    }
}
