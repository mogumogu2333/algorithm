package tree;

public class BinaryTreeConstruction2 {
	
	public TreeNode constructTree(int[] inorder, int instart, int inend, 
			int[] postorder, int poststart, int postend){
		
		if(instart > inend || poststart > postend) return null;
		
		int rval = postorder[postend];
		
		TreeNode root = new TreeNode(rval);
		
		int k = -1;
		for(int i = instart; i<=inend; i++){
			if(inorder[i]==rval){
				k = i;
				break;
			}
		}
		System.out.println("k="+k);
		
		int len = k-instart;
		root.left = constructTree (inorder, instart, k-1, postorder, poststart, poststart+len-1);
		root.right = constructTree(inorder, k+1, inend, postorder, poststart+len, postend-1);
		
		return root;
		
		
		
	}
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder==null)return null;
		
		int len = inorder.length;
		
		if(len==0)return null;
		
        TreeNode root = constructTree(inorder, 0, len-1, postorder, 0, len-1);
        
        return root;
        
        
    }
	
	
	
	public static void main(String[] args) {
//		int[] inorder = new int[] { 4, 2, 5, 1, 6, 7, 3, 8 };
//		int[] postorder = new int[]{4, 5, 2, 6, 7, 8, 3, 1 };
//		
		
		int[] inorder = new int[] { 1,3,2 };
		int[] postorder = new int[]{3,2,1 };
		
		
		BinaryTreeConstruction2 sol = new BinaryTreeConstruction2();
		TreeNode root = sol.buildTree(inorder, postorder);
		
		TreeNode.inorderTraverse(root);
		
	}
}
