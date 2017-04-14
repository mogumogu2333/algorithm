package tree;


public class M117_NextRightPointer2 {
	public void connect(TreeLinkNode root) {
        if(root==null)return;
        TreeLinkNode next = null;
        if(root.next!=null)next = (root.next.left==null)?root.next.right:root.next.left;
//        {
//        	if(root.next.left==null || root.next.right==null)next = null;
//        	else if(root.next.left!=null)next = root.next.left;
//        	else if(root.right!=null)next = root.next.right;
//        }
        
		if(root.right!=null) root.right.next = next;
		if(root.left!=null) root.left.next = (root.right==null)?next:root.right;
		connect(root.right);
		connect(root.left);
    }
}
