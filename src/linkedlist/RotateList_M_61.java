package linkedlist;

public class RotateList_M_61 {
	// Consider situation when k > len(list)
	// actual rotate position: k % len()
	public ListNode rotateRight(ListNode head, int k) {
		if(head==null)return head;
		ListNode dummy = new ListNode(-1);
        dummy.next = head;
		// get the list len
        ListNode runner = dummy;
        int length = 0;
        while(runner.next!=null){
            length++;
            runner = runner.next;
        }
        
        if(k%length!=0){
            int rotatePos = k%length;
            int left = length-rotatePos;
            ListNode p = dummy;
            while(left>0){
                p = p.next;
                left--;
            }
            runner.next = head;
            dummy.next = p.next;
            p.next = null;
            
        }
        return dummy.next;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5};
		ListNode head = new ListNode(-1);
		ListNode cur = head;
		for(int val:arr){
			cur.next = new ListNode(val);
			cur = cur.next;
		}
		
		//print out
		cur = head.next;
		while(cur!=null){
			System.out.print(cur.val+" ");
			cur = cur.next;
		}
		System.out.println();
		head = head.next;
		RotateList_M_61 sol = new RotateList_M_61();
		ListNode newh = sol.rotateRight(head, 6);
		
		cur = newh;
		while(cur!=null){
			System.out.print(cur.val+" ");
			cur = cur.next;
		}
		System.out.println();
		
		
	}
	
	
}
