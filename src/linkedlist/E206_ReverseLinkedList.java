package linkedlist;

public class E206_ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		
        
//		ListNode dummy = new ListNode(-1);
//		ListNode cur = head;
//		while(cur!=null && cur.next!=null){
//			ListNode temp = dummy.next;
//			dummy.next = cur.next;
//			cur.next = cur.next.next;
//			dummy.next.next = temp;
//		}
//        return dummy.next;
        
        if(head==null || head.next==null)return head;
        ListNode dummy = new ListNode(-1);
        // head is the reverse part tail
        while(head.next!=null){
        	ListNode cur = head.next; // get a new one
        	ListNode reverse_head = dummy.next;
        	head.next = cur.next;
        	cur.next = reverse_head;
        	dummy.next = cur;
        }
        return dummy.next;
		
    }
	
	
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode cur = head;
		for(int i = 1;i<10;i++){
			ListNode next = new ListNode(i);
			cur.next = next;
			cur = next;
		}
		cur = head;
		while(cur!=null){
			System.out.print(cur.val+"-");
			cur = cur.next;
		}
		
		
		System.out.println("\nreverse");
		E206_ReverseLinkedList sol = new E206_ReverseLinkedList();
		head = sol.reverseList(head);
		cur = head;
		while(cur!=null){
			System.out.print(cur.val+"-");
			cur = cur.next;
		}
		
		
	}
}
