package easy;

public class ValidAnagram_242 {
	public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        
		int[] count = new int[26];
        for(char ch:s.toCharArray()){
        	count[ch-'a']+=1;
        }
        for(char ch:t.toCharArray()){
        	count[ch-'a']-=1;
        }
        for(int num:count){
        	if(num!=0)return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		ValidAnagram_242 sol = new ValidAnagram_242();
		System.out.println(sol.isAnagram("abc", "cbt"));;
	}
}
