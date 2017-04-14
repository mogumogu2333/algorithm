package linkedlist;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

	For example,
	Given 1->2->3->3->4->4->5, return 1->2->5.
	Given 1->1->1->2->3, return 2->3.
 * @author Shang
 *
 */
public class M82_RemoveDuplicatedSortedList {
	public ListNode deleteDuplicates(ListNode head) {
        
        if(head==null || head.next==null)return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy, cur = head, nt = head.next;
        while(cur!=null){
            if(nt==null)return dummy.next;
            if(nt.val!=cur.val){
            	pre = cur;
                cur = nt;
                nt = nt.next;
                continue;
            }
            else{
                while(nt!=null && nt.val==cur.val)nt = nt.next;
                if(nt==null){
                    pre.next = nt;
                    return dummy.next;
                }
                else{
                    pre.next = nt;
                    cur = nt;
                    nt = nt.next;
                }
            }
        }
        return dummy.next;
    
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,2};
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
		
		M82_RemoveDuplicatedSortedList sol = new M82_RemoveDuplicatedSortedList();
		ListNode ret = sol.deleteDuplicates(head.next);
		cur = ret;
		while(cur!=null){
			System.out.println(cur.val);
			cur = cur.next;
		}
	}
}
