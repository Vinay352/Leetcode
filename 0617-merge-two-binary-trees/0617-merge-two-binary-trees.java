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
    public TreeNode mergeTrees(TreeNode tree1, TreeNode tree2) {
        if(tree1 == null && tree2 == null){
            return null;
        }
        if(tree1 == null && tree2 != null){
            return tree2;
        }
        if(tree1 != null && tree2 == null){
            return tree1;
        }

        TreeNode mergedTrees1 = tree1;
        mergedTrees1 = mergedTwoTrees(tree1, tree2, mergedTrees1);
        return mergedTrees1;
    }

    public TreeNode mergedTwoTrees(TreeNode tree1, TreeNode tree2, TreeNode mergedTrees) {

        if(tree1 == null && tree2 == null){ // if both don't exist
            mergedTrees = null;
        }

        else if(tree1 != null && tree2 == null){ // if 1 is not null but 2 is
            mergedTrees = tree1;

            //recurse in left depth
            mergedTrees.left = mergedTwoTrees(tree1.left, null, mergedTrees.left);

            //recurse in right depth
            mergedTrees.right = mergedTwoTrees(tree1.right, null, mergedTrees.right);

        }

        else if(tree1 == null && tree2 != null){ // if 1 is null but 2 is not
            mergedTrees = tree2;

            //recurse in left depth
            mergedTrees.left = mergedTwoTrees(null, tree2.left, mergedTrees.left);

            //recurse in right depth
            mergedTrees.right = mergedTwoTrees(null, tree2.right, mergedTrees.right);

        }

        else if(tree1 != null && tree2 != null){ // if both exists, add them up in 1 node

            mergedTrees = tree1;
            mergedTrees.val += tree2.val;

            //recurse in left depth
            mergedTrees.left = mergedTwoTrees(tree1.left, tree2.left, mergedTrees.left);

            //recurse in right depth
            mergedTrees.right = mergedTwoTrees(tree1.right, tree2.right, mergedTrees.right);
        }

        return mergedTrees;
    }
}