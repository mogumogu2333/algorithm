package tree;



public class M116_NextRightPointer {
	public void connect(TreeLinkNode root) {
	    
		if(root==null)return;
//		if(root.next==null){
//			//right
//			if(root.right!=null){
//				root.right.next = null;
//			}
//			if(root.left!=null){
//				root.left.next = root.right;
//			}
//		}
//		else{
//			//left
//			if(root.right!=null){
//				root.right.next = root.next.left;
//			}
//			if(root.left!=null){
//				root.left.next = root.right;
//			}
//		}
		if(root.right!=null)
			root.right.next = (root.next!=null)?root.next.left:null;
		if(root.left!=null)
			root.left.next = root.right;
		connect(root.left);
		connect(root.right);
        
    
	    
	}
	
//	private void connectNext(TreeLinkNode root){
//		if(root==null)return;
//		if(root.next==null){
//			//right
//			if(root.right!=null){
//				root.right.next = null;
//			}
//			if(root.left!=null){
//				root.left.next = root.right;
//			}
//		}
//		else{
//			//left
//			if(root.right!=null){
//				root.right.next = root.next.left;
//			}
//			if(root.left!=null){
//				root.left.next = root.right;
//			}
//		}
//		connectNext(root.left);
//		connectNext(root.right);
//	}
}
