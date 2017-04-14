package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M78_Subset {
	
	public List<List<Integer>> subsets(int[] nums) {
        if(nums==null)return null;
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
//        for(int len = 0; len<=nums.length;len++){
//        	backtracking(results, cur, 0, nums, len);
//        }
//        backtracking2(results, cur, 0, nums);
//        return results;
        return bitmap(nums);
    }
	
	private void backtracking(List<List<Integer>> results, List<Integer> cur, int start, int[] nums, int length){
		if(length==0){
			results.add(new ArrayList<>(cur));
			return;
		}
		for(int i = start;i<nums.length;i++){
			cur.add(nums[i]);
			backtracking(results, cur, i+1, nums,length-1);
			cur.remove(cur.size()-1);
		}
	}
	
	private void backtracking2(List<List<Integer>> results, List<Integer> cur, int start, int[] nums){
		results.add(new ArrayList<>(cur));
		for(int i = start;i<nums.length;i++){
			cur.add(nums[i]);
			backtracking2(results, cur, i+1, nums);
			cur.remove(cur.size()-1);
		}
	}
	
	private List<List<Integer>> bitmap(int[] nums){
		List<List<Integer>> results = new ArrayList<>();
		int bitnumber = nums.length;
		int totalset = 1<<(nums.length);
		for(int i = 0;i<totalset;i++){
			List<Integer> set = new ArrayList<>();
			for(int j = 0;j<bitnumber;j++){
				if((i & (1<<j))!=0){
					set.add(nums[j]);
				}
			}
			results.add(set);
		}
		
		return results;
	}
	
	public static void main(String[] args) {
		M78_Subset sol = new M78_Subset();
		int[] nums = new int[]{1,2,3};
		List<List<Integer>> results = sol.subsets(nums);
		for(List<Integer> result:results){
			System.out.println(Arrays.toString(result.toArray()));
		}
	}

}
