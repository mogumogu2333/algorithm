package dynamic_programming;

import tree.TreeNode;

public class HouseRobber {
	public int rob10(int[] nums) {
		if(nums==null || nums.length==0)return 0;
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 1;i<nums.length;i++){
        	dp[i+1] = Math.max(dp[i-1]+nums[i], dp[i]);
        }
        return dp[nums.length];
    }
	
	// House robber 1: solution2
	public int rob11(int[] nums) {
		if(nums==null || nums.length==0)return 0;
        int m0 = 0;
        int m1 = nums[0];
        int m2 = 0;
        for(int i = 1; i < nums.length;i++){
        	m2 = Math.max(m0+nums[i], m1);
        	m0 = m1;
        	m1 = m2;
        }
        return m1;
    }
	
	// house robber 2: circular array
	// add constrain, that first and last cannot be robber together
	public int rob20(int[] nums) {
		if(nums==null || nums.length==0)return 0;
		if(nums.length==1)return nums[0];
		int m1 = rob_helper(nums, 0, nums.length-2);
		int m2 = rob_helper(nums, 1, nums.length-1);
		return Math.max(m1, m2);
        
    }
	private int rob_helper(int[] nums, int lo, int hi){
		if(lo==hi)return nums[lo];
        int m0 = 0, m1 = 0, m = 0;
        for(int i = lo; i<=hi;i++){
        	m = Math.max(m0+nums[i], m1);
        	m0 = m1;
        	m1 = m;
        }
        return m;
	}
	
	// house robber 3: binary tree, cannot rob two linked nodes
//	public int rob30(TreeNode root) {
//        if(root==null)return 0;
//        if(root.left==null && root.right==null)return root.val;
//    }
	
	
	
	public static void main(String[] args) {
		HouseRobber hr = new HouseRobber();
		int[] nums = new int[]{3,5,1};
		System.out.println(hr.rob11(nums));
	}
}
