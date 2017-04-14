package linkedlist;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) { val = x; }
	
	public static ListNode fromArray(int[] array){
		ListNode head = new ListNode(-1);
		ListNode curr = head;
		for(int element:array){
			ListNode cur = new ListNode(element);
			curr.next = cur;
			curr = curr.next;
		}
		return head.next;
	}
	
	public static void printAll(ListNode head){
		while(head!=null){
			System.out.print(head.val+" ");
			head = head.next;
		}
		System.out.println();
	}
}


