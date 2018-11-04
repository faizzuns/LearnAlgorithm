package Easy;

/**
 * @link https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(-999);
        ListNode pointer = list;
        ListNode now_first = l1;
        ListNode now_second = l2;
        while (now_first != null && now_second != null) {
            if (now_first.val <= now_second.val) {
                pointer.next = new ListNode(now_first.val);
                now_first = now_first.next;
            } else {
                pointer.next = new ListNode(now_second.val);
                now_second = now_second.next;
            }
            pointer = pointer.next;
        }

        if (now_first == null) {
            pointer.next = now_second;
        } else {
            pointer.next = now_first;
        }

        return list.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}