package tree;

public class LowestCommonAncesterBST {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null)return null;
        if(root.val>=Math.min(p.val, q.val) && root.val<=Math.max(p.val, q.val))return root;
        else if(root.val > Math.max(p.val, q.val)){
        	return lowestCommonAncestor(root.left, p, q);
        }
        else{
        	return lowestCommonAncestor(root.right, p, q);
        }
        
    }
	
	public TreeNode lowestCommonAncestorNonRecur(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null)return null;
		
		int min = Math.min(p.val, q.val);
		int max = Math.max(p.val, q.val);
		
		TreeNode cur = root;
		while(cur!=null){
			if(cur.val>=min && cur.val<=max)return cur;
			else if(cur.val>max)cur = cur.left;
			else if(cur.val<min)cur = cur.right;
		}
		return null;
        
    }

}
