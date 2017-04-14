package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

public class UniqleBST2 {
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> ret = new ArrayList<>();
		if(n==0)return ret;
        return gen(1,n);
    }
	
	public List<TreeNode> gen(int start, int end){
		List<TreeNode> retList = new ArrayList<>();
		if(start > end){
		    retList.add(null);
		    return retList;
		}
		if(start == end){
			retList.add(new TreeNode(start));
			return retList;
		}
		
		//start < end
		for(int i = start; i<=end;i++){
			
			List<TreeNode> ltrees = gen(start,i-1);
			List<TreeNode> rtrees = gen(i+1, end);
			
			for(TreeNode lnode:ltrees){
				
				for(TreeNode rnode:rtrees){
				    TreeNode root = new TreeNode(i);
					root.left = lnode;
					root.right=rnode;
					retList.add(root);
				}
			}
		}
		return retList;
		
	}
		
}
