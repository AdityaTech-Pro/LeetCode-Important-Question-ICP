/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode doubleIt(ListNode head) {
         head = reverse(head);

        int carry = 0;
        ListNode curr = head;

        while (curr != null) {
            int val = curr.val * 2 + carry;
            curr.val = val % 10;
            carry = val / 10;

            if (curr.next == null && carry > 0) {
                curr.next = new ListNode(carry);
                carry = 0;
                break;
            }

            curr = curr.next;
        }

        // reverse back
        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
      
// 2nd Approach
        // long num=0;
        // ListNode present=head;
        // while(present != null){
        //     num=num*10 + present.val;
        //     present=present.next;
        // }

        // long ans=2*num;

        // String s=String.valueOf(ans);
        // ListNode AdiHead=new ListNode(s.charAt(0)-'0');
        // ListNode curr=AdiHead;
        // for(int i=1; i<s.length(); i++){
        //     curr.next=new ListNode(s.charAt(i)-'0');
        //     curr=curr.next;
        // }
        // return AdiHead;
    }
}
