package tree;

public class ConvertSortedArrayBST {
	public TreeNode sortedArrayToBST(int[] nums) {
		return toBSTHelper(nums, 0, nums.length-1);
        
    }
	
	private TreeNode toBSTHelper(int[] nums, int start, int end){
		if(start > end)return null;
		if(start == end) return new TreeNode(nums[start]);
		int m = start + (end-start)/2;
		TreeNode root = new TreeNode(nums[m]);
		root.left = toBSTHelper(nums, start, m-1);
		root.right = toBSTHelper(nums, m+1, end);
		return root;
	}
}
