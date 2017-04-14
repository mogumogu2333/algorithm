package easy;

import java.util.Arrays;

public class ReverseString {
	public String reverseString(String s) {
		if(s==null || s.length()<2)return s;
		char[] charArr = s.toCharArray();
		int head = 0;
		int tail = s.length()-1-head;
		while(head <= tail){
			char temp = charArr[head];
			charArr[head++] = charArr[tail];
			charArr[tail--] = temp;
		}
		return new String(charArr);
    }
	
	public static void main(String[] args) {
		String input = "hello";
		ReverseString rs = new ReverseString();
		String out = rs.reverseString(input);
		System.out.println(out);
	}

}
