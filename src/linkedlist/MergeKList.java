package linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;


public class MergeKList {
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists==null || lists.length==0)return null;
		PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
		
		for(ListNode h: lists){
			if(h!=null)heap.add(h);
		}
		
		if(heap.isEmpty())return null;
		
		ListNode result = heap.poll();
		if(result.next!=null)heap.add(result.next);
		ListNode cur = result;
		
		while(!heap.isEmpty()){
			cur.next = heap.poll();
			cur = cur.next;
			if(cur.next!=null)
				heap.add(cur.next);
		}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		ListNode[] lists = new ListNode[3];
		lists[0] = ListNode.fromArray(new int[]{1,3,5,6,7});
		lists[1] = ListNode.fromArray(new int[]{2,4,8});
		lists[2] = ListNode.fromArray(new int[]{9,10,11});
		
		MergeKList sol = new MergeKList();
		ListNode h = sol.mergeKLists(lists);
		ListNode.printAll(h);
		
		
	}
}

class ListNodeComparator implements Comparator<ListNode>{

	@Override
	public int compare(ListNode o1, ListNode o2) {
		return Integer.compare(o1.val, o2.val);
	}
	
}




