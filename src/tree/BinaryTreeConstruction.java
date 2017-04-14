package tree;

public class BinaryTreeConstruction {

	// build from preorder and inorder
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int prestart = 0;
		int preend = preorder.length-1;
		int instart = 0;
		int inend = inorder.length-1;
		TreeNode root = constructTree(preorder, prestart, preend, inorder, instart, inend);
		return root;
	}
	
	

	private TreeNode constructTree(int[] preorder, int prestart, int preend, 
			int[] inorder, int instart, int inend) {
		if(prestart > preend || instart > inend)return null;
		
		int rootVal = preorder[prestart];
		TreeNode root = new TreeNode(rootVal);
		int rootPos = instart;
		for(int i = instart; i<inend+1;i++){
			if(inorder[i] == rootVal){
//				System.out.println(rootVal);
				rootPos = i;
				break;
			}
		}
		
		int leftLength = rootPos-instart;
		
		root.left = constructTree(preorder, prestart+1, prestart+leftLength, inorder, instart, rootPos-1);
		root.right = constructTree(preorder, prestart+leftLength+1, preend, inorder, rootPos+1, inend);
		
		return root;
		
	}
	
	

	public static void main(String[] args) {
		int[] preorder = new int[] { 1, 2, 4, 5, 3, 7, 6, 8 };
		int[] inorder = new int[] { 4, 2, 5, 1, 6, 7, 3, 8 };

		BinaryTreeConstruction sol = new BinaryTreeConstruction();
		TreeNode root = sol.buildTree(preorder, inorder);
		
		TreeNode.inorderTraverse(root);
	}

}
