package linkedlist;

public class SwapNodePair_24 {
	public ListNode swapPairs(ListNode head) {
        // -1-2-3-4
		// h->n = h->n-n
		//
		//
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		if(head==null || head.next==null)return head;
		ListNode pre = dummy;
		while(head!=null && head.next!=null){
			pre.next = head.next;
			head.next = pre.next.next;
			pre.next.next = head;
			
			pre = head;
			head = head.next;
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
		System.out.println();
		SwapNodePair_24 sol = new SwapNodePair_24();
		head = sol.swapPairs(head);
		cur = head;
		while(cur!=null){
			System.out.print(cur.val+"-");
			cur = cur.next;
		}
				
	}

}
