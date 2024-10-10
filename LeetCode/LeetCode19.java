package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode19 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            nodes.add(temp);
            temp = temp.next;
        }
        nodes.remove(nodes.size() - n);
        if (nodes.size() > 0) {
            nodes.get(nodes.size() - n - 1).next = null;
        }
        return nodes.get(0);
    }
}
