package cc.ch2;

import java.util.HashSet;

import linkedlist.ListNode;

public class RemoveDuplicates {
	/**
	 * Remove duplicates from unsorted linkedlist
	 */
	
	public static void removeDuplicates(ListNode h){
		//with buffer
		HashSet<Integer> checker = new HashSet<>();
		ListNode prev = new ListNode(0);
		prev.next = h;
		while(prev.next!=null){
			if(checker.contains(prev.next.val)){
				prev.next = prev.next.next;
			}else{
				checker.add(prev.next.val);
				prev = prev.next;
			}
		}
	}
	
	public static void removeDuplicates_nobf(ListNode h){
		//without buffer
		if(h==null || h.next==null)return;
		ListNode prev = new ListNode(0);
		prev.next = h;
		ListNode walker;
		while(prev.next!=null){
			int val = prev.next.val;
			walker = prev.next.next;
			while(walker!=null){
				if(walker.val==val){
					
				}
				else{
					walker = walker.next;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{4,1,2,4,1,2};
		ListNode dummyHead = new ListNode(0);
		ListNode cur = dummyHead;
		for(int num:nums){
			cur.next = new ListNode(num);
			cur = cur.next;
		}
		
		RemoveDuplicates.removeDuplicates_nobf(dummyHead.next);
		
		dummyHead = dummyHead.next;
		while(dummyHead!=null){
			System.out.println(dummyHead.val);
			dummyHead = dummyHead.next;
		}
	}

}
