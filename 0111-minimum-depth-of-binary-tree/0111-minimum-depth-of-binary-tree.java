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
    public int minDepth(TreeNode tree) {
        if(tree == null){
            return 0;
        }

        // queue to keep track of incoming nodes of the tree in level-order fashion
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(tree);

        // track visited nodes
        Set<TreeNode> visitedSet = new HashSet<TreeNode>();

        int minDepth = 1;

        // implement BFS
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                
                TreeNode popNode = queue.poll();
                
                if(popNode.left == null && popNode.right == null){
                    return minDepth;
                }

                if(popNode.left != null){ // insert left node in the queue
                    queue.add(popNode.left);
                }
                if(popNode.right != null){ // insert right node in the queue
                    queue.add(popNode.right);
                }

                visitedSet.add(popNode); // update the visited set
            }
            minDepth++;
        }

        return minDepth;
    }
}