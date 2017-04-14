package tree;

import java.util.Stack;

public class SymmetricTree {
	
	//recursive
	public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        return isMirror(root.left,root.right);
        
    }
	
	public boolean isMirror(TreeNode left, TreeNode right){
		if(left==null && right==null)return true;
		if(left==null || right==null)return false;
		return (left.val==right.val) && isMirror(left.left,right.right) && isMirror(left.right, right.left);
	}
	
	
	//non-recursive
	public void inorder(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode cur = stack.peek();
			
		}
	}

}
