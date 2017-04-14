package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M90_Subset2 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums==null)return null;
        List<List<Integer>> results = new ArrayList<>();
        if(nums.length==0)return results;
        Arrays.sort(nums);
        List<Integer> cur = new ArrayList<>();
        backtracking(nums, cur, 0, results);
        return results;
    }
	
	private void backtracking(int[] nums, List<Integer> cur, int start, List<List<Integer>> results){
		results.add(new ArrayList<>(cur));
		for(int i = start;i<nums.length;i++){
			if(i>start && nums[i-1] == nums[i])continue;// duplicate, skip
			cur.add(nums[i]);
			backtracking(nums, cur, i+1, results);
			cur.remove(cur.size()-1);
		}
	}
	
	public static void main(String[] args) {
		M90_Subset2 sol = new M90_Subset2();
		int[] nums = new int[]{1,2,2};
		
		List<List<Integer>> results = sol.subsetsWithDup(nums);
		for(List<Integer> result : results){
			System.out.println(Arrays.toString(result.toArray()));
		}
	}

}
