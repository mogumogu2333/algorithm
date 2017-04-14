package linkedlist;

public class SortList {
	public ListNode sortList(ListNode head) {
		if(head==null || head.next==null)return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        fast = slow.next;
        slow.next=null;
        
        
        ListNode left = sortList(head);
        ListNode right = sortList(fast);
        return merge(left,right);
    }
	
	public ListNode merge(ListNode l1, ListNode l2){
		if(l1==null && l2==null)return null;
		else if(l1==null)return l2;
		else if(l2==null)return l1;
		ListNode dummy = new ListNode(-1);
		ListNode walker = dummy;
		while(l1!=null && l2!=null){
			if(l1.val <= l2.val){
				walker.next = l1;
				l1 = l1.next;
			}
			else{
				//l1 > l2
				walker.next = l2;
				l2 = l2.next;
			}
			walker = walker.next;
		}
		if(l1!=null )walker.next = l1;
		else if(l2!=null)walker.next = l2;
		return dummy.next;
	}
	
	public static void main(String[] args) {
		int[] list = new int[]{3,2,4};
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		for(int num:list){
			p.next = new ListNode(num);
			p = p.next;
		}
		
//		while(dummy.next!=null){
//			System.out.println(dummy.next.val);
//			dummy = dummy.next;
//		}
		
		SortList sol = new SortList();
		ListNode newhead = sol.sortList(dummy.next);
		while(newhead!=null){
			System.out.println(newhead.val);
			newhead = newhead.next;
		}
	}

}
