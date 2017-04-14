package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
	
	public List<Integer> preorder(TreeNode root){
		if(root==null)return null;
		List<TreeNode> stack = new ArrayList<>();
		List<Integer> returnlist = new ArrayList<>();
		int top = 0;
		
		while(root!=null || top >0){
			if(root!=null){
				returnlist.add(root.val);
				if(root.right!=null) stack.add(top++, root.right);
				root = root.left;
			}
			else{
				root = stack.get(--top);
			}
			
		}
		return returnlist;
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		/**
		 * Use a stack.
		 * Everytime, pop top element in stack to cur.
		 * Push right child to stack if not null
		 * push left child to stack if not null
		 */
		
		List<Integer> returnList = new ArrayList<>();
		
		if(root==null)return returnList;
		

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode cur = stack.pop();
			returnList.add(cur.val);
			if(cur.right!=null)stack.push(cur.right);
			if(cur.left!=null)stack.push(cur.left);
		}
		
		return returnList;
        
    }

	
	public static void main(String[] args) {
		int[] preorder = new int[] { 1, 2, 4, 5, 3, 7, 6, 8 };
		int[] inorder = new int[] { 4, 2, 5, 1, 6, 7, 3, 8 };

		BinaryTreeConstruction builder = new BinaryTreeConstruction();
		TreeNode root = builder.buildTree(preorder, inorder);
		
		PreOrderTraversal traverse = new PreOrderTraversal();
		List<Integer> returnList= traverse.preorderTraversal(root);
		
		System.out.println(Arrays.toString(returnList.toArray()));
		
	}
}
