package easy;

import java.util.HashSet;

public class ContainDuplicate_217 {
	   public boolean containsDuplicate(int[] nums) {
		   if(nums.length==0)return false;
	        HashSet<Integer> set = new HashSet<>();
	        for(int num : nums){
	        	set.add(num);
	        }
	        if(set.size()<nums.length)return true;
	        else return false;
	    }
}
