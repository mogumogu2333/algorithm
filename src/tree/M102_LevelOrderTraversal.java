package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M102_LevelOrderTraversal {
	
	

	
	public List<List<Integer>> levelOrder(TreeNode root) {
		/*
		 * The basic idea is:
		 * use an array to save all the node to be visited.
		 * And use cur, max index of this level, max index of next level to maintain
		 * 
		 */
		List<List<Integer>> ret = new ArrayList<>();
		if(root==null) return ret;
		
		ArrayList<TreeNode> visit = new ArrayList<>();
		int cur = 0;
		visit.add(root);
		int this_level_max = 1;
		int next_level_max = 1;
		while(cur<this_level_max || this_level_max<next_level_max){
			ArrayList<Integer> this_level_vals = new ArrayList<>();
			while(cur<this_level_max){
				this_level_vals.add(visit.get(cur).val);
				if(visit.get(cur).left!=null){
					visit.add(visit.get(cur).left);
					next_level_max++;
				}
				if(visit.get(cur).right!=null){
					visit.add(visit.get(cur).right);
					next_level_max++;
				}
				cur++;
			}
			ret.add(this_level_vals);
			this_level_max = next_level_max;
			
		}
			
			
		return ret;
        
    }
	
	
	// bfs, queue solution
	public List<List<Integer>> levelOrderV2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> ret = new LinkedList<List<Integer>>();
		if(root == null )return ret;
		
		queue.offer(root);
		
		while(!queue.isEmpty()){
			int levelNum = queue.size();
			List<Integer> sublist = new ArrayList<>();
			for(int i = 0; i < levelNum; i++){
				
				if(queue.peek().left!=null)queue.offer(queue.peek().left);
				if(queue.peek().right!=null)queue.offer(queue.peek().right);
				sublist.add(queue.poll().val);
			}
			ret.add(sublist);
		}
		return ret;
	}
	
	//dfs
	public List<List<Integer>> levelOrderV3(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<>();
		if(root==null)return ret;
		dfs_helpder(root, 1, ret);
		return ret;
	}
	
	private void dfs_helpder(TreeNode root, int height, List<List<Integer>> ret){
		if(root==null)return;
		if(height > ret.size() ){ // level1 should have two elements in the ret list
			ret.add(new ArrayList<Integer>());
		}
		ret.get(height-1).add(root.val);
		dfs_helpder(root.left, height+1, ret);
		dfs_helpder(root.right, height+1, ret);
		
		
	}
	
	
	
	public static void main(String[] args) {
		int[] preorder = new int[] {3,9,20,15,7};
		int[] inorder = new int[] {9,3,15,20,7 };

		BinaryTreeConstruction builder = new BinaryTreeConstruction();
		TreeNode root = builder.buildTree(preorder, inorder);
		
		M102_LevelOrderTraversal sol= new M102_LevelOrderTraversal();
		List<List<Integer>> lists = sol.levelOrderV3(root);
		for(List<Integer> list:lists){
			System.out.println(Arrays.toString(list.toArray()));
		}
	}
}
