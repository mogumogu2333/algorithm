package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal2 {
	// bottom up, use a linkedlist to record traversal result.
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null)return ret;
        queue.offer(root);
        while(!queue.isEmpty()){
        	List<Integer> subList = new ArrayList<>();
        	int levelSize = queue.size();
        	for(int i = 0;i<levelSize;i++){
        		TreeNode cur = queue.poll();
        		if(cur.left!=null)queue.offer(cur.left);
        		if(cur.right!=null)queue.offer(cur.right);
        		subList.add(cur.val);
        	}
        	ret.add(0, subList);
        }
        return ret;
    }
	
	//dfs
	public List<List<Integer>> levelOrderBottomV2(TreeNode root) {
		List<List<Integer>> ret = new LinkedList<>();
		if(root==null)return ret;
		dfs_helper(root, 1, ret);
		return ret;
	}
	
	private void dfs_helper(TreeNode root, int height, List<List<Integer>> ret){
		if(root==null)return;
		if(height > ret.size()){
			ret.add(0, new ArrayList<>());
		}
		ret.get(ret.size()-height).add(root.val);
		if(root.left!=null)dfs_helper(root.left, height+1, ret);
		if(root.right!=null)dfs_helper(root.right, height+1, ret);

	}
	
	public static void main(String[] args) {
		int[] preorder = new int[] {3,9,20,15,7};
		int[] inorder = new int[] {9,3,15,20,7 };

		BinaryTreeConstruction builder = new BinaryTreeConstruction();
		TreeNode root = builder.buildTree(preorder, inorder);
		
		LevelOrderTraversal2 sol= new LevelOrderTraversal2();
		List<List<Integer>> lists = sol.levelOrderBottomV2(root);
		for(List<Integer> list:lists){
			System.out.println(Arrays.toString(list.toArray()));
		}
	}

}
