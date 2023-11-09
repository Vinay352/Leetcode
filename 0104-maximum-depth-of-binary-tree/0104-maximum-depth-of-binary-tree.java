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
    public int maxDepth(TreeNode tree) {
        if(tree == null){
            return 0;
        }

        //recurse in left depth
        int leftDepth = 1 + maxDepth(tree.left);

        //recurse in right depth
        int rightDepth = 1 + maxDepth(tree.right);
        
        // return the greater depth
        return (leftDepth >= rightDepth) ? leftDepth : rightDepth;
    }
}