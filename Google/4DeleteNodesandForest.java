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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> remaining = new ArrayList<>();
        Set<Integer> ToDelete = new HashSet<>();
        for(int i : to_delete){
            ToDelete.add(i);
        }
        RemoveNodes(root, ToDelete, remaining);
        if(!ToDelete.contains(root.val)){
            remaining.add(root);
        }
        return remaining; 
    }
        public TreeNode RemoveNodes(TreeNode root, Set<Integer> ToDelete, List<TreeNode> remaining){
        if(root == null){
            return null;
        }
        root.left = RemoveNodes(root.left, ToDelete, remaining);
        root.right= RemoveNodes(root.right, ToDelete, remaining);
        if(ToDelete.contains(root.val)){
            if(root.left != null){
                remaining.add(root.left);
            }
            if(root.right != null){
                remaining.add(root.right);
            }
            return null;
        }
        return root;
    }
}