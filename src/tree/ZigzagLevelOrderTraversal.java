package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<>();
		if(root==null)return ret;
		
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.add(root);
		
		int height = 1;
		while(!queue.isEmpty()){
			int levelNum = queue.size();
			List<Integer> curList = new ArrayList<>();
			
			for(int i = 0;i<levelNum;i++){
				TreeNode cur = queue.poll();
				if(cur.left!=null)queue.offer(cur.left);
				if(cur.right!=null) queue.offer(cur.right);
				if(height%2==1)curList.add(cur.val);
				else curList.add(0, cur.val);
			}
			height++;
			ret.add(curList);
		}
		return ret;
        
    }
	
	public static void main(String[] args) {
		int[] preorder = new int[] {3,9,20,15,7};
		int[] inorder = new int[] {9,3,15,20,7 };

		BinaryTreeConstruction builder = new BinaryTreeConstruction();
		TreeNode root = builder.buildTree(preorder, inorder);
		
		ZigzagLevelOrderTraversal sol= new ZigzagLevelOrderTraversal();
		List<List<Integer>> lists = sol.zigzagLevelOrder(root);
		for(List<Integer> list:lists){
			System.out.println(Arrays.toString(list.toArray()));
		}
	}
}
