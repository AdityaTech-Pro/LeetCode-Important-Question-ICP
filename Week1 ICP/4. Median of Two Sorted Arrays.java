// Leetcode Submition link : https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/1884566582/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        ArrayList<Integer>adi=new ArrayList<>(n+m);
        int len=n+m;
        for(int i=0; i<n; i++){
            adi.add(nums1[i]);
        }
        for(int i=0; i<m; i++){
            adi.add(nums2[i]);
        }
        Collections.sort(adi);
        double median=0;
        if(len % 2 == 0){
            int idx1=(len-1)/2;
            int idx2=len/2;
            median=(double)(adi.get(idx1) + adi.get(idx2)) / 2;
        }
        else{
            int idx=len/2;
            median=adi.get(idx);
        }
        return median;
    }
}
