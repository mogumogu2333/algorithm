package array;

public class M151_ReverseString {
	public String reverseWords(String s) {
		if(s==null || s.length()==0)return s;
		s = trimString(s);
		s = cleanSpaces(s.toCharArray(), s.length());
		if(s.length()<2)return s;
		System.out.println(s);
		char[] list = s.toCharArray();
		int i = 0;
		int j;
        for(j = i+1;j<s.length();j++){
        	if(list[j] != ' ') continue;
        	else{
        		reverseString(list, i, j-1);
        		i = j+1;
        	}
        }
        if(j-i>1)reverseString(list, i, j-1);
        System.out.println(new String(list));
        
		i = 0;
		j = s.length()-1;
        reverseString(list,i,j);
        return new String(list);
        
    }
	
	public String cleanSpaces(char[] s, int n){
		int index = 0;
		int len = n;
		for(int j = 1;j<n;j++){
			if(s[j]==' ' && s[j-1]==' '){
				len--;
				continue;
			}
			s[++index] = s[j];
		}
		return new String(s, 0, len);
		
	}
	
	public String trimString(String s){
		int end = s.length();
		int start= 0;
		while(start<end && s.charAt(start) == ' ')start++;
		while(start<end && s.charAt(end-1)==' ')end--;
		return ((start>0) || (end<s.length()))?s.substring(start, end):s;
	}
	public void reverseString(char[] s, int i, int j){
		while(i<j){
			char temp = s[i];
			s[i++] = s[j];
			s[j--] = temp;
		}
	}
	
	public static void main(String[] args) {
		String s = "  the sky is   blue  ";
		M151_ReverseString sol = new M151_ReverseString();
		System.out.println(sol.reverseWords(s));
//		System.out.println(sol.trimString(s));
//		System.out.println(sol.cleanSpaces(s.toCharArray(),s.length()));
		
	}
}
