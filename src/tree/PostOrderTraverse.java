package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraverse {
	
	
	// One stack, one prev node
	public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null)return new ArrayList<Integer>();
        List<Integer> ret = new ArrayList<>();
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        stack.push(root);
        while(!stack.isEmpty()){
            //down
            TreeNode cur = stack.peek(); // pick the top of stack as cur, everytime.
            
            // go down
            if(prev==null || prev.left == cur|| prev.right == cur){
                if(cur.left!=null)stack.push(cur.left); // find the left most, prev = cur.
                else if(cur.right!=null)stack.push(cur.right);
                else{ // leaf node. after this, prev = cur. next loop, cur ==stack.top, this should be a parent node.
                    ret.add(cur.val);
                    stack.pop();
                }
            }
            else if(cur.left == prev){
                if(cur.right!=null){
                    stack.push(cur.right);
                }
                else{
                    stack.pop();
                    ret.add(cur.val);
                }
            }
            else if(cur.right==prev){
                stack.pop();
                ret.add(cur.val);
            }
            
            prev = cur; //set prev as cur. and cur will be the top of stack in next loop
        }
       return ret; 
    }
	
	
	
	// use two stacks, add from first is the same idea
	// ret is actually a stack.
	public List<Integer> postorderTraversal2(TreeNode root) {
		
		ArrayList<Integer> ret = new ArrayList<>();
		if(root == null)return ret;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode cur = null;
		while(!stack.isEmpty()){
			cur = stack.pop();
			ret.add(0, cur.val);
			if(cur.left!=null)stack.push(cur.left);
			if(cur.right!=null) stack.push(cur.right);
			
		}
		return ret;
		
		
	}
	
	// recursive
	public List<Integer> postorderTraversal3(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<>();
		if(root==null)return ret;
		List<Integer>left_ret = postorderTraversal3(root.left);
		List<Integer>right_ret = postorderTraversal3(root.right);
		left_ret.addAll(right_ret);
		left_ret.add(root.val);
		return left_ret;
		
		
	}
	
	public void addArray(){
		ArrayList<Integer>l1 = new ArrayList<>();
		l1.add(1);
		l1.add(2);
		ArrayList<Integer>l2 = new ArrayList<>();
		l1.add(3);
		l1.add(4);
		l1.addAll(l2);
		
		System.out.println(Arrays.toString(l1.toArray()));
		
		
	}
	
	
	

	
	
	public static void main(String[] args) {
		int[] preorder = new int[] { 1,2};
		int[] inorder = new int[] { 1,2};

		BinaryTreeConstruction builder = new BinaryTreeConstruction();
		TreeNode root = builder.buildTree(preorder, inorder);
		
		PostOrderTraverse post = new PostOrderTraverse();
		List<Integer> postList = post.postorderTraversal(root);
		System.out.println(Arrays.toString(postList.toArray()));
		
		post.addArray();
	}

}
