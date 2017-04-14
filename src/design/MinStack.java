package design;

import java.util.Stack;

public class MinStack {
	Stack<Integer> stack;
	Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
    	this.stack = new Stack<>();
    	this.minStack = new Stack<>();
    }
    
    public void push(int x) {
    	this.stack.push(x);
    	if(minStack.isEmpty() || minStack.peek()>=x)minStack.push(x);
    	
    }
    
    public void pop() {
    	int x = stack.pop();
    	if(x==minStack.peek())minStack.pop();
    }
    
    public int top() {
    	return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }


	/**
	 * Your MinStack object will be instantiated and called as such:
	 * MinStack obj = new MinStack();
	 * obj.push(x);
	 * obj.pop();
	 * int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	 */
    
    
    public static void main(String[] args) {
    	MinStack stack = new MinStack();
    	stack.push(4);
    	stack.push(3);
    	stack.push(2);
    	System.out.println(stack.top());
    	System.out.println(stack.getMin());
    	stack.pop();
    	System.out.println(stack.top());
    	System.out.println(stack.getMin());
    	stack.push(5);
    	System.out.println(stack.top());
    	System.out.println(stack.getMin());
	}
}
