package string;

public class LengthLastWord {
	public int lengthOfLastWord(String s) {
        if(s==null)return 0;
        
        s = s.trim();
        int length = 0;
        for(int i = (s.length()-1);i>=0;i--){
            if(s.charAt(i)>='A' &&s.charAt(i)<='z'){
                length++;
                continue;
            }
            else break;
        }
        return length;
        
    
        
    }
	
	public static void main(String[] args) {
		String s = "";
		LengthLastWord sol = new LengthLastWord();
		System.out.println(sol.lengthOfLastWord(s));;
		
				
	}
}
