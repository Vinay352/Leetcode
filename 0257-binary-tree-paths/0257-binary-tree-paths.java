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
    public  List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<String>();
        String path = "";

        ans = binaryTreePathsUtil(root, path, ans);
        for(int i = 0; i < ans.size(); i++){
            String temp = ans.get(i);
            ans.set(i, temp.substring(2));
//            System.out.println( temp.substring(2) );
        }

        return ans;
    }

    public List<String> binaryTreePathsUtil(TreeNode root, String path, List<String> ans) {
        
        if(root.left == null && root.right == null){
            path = path + "->" + root.val;
            ans.add(path);
            return ans;
        }

        path = path + "->" + root.val;

        if(root.left != null){
//            path = path + "->" + root.val;
            ans = binaryTreePathsUtil(root.left, path, ans);
        }

        if(root.right != null){
//            path = path + "->" + root.val;
            ans = binaryTreePathsUtil(root.right, path, ans);
        }

        return ans;
    }
}