package tree;

public class ValidateBinarySearchTree {
//	public boolean isValidBST(TreeNode root) {
//		if(root==null)return true;
//		if(root.left==null && root.right==null)return true;
//		
//		if(root.left!=null && root.left.val >= root.val)return false;
//		if(root.right!=null && root.right.val<=root.val)return false;
//		
//		return isValidBST(root.left) && isValidBST(root.right);
//		
//		
//        
//    }
	
	public boolean isValidBST(TreeNode root) {
		return helper(root, null, null);
    }
	
	public boolean helper(TreeNode root, Integer min, Integer max){
		if(root==null)return true;
		if((min!=null && root.val<=min)||(max!=null && root.val>=max))return false;
		return helper(root.left, min, root.val) && helper(root.right,root.val,max);
	}
}
