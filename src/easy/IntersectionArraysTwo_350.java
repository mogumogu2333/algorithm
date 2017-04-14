package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntersectionArraysTwo_350 {

    
	public int[] intersect(int[] nums1, int[] nums2) {
		
		 if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0)return new int[]{};
		    
		 
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int num:nums1){
		    if(map.containsKey(num)){
		        map.put(num, map.get(num)+1);
		    }
		    else{
		        map.put(num,1);
		    }
		}
		
		ArrayList<Integer> retList = new ArrayList<>();
		for(int num:nums2){
			
		    if(map.containsKey(num) && map.get(num)>0){
		        retList.add(num);
		        map.put(num, map.get(num)-1);
		    }
		    else{
		        continue;
		    }
		}
		
		int[] ret = new int[retList.size()];
	    for(int i = 0;i<retList.size();i++)ret[i] = retList.get(i);
	    return ret;
		
		
        
    }
	
	
	public static void main(String[] args) {
		IntersectionArraysTwo_350 sol = new IntersectionArraysTwo_350();
		int[] nums1=new int[]{1};
		int[] nums2 = new int[]{1,2};
		int[] list = sol.intersect(nums1, nums2);
		System.out.println(Arrays.toString(list));
	}
        
    

}
