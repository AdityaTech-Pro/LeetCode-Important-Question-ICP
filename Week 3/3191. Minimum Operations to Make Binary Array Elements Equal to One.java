// class Solution {
//     public int minOperations(int[] nums) {
//         int n=nums.length;
//         int count=0;
//         for(int i=0; i<n-2; i++){
//             if(nums[i]==0){
//                 nums[i]=nums[i]^1;   //0 XOR 1 = 1   and  1 XOR 1 = 0
//                 nums[i+1]=nums[i+1]^1;
//                 nums[i+2]^=1;
//                 count++; 
//             }
//         }
//         int ans=(nums[n-1]==1 && nums[n-2]==1) ? count : -1;
//         return ans;
//     }
// }

//with using Queue
class Solution {
    public int minOperations(int[] nums) {
        Deque<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i=0; i<nums.length; i++) {
            q.add(nums[i]);
        }

        while(q.size() >= 3) {
            while(q.size() != 0 && q.getFirst() == 1) {
                q.remove();
            } 

            if(q.size() < 3) break;

            if(q.getFirst() == 0) {
                count++;
                q.removeFirst();
                int second = q.removeFirst();
                int third = q.removeFirst();

                if(second == 1) {
                    if(third == 1) {
                        q.addFirst(0);
                        q.addFirst(0);
                    } else {
                        q.addFirst(1);
                        q.addFirst(0);
                    }
                } else {
                    if(third == 1) {
                        q.addFirst(0);
                    }
                }
            }
        }

        for(int val : q) {
            if(val != 1) return -1;
        }
        return count;
    }
}
