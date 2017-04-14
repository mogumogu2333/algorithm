package tree;

import java.util.Stack;

public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null && q==null) return true;
		if(p==null || q==null) return false;
		
		Stack<TreeNode> pstack = new Stack<>();
		Stack<TreeNode> qstack = new Stack<>();
		
		
		//write p traversal non-recursive, inorder
		while(p!=null || pstack.size()>0){
			
			if(p!=null){
				if(q==null) return false;
				
				if(p.val!=q.val)return false;
				
				pstack.push(p.right);
				p = p.left;
				qstack.push(q.right);
				q = q.left;
			}
			else{
				
				if(q!=null)return false;
				
				p = pstack.pop();
				q = qstack.pop();
			}
		}
		
		return true;
		
	}
	
	public boolean isSameTree_recur(TreeNode p, TreeNode q) {
		if(p==null && q==null) return true;
		else if(p==null || q==null)return false;
		
		if(p.val!=q.val)return false;
		else return isSameTree_recur(p.left,q.left) && isSameTree_recur(p.right,q.right);
	}

	
	
	public static void main(String[] args) {
		int[] preorder = new int[] { 1, 2, 4, 5, 3, 7, 6, 8 };
		int[] inorder = new int[] { 4, 2, 5, 1, 6, 7, 3, 8 };


		BinaryTreeConstruction builder = new BinaryTreeConstruction();
		TreeNode p = builder.buildTree(preorder, inorder);
		
		TreeNode q = builder.buildTree(preorder, inorder);
		
		SameTree sol = new SameTree();
		boolean isSame = sol.isSameTree(p, q);
		
		System.out.println(isSame);

	}
	
	

}
