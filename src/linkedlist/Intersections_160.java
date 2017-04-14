package linkedlist;



public class Intersections_160 {
	
	
	/**
	 * 思路：
	 * 1. 让两个list一样长（从intersect处向前，一样长，那么两个walker遍历的时候就可以相遇
	 * 两个walker分别遍历两个list
	 * 先到null是shorter one
	 * 再取一个指针指向长list的head，这个head和长list的walker一起走，当walker到null的时候，head就是，两个list一样长的头了
	 * 2. 遍历，相遇点就是intersect
	 * 
	 * 注意一些细节，比如，两个list一样长
	 * 
	 * (deprecated solution)
	 * 思路是：将一个linkedlist接到另一个list的尾部。如果两个linkedlist有intersection，那么新的Linkedlist一定有环。
	 * 所以问题就变成判断一个链表是否存在环, 找出环的起始位置。
	 * 
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)return null;
        
        ListNode a = headA;
        ListNode b = headB;
        while(a!=null && b!=null){
        	a = a.next;
        	b = b.next;
        }
        // a==null=> l1 shorter
        ListNode sameLenHead;
        ListNode c;
        ListNode walker; 
        
        
        //len(a)=len(b)
        if(a==null && b==null){
        	while(headA!=null && headB!=null && headA!=headB){
        		headA = headA.next;
        		headB = headB.next;
        	}
        	return headA;
        }
        else if(a==null){ // len(a)<len(b)
        	sameLenHead = headB;
        	c = headA;
        	walker = b;
        }
        else{ //len(a)>len(b)
        	sameLenHead = headA;
        	c = headB;
        	walker = a;
        }
        
        // walker to the end of longer list,
        // make two list same length from right,
        while(walker!=null){
        	walker = walker.next;
        	sameLenHead = sameLenHead.next;
        }
        
        while(sameLenHead!=null && c!=null && sameLenHead!=c){
        	sameLenHead = sameLenHead.next;
        	c = c.next;
        }
        return c;
    }

}
