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

        // stack to keep track of incoming nodes of the tree
        // stack is used to imitate traverse the tree depth wise
        Stack<TreeNode> stack = new Stack<>();
        stack.push(tree);

        // track visited nodes
        Set<TreeNode> visitedSet = new HashSet<TreeNode>();

        // traverse the tree once while appending every node in the the tree
        while(!stack.isEmpty()){
            int notALeaf = 0; // track whether current popNode is leaf or not
            TreeNode popNode = stack.pop();

            if(popNode.right != null){ // insert right node in the queue
                popNode.right.val += popNode.val; // update right child value
                stack.add(popNode.right);
                notALeaf = 1;
            }
            if(popNode.left != null){ // insert left node in the queue
                popNode.left.val += popNode.val; // update left child value
                stack.add(popNode.left);
                notALeaf = 1;
            }

            if(notALeaf == 0){ // if we've encountered a leaf node
                if(popNode.val == targetSum){ // check for a match
                    return true;
                }
            }
            visitedSet.add(popNode);
        }

        return false;
    }

}