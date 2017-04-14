package linkedlist;

public class H25_ReverseListKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
	    
		ListNode dh = new ListNode(-1);
		dh.next = head;
		ListNode start = dh;
		while(start!=null){
			start = reverse_helper(start, k);
		}
		return dh.next;
	}
	
	public ListNode reverse_helper(ListNode prev, int k){
		if(prev == null || prev.next==null)return null;
		ListNode nk = prev;
		for(int i = 0;i<k & nk!=null;i++)nk = nk.next;
		if(nk==null)return null;
		
		
		ListNode cur = null;
		ListNode rh = null;
		ListNode rt = prev.next;
		for(int i = 1;i<k & rt.next!=null;i++){
			cur = rt.next;
			rh = prev.next;
			
			prev.next = cur;
			rt.next = cur.next;
			cur.next = rh;
		}
		return rt;
	}
	
	public static void main(String[] args) {
		ListNode dh = new ListNode(-1);
		ListNode cur = dh;
		for(int i = 1;i<7;i++){
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
		H25_ReverseListKGroup sol = new H25_ReverseListKGroup();
		ListNode head = sol.reverseKGroup(dh.next, 4);
		cur = head;
		while(cur!=null){
			System.out.print(cur.val+"-");
			cur = cur.next;
		}
	}
}
