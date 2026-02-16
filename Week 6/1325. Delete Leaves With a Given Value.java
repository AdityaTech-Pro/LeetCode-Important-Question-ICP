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
    public TreeNode removeLeafNodes(TreeNode head, int target) {
        return check(head, target);
     }
    public TreeNode check(TreeNode head, int target){
        if (head == null) return null;
        
        head.left=check(head.left, target);
        head.right=check(head.right, target);

        if(head.left==null && head.right==null && head.val==target){
            return null;
        }
        return head;
    
    }
}
