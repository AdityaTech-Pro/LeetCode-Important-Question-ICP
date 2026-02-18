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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> sorted=new ArrayList<>();
        inorder(root,sorted);
        return balanceBinarySearchTree(sorted, 0, sorted.size()-1);
    }
    public void inorder(TreeNode root, ArrayList<Integer>sorted){
        if(root==null) return;

        inorder(root.left,sorted);
        sorted.add(root.val);
        inorder(root.right,sorted);
    }

    public TreeNode balanceBinarySearchTree(ArrayList<Integer>sorted, int start, int end){  if(start>end) return null;
        int mid=start + (end-start)/2;
        TreeNode ans=new TreeNode(sorted.get(mid));

        ans.left=balanceBinarySearchTree(sorted,start,mid-1);
        ans.right=balanceBinarySearchTree(sorted,mid+1,end);
        return ans;
    }
}
