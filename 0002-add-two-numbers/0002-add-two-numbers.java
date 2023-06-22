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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
   
        ListNode outputNode = new ListNode();

		ListNode tempOutputNode = outputNode;

		int sum = 0;
		int carry = 0;

		while (l1 != null || l2 != null || carry != 0) {

			sum += carry;
			carry = 0;

			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			if ((sum / 10) == 0) {
				tempOutputNode.val = sum;

				if (l1 != null || l2 != null) {
					tempOutputNode.next = new ListNode();
					tempOutputNode = tempOutputNode.next;
				}

			} else {
				tempOutputNode.val = (sum % 10);

				if (l1 != null || l2 != null || sum != 0) {
					tempOutputNode.next = new ListNode();
					tempOutputNode = tempOutputNode.next;
				}

				carry = sum / 10;
			}

			sum = 0;

		}

		tempOutputNode = null;

		return outputNode;
        
    }
}