package string;

public class RemoveDuplicate_316 {
	
	public String removeDuplicateLetters(String s) {
		if(s==null || s.length()<2)return s;
        boolean[] exist = new boolean[26];
        for(int i = 0;i<s.length();i++){
        	exist[s.charAt(i)-'a'] = true;
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<26;i++){
        	if(exist[i]==true)sb.append((char)('a'+i));
        }
        return sb.toString();
        
    }
	
	public static void main(String[] args) {
		String s = "bdbdabc";
		RemoveDuplicate_316 sol = new RemoveDuplicate_316();
		System.out.println(sol.removeDuplicateLetters(s));
	}
}
