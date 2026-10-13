/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        int temp = next.val;
        next.val = node.val;
        node.val = temp;
        node.next = next.next;
        next.next = null;
    }
}