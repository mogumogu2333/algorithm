package medium;

import java.util.Stack;

public class M150_EvaluateReverseNotation {
	public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s:tokens){
        	switch (s) {
			case "+":
				stack.push(stack.pop()+stack.pop());
				break;
			case "-":
				stack.push(-stack.pop()+stack.pop());
				break;
			case "*":
				stack.push(stack.pop()*stack.pop());
				break;
			case "/":
				int n1 = stack.pop();
				int n2 = stack.pop();
				stack.push(n2/n1);
				break;
			default:
				stack.push(Integer.parseInt(s));
			}
        }
        return stack.pop();
    }
	
	public static void main(String[] args) {
		String[] tokens = new String[]{"0","3","/"};
		M150_EvaluateReverseNotation sol = new M150_EvaluateReverseNotation();
		System.out.println(sol.evalRPN(tokens));
	}
}
