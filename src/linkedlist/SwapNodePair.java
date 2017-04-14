package linkedlist;

public class SwapNodePair {
	public ListNode swapPairs(ListNode head) {
		if(head==null || head.next==null)return head;
		
		ListNode pointer = head;
		while(pointer!=null && pointer.next!=null){
			ListNode next = pointer.next;
			pointer.next = next.next;
			next.next = pointer;
			pointer = pointer.next;
		}
		
		return head;
        
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
		
		SwapNodePair solution = new SwapNodePair();
		head = solution.swapPairs(head);
		System.out.println();
		cur = head;
		while(cur!=null){
			System.out.print(cur.val+"-");
			cur = cur.next;
		}
		
	}
}
