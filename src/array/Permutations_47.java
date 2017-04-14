package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * With duplicated numbers
 * @author Shang
 *
 */
public class Permutations_47 {
	
	public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        boolean[] isVisit = new boolean[nums.length];
        
        backtracking(nums, ret, isVisit, new ArrayList<Integer>());
        return ret;
    }
	
	public void backtracking(int[] nums, List<List<Integer>> ret, boolean[] isVisit, List<Integer> prev){
		if(prev.size()==nums.length){
			ret.add(prev);
			return;
		}
		
		// isVisit
		for(int i = 0;i<nums.length;i++){
			if(i>0 && isVisit[i] == false && nums[i-1] == nums[i] && isVisit[i-1] == false){
				continue;
			}
			else if(isVisit[i]==true){
				continue;
			}
			else{
				isVisit[i] = true;
				List<Integer> newprev = new ArrayList<>(prev);
				newprev.add(nums[i]);
				backtracking(nums, ret, isVisit, newprev);
				isVisit[i] = false;
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3};
		Permutations_47 sol = new Permutations_47();
		List<List<Integer>> ret = sol.permuteUnique(nums);
		for(List<Integer> list:ret){
			System.out.println(Arrays.toString(list.toArray()));
		}
	}

}
