package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//class StringComparator implements Comparator<String>{
//
//	@Override
//	public int compare(String o1, String o2) {
//		// TODO Auto-generated method stub
//		return (o1+o2).compareTo(o2+o1);
//	}
//	
//}

public class LargestNumber_179 {
	public String largestNumber(int[] nums) {
		if(nums==null || nums.length==0)return "";
		
		List<String> strList = new ArrayList<>();
		for(int num:nums){
			StringBuffer sb = new StringBuffer();
			if(num==0)sb.append("0");
			while(num>0){
				sb.append(num%10);
				num = num/10;
			}
			strList.add(sb.reverse().toString());
		}
		
		//sort
		Collections.sort(strList, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return (o1+o2).compareTo(o2+o1);
			}
			
		});
		
		for(String s:strList)System.out.println(s);
		
		if(strList.get(strList.size()-1).equals("0"))return "0";
		else{
			StringBuffer sb = new StringBuffer();
			for(int i = strList.size()-1;i>=0;i--)sb.append(strList.get(i));
			return sb.toString();
		}
		
	}
	
	
	public static void main(String[] args) {
		int[] nums = new int[]{0,0};
		LargestNumber_179 sol = new LargestNumber_179();
		String s = sol.largestNumber(nums);
		System.out.println(s);
	}

}
