package linkedlist;

public class RemoveLinkedlistVal {
	
    public ListNode removeElements(ListNode head, int val) {
    	
    	if(head==null)return null;
    	
    	ListNode dummyhead = new ListNode(-1);
    	dummyhead.next = head;
    	
    	ListNode runner = dummyhead;
    	
    	while(runner.next!=null){
    		if(runner.next.val==val){
    			runner.next = runner.next.next;
    		}
    		else{
    			runner = runner.next;
    		}
    	}
    	
    	return dummyhead.next;
        
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
		int val = 0;
		RemoveLinkedlistVal solution = new RemoveLinkedlistVal();
		head = solution.removeElements(head, val);
		
		cur = head;
		while(cur!=null){
			System.out.print(cur.val+"-");
			cur = cur.next;
		}
		
	}
}
