package tree;


public class SumRootLeafNum {
	public int sumNumbers(TreeNode root) {
		if(root==null)return 0;
        return sumNumberDFSHelper(root, 0);
    }
	
	public int sumNumberDFSHelper(TreeNode root, int parentVal){
		int newVal = parentVal*10+root.val;
		
		if(root.left==null && root.right==null){
			return parentVal*10+root.val;
		}
		else{
			int sum = 0;
			if(root.left!=null){
				sum+=sumNumberDFSHelper(root.left, newVal);
			}
			if(root.right!=null){
				sum+=sumNumberDFSHelper(root.right, newVal);
			}
			return sum;
		}
		
	}
	
	public static void main(String[] args) {
		int[] preorder = new int[] {3,9,2,5,7};
		int[] inorder = new int[] {9,3,5,2,7 };

		BinaryTreeConstruction builder = new BinaryTreeConstruction();
		TreeNode root = builder.buildTree(preorder, inorder);
		
		SumRootLeafNum sol = new SumRootLeafNum();
		System.out.println(sol.sumNumbers(root));
	}
}
