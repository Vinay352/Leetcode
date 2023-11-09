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
    public boolean hasPathSum(TreeNode tree, int targetSum) {
        if(tree == null){
            return false;
        }

        return hasPathSumRecursion2(tree, targetSum);
    }

    // recursion 2
    public boolean hasPathSumRecursion2(TreeNode tree, int targetSum) {
        if(tree.left == null && tree.right == null){
            return tree.val == targetSum;
        }

        boolean leftSum = false;
        //recurse in left depth
        if(tree.left != null){
            tree.left.val += tree.val;
            leftSum = hasPathSumRecursion2(tree.left, targetSum);
        }

        boolean rightSum = false;
        //recurse in right depth
        if(tree.right != null){
            tree.right.val += tree.val;
            rightSum = hasPathSumRecursion2(tree.right, targetSum);
        }

        return leftSum || rightSum;

    }
}