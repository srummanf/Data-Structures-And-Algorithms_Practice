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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        ListNode ln = new ListNode();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            ListNode head = lists[i];
            while(head != null){
                pq.offer(head.val);
                head=head.next;
                // System.out.println(pq);
            }
        }
         
        ListNode head = new ListNode();
        ListNode current = head;
        while(pq.size()>=1){
            int a = pq.poll();
            ListNode newNode = new ListNode(a);
            newNode.next = null;
            current.next = newNode;
            current = newNode;
        }
        return head.next;
    }
}