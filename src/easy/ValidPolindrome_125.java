package easy;

public class ValidPolindrome_125 {
	public boolean isPalindrome0(String s) {
		if(s==null || s.length()==0)return true;
		s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		int i = 0, j = s.length()-1;
		while(i<j){
			if(s.charAt(i)!=s.charAt(j))return false;
			else{
				i++;
				j--;
			}
		}
		return true;
    }
	
	public boolean isPalindrome(String s) {
		if(s==null || s.length()==0)return true;
		int i = 0, j = s.length()-1;
		while(i<j){
			char head = s.charAt(i);
			char tail = s.charAt(j);
			if(!Character.isLetterOrDigit(head))i++;
			else if(!Character.isLetterOrDigit(tail))j--;
			else if(Character.toLowerCase(head)!=Character.toLowerCase(tail))return false;
			else{
				i++;
				j--;
			}
		}
		return true;
    }
	
	public static void main(String[] args) {
		String s = "abcba";
		ValidPolindrome_125 sol = new ValidPolindrome_125();
		System.out.println(sol.isPalindrome(s));
	}
}
