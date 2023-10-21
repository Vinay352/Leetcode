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
    public List<Double> averageOfLevels(TreeNode tree) {
        if(tree == null){
            return null;
        }

        // queue to keep track of incoming nodes of the tree in level-order fashion
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(tree);

        // track visited nodes
        Set<TreeNode> visitedSet = new HashSet<TreeNode>();

        int nodesAtCurrentLevel = 1;
        int countOfChildNodesAtNextLevel = 0;
        int totalLevelNodesCount = 1;

        List<Double> levelAverage = new ArrayList<Double>();
        double levelNodesSum = 0;

        // implement BFS
        while(!queue.isEmpty()){
            TreeNode popNode = queue.poll(); // get the current node

            levelNodesSum += popNode.val;

            if(popNode.left != null){ // insert left node in the queue
                queue.add(popNode.left);
                countOfChildNodesAtNextLevel++;
            }
            if(popNode.right != null){ // insert right node in the queue
                queue.add(popNode.right);
                countOfChildNodesAtNextLevel++;
            }

            nodesAtCurrentLevel--;

            if(nodesAtCurrentLevel == 0){
                levelAverage.add( (double)(levelNodesSum) / (double)(totalLevelNodesCount));
                nodesAtCurrentLevel = countOfChildNodesAtNextLevel;
                totalLevelNodesCount = countOfChildNodesAtNextLevel;
                countOfChildNodesAtNextLevel = 0;
                levelNodesSum = 0;
            }

            visitedSet.add(popNode); // update the visited set
        }

        return levelAverage;
    }
}