package tree;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null)return false;
		int sub = sum-root.val;
		if(root.left==null && root.right==null && sub==0)return true;
		boolean bleft = hasPathSum(root.left, sub);
		boolean bright = hasPathSum(root.right, sub);
		
		if((bleft&&bright)==false)return hasPathSum(root.left, sub)||hasPathSum(root.right, sub);
		else return bleft&&bright;
    }
	

}
