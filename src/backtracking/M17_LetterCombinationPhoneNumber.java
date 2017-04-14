package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M17_LetterCombinationPhoneNumber {
	private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	
	public List<String> letterCombinations(String digits) {
		if(digits==null)return null;
		List<String> ret = new ArrayList<>();
		if(digits.length()==0)return ret;
		
		char[] char_digits = digits.toCharArray();
		letterCombinations(char_digits, 0, ret, new char[char_digits.length]);
		return ret;
    }
	
	public void letterCombinations(char[] digits, int pos, List<String> combinations, char[] prevs){
		char[] charset = KEYS[digits[pos]-'0'].toCharArray();
		if(pos==digits.length-1){
			for(char ch : charset){
				char[] comb = Arrays.copyOf(prevs, digits.length);
				comb[pos] = ch;
				combinations.add(new String(comb));
			}
			return;
		}
		else{
			for(char ch : charset){
				char[] newprevs = Arrays.copyOf(prevs, digits.length);
				newprevs[pos] = ch;
				letterCombinations(digits, pos+1, combinations, newprevs);
			}
		}
	}
	
	public char[] getChars(char ch){
		int number = ch-'0';
		if(number == 9)return new char[]{'w','x','y','z'};
		else if(number == 7)return new char[]{'p','q','r','s'};
		else if(number == 8)return new char[]{'t','u','v'};
		else{
			char[] ret = new char[3];
			ret[0] = (char)((number-2)*3+'a');
			ret[1] = (char)((number-2)*3+'b');
			ret[2] = (char)((number-2)*3+'c');
			return ret;
		}
	}
	
	public static void main(String[] args) {
		M17_LetterCombinationPhoneNumber sol = new M17_LetterCombinationPhoneNumber();
		
		List<String> ret = sol.letterCombinations("7");
		for(String s:ret){
			System.out.println(s);
		}
	}
}
