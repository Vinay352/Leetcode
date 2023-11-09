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
    public boolean isSameTree(TreeNode tree, TreeNode tree2) {
        // if both have reached the end
        if(tree == null && tree2 == null){
            return true;
        }
        
        if(tree == null || tree2 == null){
            return false;
        }

        if(tree.val == tree2.val){
            //recurse in left depth
            boolean foundInLeftDepth = isSameTree(tree.left, tree2.left);
            //recurse in right depth
            boolean foundInRightDepth = isSameTree(tree.right, tree2.right);

            // if left and right, both are same
            return foundInLeftDepth && foundInRightDepth;
        }

        return false;
    }
}