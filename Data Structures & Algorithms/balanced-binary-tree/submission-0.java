/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {

        return height(root) != -1;
        
    }

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftH = height(root.left);
        if(leftH == -1){
            return -1;
        }

        int rightH = height(root.right);
        if(rightH == -1){
            return -1;
        }

        if(Math.abs(leftH - rightH) > 1){
            return -1;
        }

        return 1 + Math.max(leftH, rightH);
    }
}
