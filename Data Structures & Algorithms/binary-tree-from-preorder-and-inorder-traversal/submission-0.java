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

    int preorderIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i], i);
        }

        return construct(preorder, 0, inorder.length - 1);
    }

    public TreeNode construct(int [] preorder, int left, int right){
        if(left > right){
            return null;
        }

        int rootValue = preorder[preorderIndex++];

        TreeNode root = new TreeNode(rootValue);

        int inorderIndex = map.get(rootValue);

        root.left = construct(preorder, left, inorderIndex - 1);

        root.right = construct(preorder, inorderIndex + 1, right);

        return root;
    }
}
