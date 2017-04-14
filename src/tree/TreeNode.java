package tree;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int x){this.val = x;}
	
	public TreeNode buildTree(){
		int[] list = new int[]{1,2,3,4,5,6,7,8,9,10};
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		
		return root;
	}
	
	public static void inorderTraverse(TreeNode root){
		if(root == null)return;
		
		inorderTraverse(root.left);
		System.out.println(root.val);
		inorderTraverse(root.right);
	}
	
	public static void preorderTraversal(TreeNode root){
		if(root == null)return;
		System.out.println(root.val);
		inorderTraverse(root.left);
		
		inorderTraverse(root.right);
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}
	
	

}
