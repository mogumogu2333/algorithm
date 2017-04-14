package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M39_CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if(candidates==null)return null;
		List<List<Integer>> ret = new ArrayList<>();
		if(candidates.length==0)return ret;
		Arrays.sort(candidates);
		List<Integer> selected = new ArrayList<>();
		backtracking(ret, 0, selected, candidates, target);
		return ret;
    }
	
	public void backtracking(List<List<Integer>> results, int pos, List<Integer> selected, int[] candidates, int dev){
		if(dev==0){
			results.add(new ArrayList<>(selected));
		}
		if(dev<0)return;
		for(int i = pos;i<candidates.length;i++){
			int candidate = candidates[i];
			if(candidate <= dev){
				selected.add(candidate);
				backtracking(results, i, selected, candidates, dev-candidate);
				selected.remove(selected.size()-1);
			}
			else{
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		M39_CombinationSum sol = new M39_CombinationSum();
		int[] nums = new int[]{2,3,6,7};
		int target = 7;
		List<List<Integer>> ret = sol.combinationSum(nums, target);
		for(List<Integer> result:ret){
			System.out.println(Arrays.toString(result.toArray()));
		}
	}
}
