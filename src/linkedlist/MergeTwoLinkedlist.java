package linkedlist;

public class MergeTwoLinkedlist {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        
		ListNode ans = new ListNode(-1);
        ListNode pointer = ans;
        
        while(l1!=null && l2!=null){
        	if(l1.val<=l2.val){
        		pointer.next = l1;
        		l1 = l1.next;
        	}
        	else if(l1.val > l2.val){
        		pointer.next = l2;
        		l2 = l2.next;
        	}
        	
        	//point to the tail of each merge.
        	//because pointer.next is set to l1 or l2.
        	//we must move pointer forward.
        	pointer = pointer.next;
        	
        }
        
        if(l1==null)pointer.next = l2;
        else if(l2==null) pointer.next=l1;
        
        return ans.next;
        
        
    }
}
