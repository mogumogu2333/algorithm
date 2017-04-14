package linkedlist;

public class RemoveNthEndNode_19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
        ListNode runner = dummy;
        for(int i = 0;i<n;i++){
        	if(runner!=null)runner = runner.next;
        	else return null;
        }
        
        ListNode cur = dummy;
        while(runner.next!=null){
        	cur = cur.next;
        	runner = runner.next;
        }
        
        //remove
        if(cur.next!=null)
        	cur.next = cur.next.next;
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
		
		System.out.println("remove");
		int val = 10;
		RemoveNthEndNode_19 solution = new RemoveNthEndNode_19();
		head = solution.removeNthFromEnd(head, val);
		
		cur = head;
		while(cur!=null){
			System.out.print(cur.val+"-");
			cur = cur.next;
		}
		
	}
}
