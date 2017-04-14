package linkedlist;

/**
 * Question: You are given two linked lists representing two non-negative
 * numbers. The digits are stored in reverse order and each of their nodes
 * contains a single digit. Add the two numbers and return it as a linked list.
 * Input: (2->4->3) + (5->6->4) Output: 7->0->8 #2
 * 
 * @author Shang
 *
 */
public class AddTwoNumbers {

	public ListNode addTwo(ListNode l1, ListNode l2) {
		
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		int carry = 0;
		ListNode dummyH = new ListNode(0);
		ListNode cur = dummyH;

		while(l1!=null || l2!=null){
		    int v1 = (l1!=null)?l1.val:0;
		    int v2 = (l2!=null)?l2.val:0;
		    
		    int val = v1+v2+carry;
		    cur.next = new ListNode(val%10);
		    carry = val/10;
		    cur = cur.next;
		    if(l1!=null)l1 = l1.next;
		    if(l2!=null)l2 = l2.next;
		}
		
		if(carry==1){
		    cur.next= new ListNode(1);
		}
		
		return dummyH.next;
	
		
	}

}
