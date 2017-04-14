package linkedlist;

public class RemoveDuplicatedSortedList {
	public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while(head!=null && head.next!=null){
        	if(head.val==head.next.val)head.next = head.next.next;
        	else{
        		head = head.next;
        	}
        }
        return dummy.next;
    }
	
	public static void main(String[] args) {
		
	}
	
}
