package tree;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        int lr = getHeight(root.left);
        int rh = getHeight(root.right);
        if(lr==-1 || rh==-1)return false;
        if(Math.abs(lr-rh)>1)return false;
        else return true;
    }
	
	private int getHeight(TreeNode root){
		if(root==null)return 0;
		
		if(root.left==null && root.right==null)return 1;
		
		int lh = getHeight(root.left);
		int rh = getHeight(root.right);
		if(lh==-1 || rh==-1)return -1;
		if(Math.abs(lh-rh) >1)return -1;
		if(lh <= rh)return rh+1;
		else return lh+1;
	}
	
	public static void main(String[] args) {
		int[] preorder = new int[] {1,4,3,2,2,3,4};
		int[] inorder = new int[] {4,3,2,1,2,3,4};

		BinaryTreeConstruction builder = new BinaryTreeConstruction();
		TreeNode root = builder.buildTree(preorder, inorder);
		
		BalancedBinaryTree isBalance = new BalancedBinaryTree();
		System.out.println(isBalance.isBalanced(root));
	}

}
