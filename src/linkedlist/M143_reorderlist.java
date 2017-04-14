package linkedlist;

public class M143_reorderlist {
	
	

    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)return;
        ListNode p1=head, p2 = head.next;
        while(p2!=null && p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        ListNode mid = p1;
        ListNode midNext = p1.next;
        ListNode cur = midNext.next;
        while(cur!=null){
            midNext.next = cur.next;
            cur.next = midNext;
            mid.next = cur;
            cur = midNext.next;
        }
        
        p1 = head;
        p2 = mid.next;
        while(p2!=null){
            mid.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = mid.next;
        }
    }

    public static void main(String[] args) {
    	int[] arr = new int[]{1,2,3,4,5};
		ListNode head = new ListNode(-1);
		ListNode cur = head;
		for(int val:arr){
			cur.next = new ListNode(val);
			cur = cur.next;
		}
		head = head.next;
		
		//print out
		cur = head;
		while(cur!=null){
			System.out.print(cur.val+" ");
			cur = cur.next;
		}
		System.out.println();
		
		M143_reorderlist sol = new M143_reorderlist();
		sol.reorderList(head);
		
		//print out
		cur = head;
		while(cur!=null){
			System.out.print(cur.val+" ");
			cur = cur.next;
		}
		System.out.println();
	}

}
