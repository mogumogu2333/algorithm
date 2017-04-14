package linkedlist;

import tree.TreeNode;

public class ConvertSortedListBST_109 {
	public TreeNode sortedListToBST(ListNode head) {
		if(head==null)return null;
		
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
        	prev = prev.next;
        	slow = slow.next;
        	fast = fast.next.next;
        }
        prev.next = null;
        TreeNode root = new TreeNode(slow.val);
		root.left = sortedListToBST(dummy.next);
		root.right = sortedListToBST(slow.next);
		return root;
    }
	
}
