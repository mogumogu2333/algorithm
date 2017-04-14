package tree;

public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        if(root.left==null && root.right==null)return root;
        
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }
	
	public static void main(String[] args) {
		int[] preorder = new int[] { 1, 2, 4, 5, 3, 7, 6, 8 };
		int[] inorder = new int[] { 4, 2, 5, 1, 6, 7, 3, 8 };

		BinaryTreeConstruction sol = new BinaryTreeConstruction();
		TreeNode root = sol.buildTree(preorder, inorder);
		
		TreeNode.inorderTraverse(root);
		
		InvertBinaryTree inverter = new InvertBinaryTree();
		root = inverter.invertTree(root);
		
		TreeNode.inorderTraverse(root);
	}
}
