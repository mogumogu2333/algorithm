package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_46 {
	public List<List<Integer>> permute(int[] nums) {
        if(nums==null)return null;
        List<List<Integer>> ret = new ArrayList<>();
        boolean[] isVisit = new boolean[nums.length];
        permutation(nums, 0, new ArrayList<>(), ret, isVisit);
        return ret;
        		
    }
	
	public void permutation(int[] nums, int pos, List<Integer> cur, List<List<Integer>>ret, boolean[] isVisit){
		if(pos==nums.length){
			ret.add(cur);
			return;
		}
		else{
			for(int i = 0; i<nums.length;i++){
				if(isVisit[i]==true)continue;
				else{
					List<Integer> newCur = new ArrayList<>(cur);
					newCur.add(nums[i]);
					isVisit[i] = true;
					permutation(nums, pos+1, newCur, ret, isVisit);
					isVisit[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3};
		Permutations_46 sol  = new Permutations_46();
		List<List<Integer>> ret = sol.permute(nums);
		for(List<Integer> l:ret){
			System.out.println(Arrays.toString(l.toArray()));
		}
	}
}
