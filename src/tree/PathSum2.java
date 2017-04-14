package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathSum2 {
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ret = new ArrayList<>();
		if(root==null)return ret;
		List<Integer> parent_path = new ArrayList<>();
		dfs(root, sum, ret,parent_path);
		return ret;
		
		
    }
	
	public void dfs(TreeNode root, int sub, List<List<Integer>> ret, List<Integer> parent_path){
		if(root==null)return;
		List<Integer> path = new ArrayList<>();
		path.addAll(parent_path);
		path.add(root.val);
		sub = sub-root.val;
		if(root.left==null && root.right==null){
			if(sub==0){
				ret.add(path);
				return;
			}
			else return;
		}
		
		dfs(root.left, sub, ret, path);
		dfs(root.right, sub, ret, path);
		
	}
	
	public static void main(String[] args) {
		int[] preorder = new int[] {5,4,11,7,2,8,13,4,5,1};
		int[] inorder = new int[] {7,11,2,4,5,13,8,5,4,1};
//		int[] preorder = new int[] {3,9,2,5,7};
//		int[] inorder = new int[] {9,3,5,2,7 };

		BinaryTreeConstruction builder = new BinaryTreeConstruction();
		TreeNode root = builder.buildTree(preorder, inorder);
		
		PathSum2 sol = new PathSum2();
		List<List<Integer>> ret = sol.pathSum(root, 22);
		for(List<Integer> l : ret){
			System.out.println(Arrays.toString(l.toArray()));
		}
	}
	
	

}
