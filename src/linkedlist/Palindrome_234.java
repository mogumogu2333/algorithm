package linkedlist;

public class Palindrome_234 {
	
	// reverse list 
	public boolean isPalindrome(ListNode head) {
		if(head==null || head.next==null)return true;
		
        ListNode mid = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
        	mid = mid.next;
        	fast = fast.next.next;
        }
        
        ListNode p = reverse(mid.next);
        
        while(p!=null && head!=null){
        	if(p.val!=head.val)return false;
        	p = p.next;
        	head = head.next;
        }
        return true;
        
        
    }
	
	public ListNode reverse(ListNode h){
		ListNode prev = null;
		ListNode cur = h;
		ListNode next;
		while(cur!=null){
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,1,2,1};
		ListNode head = new ListNode(-1);
		ListNode cur = head;
		for(int val:arr){
			cur.next = new ListNode(val);
			cur = cur.next;
		}
		
		//print out
		cur = head;
		while(cur!=null){
			System.out.println(cur.val);
			cur = cur.next;
		}
		
		Palindrome_234 sol = new Palindrome_234();
		System.out.println(sol.isPalindrome(head.next));
	}
}
