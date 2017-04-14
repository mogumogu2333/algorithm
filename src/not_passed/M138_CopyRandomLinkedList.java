package not_passed;
//package linkedlist;

import java.util.HashMap;

public class M138_CopyRandomLinkedList {
	public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> table = new HashMap<>();
        RandomListNode p = head;
        while(p!=null){
        	RandomListNode node = new RandomListNode(p.label);
        	table.put(p, node);
        	p = p.next;
        }
        
        RandomListNode dummyHead = new RandomListNode(0), q = dummyHead;
        p = head;
        while(p!=null){
        	table.get(p).next = table.get(p.next);
        	table.get(p).random = table.get(p.random);
        	q.next = table.get(p);
        	q = q.next;
        	p = p.next;
        }
        return dummyHead.next;
    }
	
	public RandomListNode copyRandomList_2(RandomListNode head){
		// TODO: this solution not AC code 
		RandomListNode p = head;
		// first round, copy lable
		while(p!=null){
			RandomListNode copy = new RandomListNode(p.label);
			copy.next = p.next;
			p.next = copy;
			p = copy.next;
		}
		
		// assign next and random pointer
		p = head;
		while(p.next!=null){
			RandomListNode copy = p.next;
			if(p.random!=null)copy.random = p.random.next;
			p = p.next.next;
		}
		
		// get return
		RandomListNode dummyHead = new RandomListNode(0), q = dummyHead;
		p = head;
		while(p.next!=null){
			RandomListNode copy = p.next;
			p = p.next.next;
			copy.next = p.next;
			q.next = copy;
			q = q.next;
		}
		return dummyHead.next;
	}
}




class RandomListNode{
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
}