package medium.add_two_numbers;

import java.math.BigInteger;

public class Solution {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode nodeA = l1;
    String listA = "";
    while (nodeA != null) {
      listA = nodeA.val + listA;
      nodeA = nodeA.next;
    }

    ListNode nodeB = l2;
    String listB = "";
    while (nodeB != null) {
      listB = nodeB.val + listB;
      nodeB = nodeB.next;
    }

    String sum = "" + new BigInteger(listA).add(new BigInteger(listB));
    ListNode next = null;

    while (sum.length() > 0) {
      ListNode main = new ListNode(Integer.parseInt(sum.charAt(0) + ""));
      main.next = next;
      next = main;
      sum = sum.substring(1);
    }

    return next;
  }
}
