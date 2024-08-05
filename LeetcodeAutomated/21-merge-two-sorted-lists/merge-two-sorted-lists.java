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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
            ListNode heada = list1;
            while(heada != null){
                pq.offer(heada.val);
                heada=heada.next;
                // System.out.println(pq);
            }

            ListNode headb = list2;
            while(headb != null){
                pq.offer(headb.val);
                headb=headb.next;
                // System.out.println(pq);
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
