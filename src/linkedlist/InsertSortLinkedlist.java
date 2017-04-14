package linkedlist;

public class InsertSortLinkedlist {
	public ListNode insertionSortList(ListNode head) {
		/*
		 * 1. if cur.next < cur, cur.next needs to be inserted into a position between dummyhead and cur.
		 * 1.1 pre is starting from dummy head to cur; use pre.next to find a value that is larger than cur.next. 
		 * 1.2 then, the insert pos is between pre and pre.next
		 * 2. return dummy.next. head may already not the start of list.
		 */
		if(head==null)return head;
		
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode curr = head;
		
		
		while(curr.next!=null){
			if(curr.next.val < curr.val){ 
				//need to insert curr.next to some pos
				ListNode target = curr.next;
				//insert
				ListNode pre = dummy;
				while(pre.next!=null && pre.next.val < target.val)pre = pre.next;
				
				//insert between pre and pre.next
				curr.next = target.next;
				target.next = pre.next;
				pre.next = target;
				pre = dummy;
				
			}
			else{
				curr = curr.next;
			}
		}
		return dummy.next;
		
        
    }
	
	
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,1};
		ListNode head = ListNode.fromArray(arr);
		ListNode.printAll(head);
		
		InsertSortLinkedlist sol = new InsertSortLinkedlist();
		ListNode newhead = sol.insertionSortList(head);
		ListNode.printAll(newhead);
	}
}
