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
    public boolean isSubtree(TreeNode tree, TreeNode subTree){
        if(subTree == null){ // if subtree is null
            return true;
        }
        if(tree == null && subTree != null){ // if tree is null, subtree is not
            return false;
        }
        if(tree != null && subTree == null){ // if tree is not null, subtree is null
            return true;
        }

        if(isSameTree(tree, subTree)){ // if a match from the start node of both trees is found
            return true;
        }
        
        // if we do not have a value match at the current node of both trees
        boolean leftSide = isSubtree(tree.left, subTree); // check in tree.left for subtree
        boolean rightSide = isSubtree(tree.right, subTree); // check in tree.right for subtree

        return leftSide || rightSide; // if found in left or right
    }

    public boolean isSameTree(TreeNode tree, TreeNode tree2) {
        // if both have reached the end
        if(tree == null && tree2 == null){
            return true;
        }

        // if one tree reaches a leaf node and the other one doesn't
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