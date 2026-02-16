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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
    //     int n=queries.size();
    //     int[][] answer=new int[n][2];
    //     for(int i=0; i<n; i++){
    //         int target=queries.get(i);
    //         answer[i]=check(root,target);
    //     }
    //     return answer;
    // }
    // public TreeNode check(TreeNode root, int target){
    //     int[] part=new int[2];
    //     int left=0;
    //     int right=0;
    //     part[1]=Integer.MAX_VALUE;
    //     if(root==null) return null;
    //     root.left=check(root.left, target);
    //     root.right=check(root.right, target);
    //     if(root.val<=target){
    //         left=root.val;
    //         part[0]=Math.max(part[0],left);
    //     }
    //     if(root.val>=target){
    //         right=root.val;
    //         part[1]=Math.min(part[1],right);
    //     }
    //     return part;





    List<Integer> list = new ArrayList<>();
        inorder(list, root);
        List<List<Integer>> res = new ArrayList<>();
        for (int q : queries){
            res.add(binarySearch(list, q));
        }
        return res;
    }
    private List<Integer> binarySearch(List<Integer> list, int n){
        int low = 0;
        int high = list.size() - 1;
        int min = -1;
        int max = -1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            int temp = list.get(mid);
            if (temp == n){
                min = temp;
                max = temp;
                break;
            }else if (temp < n){
                min = temp;
                low = mid + 1;
            }else{
                max = temp;
                high = mid - 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(min);
        res.add(max);
        return res;
    }
    private void inorder(List<Integer> res, TreeNode root){
        if (root == null) return;
        inorder(res, root.left);
        res.add(root.val);
        inorder(res, root.right);
    }
}
