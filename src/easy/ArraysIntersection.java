package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ArraysIntersection {
	public int[] intersect(int[] nums1, int[] nums2) {
		HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> retSet = new HashSet<>();
        for(int num:nums1){
            set.add(num);
        }
        for(int num:nums2){
            if(set.contains(num))retSet.add(num);
        }
        
        int[] retList = new int[retSet.size()];
        int i = 0;
        Iterator<Integer> it = retSet.iterator();
        while(it.hasNext()){
        	retList[i++] = it.next();
        }
        return retList;
    }
	
	public int[] intersect2(int[] nums1, int[] nums2) {
		HashSet<Integer> set = new HashSet<>();
        for(int num:nums1){
            set.add(num);
        }
        ArrayList<Integer> retList = new ArrayList<>();
        
        for(int num:nums2){
            if(set.contains(num)){
                retList.add(num);
            }
        }
        
        int[] list = new int[retList.size()];
        for(int i=0;i<retList.size();i++)list[i] = retList.get(i);
        return list;
        
    }
	
	
}
