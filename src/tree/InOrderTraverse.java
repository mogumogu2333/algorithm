package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class InOrderTraverse {
	
	public List<Integer> inorder(TreeNode root){
		if(root==null)return null;
		List<Integer> ret = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode cur = root;
		while(!stack.isEmpty() || cur!=null){
			
		}
		
		return ret;
	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) return null;
        
        List<Integer> returnList = new ArrayList<>();
        List<TreeNode> stack = new ArrayList<>();
        int top = 0;
        while( root!=null || top>0){
        	if(root!=null){
        		stack.add(top++, root);
        		root = root.left;
        	}
        	else{
        		root = stack.get(--top);
        		returnList.add(root.val);
        		root = root.right;
        	}
        }
        return returnList;
        
    }
	
//	public List<Integer> MorrisInorderTraversal(TreeNode root){
//		List<Integer> ret = new ArrayList<>();
//		if(root==null)return ret;
//		TreeNode prev = null;
//		TreeNode cur = root;
//		
//	}
	
	public static void main(String[] args) {
		int[] preorder = new int[] {1,2,3};
		int[] inorder = new int[] { 1,3,2 };

		BinaryTreeConstruction builder = new BinaryTreeConstruction();
		TreeNode root = builder.buildTree(preorder, inorder);
		
		InOrderTraverse traverse = new InOrderTraverse();
		List<Integer> returnList= traverse.inorder(root);
		
		System.out.println(Arrays.toString(returnList.toArray()));
		
		
		
	}

}
