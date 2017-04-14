package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M40_CombinationSum2 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if(candidates==null)return null;
		List<List<Integer>> ret = new ArrayList();
		if(candidates.length==0)return ret;
		List<Integer> path = new ArrayList<>();
		Arrays.sort(candidates);
		backtracking(ret, path, candidates, 0, target);
		return ret;
    }
	
	public void backtracking(List<List<Integer>> ret, List<Integer> path, int[] candidates, int start, int dev){
		if(dev==0){
			if(path.size()!=0)ret.add(new ArrayList<>(path));
			return;
		}
		if(dev<0)return;
		for(int i = start; i < candidates.length;i++){
			if(i>start && candidates[i] == candidates[i-1])continue;
			int candidate = candidates[i];
			if(candidate<=dev){
				path.add(candidate);
				backtracking(ret, path, candidates, i+1, dev-candidate);
				path.remove(path.size()-1);
			}
			else return;
		}
	}
	
	public static void main(String[] args) {
		M40_CombinationSum2 sol = new M40_CombinationSum2();
		int[] nums = new int[]{10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		List<List<Integer>> ret = sol.combinationSum2(nums, target);
		for(List<Integer> result:ret){
			System.out.println(Arrays.toString(result.toArray()));
		}
	}

}
