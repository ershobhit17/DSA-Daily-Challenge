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
        // Create a min-heap using PriorityQueue
        PriorityQueue<ListNode> heap = new PriorityQueue<>(
            (a, b) -> a.val - b.val  // Compare by value
        );
        
        // Add head of each non-empty list to the heap
        for (ListNode head : lists) {
            if (head != null) {
                heap.offer(head);
            }
        }
        
        // Dummy node for result list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Process all nodes
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            current.next = node;
            current = current.next;
            
            // If there's a next node, add it to the heap
            if (node.next != null) {
                heap.offer(node.next);
            }
        }
        
        return dummy.next;
    }
}