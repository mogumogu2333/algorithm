package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
	//recursive
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> ret = new ArrayList<String>();
		if(root==null)return ret;
		if(root.left==null && root.right==null){
			ret.add(""+root.val);
			return ret;
		}
		List<String> l_ret;
		l_ret = (root.left==null)?new ArrayList<>():binaryTreePaths(root.left);
		List<String> r_ret = binaryTreePaths(root.right);
		for(String s :l_ret){
			ret.add(root.val+"->"+s);
		}
		for(String s :r_ret){
			ret.add(root.val+"->"+s);
		}
        return ret;
    }
	
	// non recursive
	
	
	
	
	public static void main(String[] args) {
		int[] preorder = new int[] { 1,2};
		int[] inorder = new int[] { 1,2};

		BinaryTreeConstruction builder = new BinaryTreeConstruction();
		TreeNode root = builder.buildTree(preorder, inorder);
		
		BinaryTreePath findPath = new BinaryTreePath();
		List<String> ret = findPath.binaryTreePaths(root);
		for(String s:ret){
			System.out.println(s);
		}
		
	}
}
