package linkedlist;

public class M92_ReverseLinkedList {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
        ListNode prev = dummy;
        
        for(int i = 1;i<m;i++)prev = prev.next;
        reverse_helper(prev, n-m);
        return dummy.next;
        
    }
	
	public ListNode reverse_helper(ListNode prev, int k){
		ListNode rtail = prev.next;
		ListNode rhead = null;
		ListNode cur = null;
		for(int i = 0;i<k;i++){
			cur = rtail.next;
			rhead = prev.next;
			
			prev.next = cur;
			rtail.next = cur.next;
			cur.next = rhead;
		}
		return rtail;
	}
	
	public static void main(String[] args) {
		ListNode dh = new ListNode(-1);
		ListNode cur = dh;
		for(int i = 1;i<6;i++){
			ListNode next = new ListNode(i);
			cur.next = next;
			cur = next;
		}
		cur = dh.next;
		while(cur!=null){
			System.out.print(cur.val+"-");
			cur = cur.next;
		}
		
		
		System.out.println("\nreverse");
		M92_ReverseLinkedList sol = new M92_ReverseLinkedList();
		ListNode head = sol.reverseBetween(dh.next, 3, 5);
		cur = head;
		while(cur!=null){
			System.out.print(cur.val+"-");
			cur = cur.next;
		}
	}
}
