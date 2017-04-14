package tree;


public class BTMaxPathSum {
	int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		if(root==null)return 0;
        if(root.left==null && root.right==null)return root.val;
        max_dfs_helper(root);
        
        return this.max;
        
    }
	
	public int max_dfs_helper(TreeNode root){
		if(root==null)return 0;
		
        int left_max = Math.max(0, max_dfs_helper(root.left));
        int right_max = Math.max(0, max_dfs_helper(root.right));
        
        int sum = root.val + left_max + right_max;
        if(sum > this.max)this.max = sum;
        
        return Math.max(root.val, Math.max(left_max, right_max) + root.val);
	}
	
	
	public static void main(String[] args) {
//		int[] preorder = new int[] {5,4,11,7,2,8,13,4,5,1};
//		int[] inorder = new int[] {7,11,2,4,5,13,8,5,4,1};
//		int[] preorder = new int[] {3,9,2,5,7};
//		int[] inorder = new int[] {9,3,5,2,7 };
		int[] preorder = new int[] {-2,1};
		int[] inorder = new int[] {1,-2};
//		int[] preorder = new int[]{1,1,15,15,1};
//		int[] inorder = new int[]{15,1,15,1,1};
		

		BinaryTreeConstruction builder = new BinaryTreeConstruction();
		TreeNode root = builder.buildTree(preorder, inorder);
		
		BTMaxPathSum sol = new BTMaxPathSum();
		System.out.println(sol.maxPathSum(root));
	}
}
