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
    public TreeNode invertTree(TreeNode tree) {
        if(tree == null){
            return null;
        }

        TreeNode left = invertTree(tree.right);
        TreeNode right = invertTree(tree.left);

        tree.left = left;
        tree.right = right;

        return tree;
    }
}