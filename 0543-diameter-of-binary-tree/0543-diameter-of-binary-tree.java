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
    // function to calculate diameter of binary tree
    public int diameterOfBinaryTree(TreeNode tree) {
        if(tree == null){
            return 0;
        }

        int[] result = new int[1];

        int heightOfTree = diameterOfBinaryTreeUtil(tree, result);
        int diameter = result[0];// max diameter is stored in result[0]
        return diameter;
    }

    // use postfix approach and DFS
    public int diameterOfBinaryTreeUtil(TreeNode tree, int[] result) {
        if(tree == null){
            return -1; // convention is [height = -1] for null nodes
        }

        if(tree.left == null && tree.right == null){
            return 0; // convention is [height = 0] for leaf nodes
        }

        int leftHeight = diameterOfBinaryTreeUtil(tree.left, result);
        int rightHeight = diameterOfBinaryTreeUtil(tree.right, result);

        // to update the maximum diameter
        int diameterSoFar = calculateDiameter(leftHeight, rightHeight);
        if(diameterSoFar >= result[0]){ // if new diameter is greater than our max diameter
            result[0] = diameterSoFar;
        }

        // to return the new maxHeight to the calling function
        int maxHeightSoFar = calculateHeight(leftHeight, rightHeight);

        return maxHeightSoFar; // return the new maximum height to its parent function
    }

    // a function to calculate diameter of current node
    // idea is to add heights from left and right subtrees
    // and + 2
    // because 1 edge from parent node to left node
    // and 1 edge from parent node to right node
    public int calculateDiameter(int leftHeight, int rightHeight){
        return 2 + leftHeight + rightHeight;
    }

    // height of current node would be whatever is the maximum from left and right subtree
    // + 1
    // because of adding a new level/height i.e. current/parent node
    public int calculateHeight(int leftHeight, int rightHeight){
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
