package hard.merge_k_sorted_lists;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        int min = findMin(lists);
        
        ListNode head = null;
        ListNode tail = null;
        
        while(min != -1) {
            if(head == null) {
                head = tail = lists[min];
                lists[min] = head.next;
                head.next = null;
            } else {
                tail.next = lists[min];
                tail = tail.next;
                                
                lists[min] = tail.next;
                tail.next = null;
            }
            
            min = findMin(lists);
        }
        
        return head;
    }

    public int findMin(ListNode[] lists) {
        int index = -1;
        int min = -1;

        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node != null) {
                int val = node.val;
                if (index == -1) {
                    index = i;
                    min = val;
                } else if (min > val) {
                    min = val;
                    index = i;
                }
            }
        }

        return index;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
