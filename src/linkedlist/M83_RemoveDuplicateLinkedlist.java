package linkedlist;

public class M83_RemoveDuplicateLinkedlist {

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode cur = head;
        ListNode nt = head.next;
        while(cur!=null){
            if(nt==null)return head;
            if(cur.val!=nt.val){
                cur = nt;
                nt = nt.next;
            }
            else{
                while(nt!=null && cur.val==nt.val)nt = nt.next;
                if(nt==null){
                    cur.next = null;
                    return head;
                }
                else if(cur.val!=nt.val){
                    cur.next = nt;
                    cur = nt;
                    nt = nt.next;
                }
            }
        }
        return head;
    }

}
