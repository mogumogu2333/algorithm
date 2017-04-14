package easy;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
        if(s==null)return true;
        if(s.length()%2==1)return false;
        
        Stack<Character> stack = new Stack();
        for(char c:s.toCharArray()){
        	if(c=='(' ||c=='[' || c=='{')stack.push(c);
        	else if(stack.isEmpty())return false;
        	else if(c==')' && stack.peek()!='(') return false;
        	else if(c==']' && stack.peek()!='[') return false;
        	else if(c=='}' && stack.peek()!='{') return false;
        	else stack.pop();
        }
        return stack.isEmpty();
    }
	
	public static void main(String[] args) {
		String str = "[[";
		ValidParentheses sol = new ValidParentheses();
		System.out.println(sol.isValid(str));
	}
}
