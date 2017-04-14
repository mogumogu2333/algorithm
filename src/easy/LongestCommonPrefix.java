package easy;

public class LongestCommonPrefix {

	 public String longestCommonPrefix(String[] strs) {
		 
		 if(strs==null)return "";
		 int len = strs.length;
		 if(len==0)return "";
		 if(len==1)return strs[0];
		 String ret = "";
		 for(int i = 0; i<strs[0].length();i++){
			 for(int j = 1; j<strs.length;j++){
				 if(i > strs[j].length()-1 || strs[0].charAt(i)!=strs[j].charAt(i))
					 return ret;
				 
			 }
			 ret = ret+strs[0].charAt(i);
		 }
		 
		 return ret;
	        
	 }
	 
	 public static void main(String[] args) {
		String[] strs = new String[]{"abc","abd","ab"};
		LongestCommonPrefix sol = new LongestCommonPrefix();
		System.out.println(sol.longestCommonPrefix(strs));
	}
	
	
}
