package design;

import java.util.Stack;

public class MinStack_onestack {
	Stack<Long> stack;
	long min;
	public MinStack_onestack() {
		this.stack = new Stack<>();
    }
    
    public void push(int x) {
    	if(this.stack.isEmpty()){
    		this.stack.push(0L);
    		this.min = x;
    	}
    	else{
    		this.stack.push(x-min);
    		if(x<min){
    			min = x;
    		}
    	}
    }
    
    public void pop() {
    	if(stack.isEmpty())return;
    	
    	long pop = stack.pop();
    	if(pop<0)min = min-pop;
//    	if(stack.peek()>0){
//    		stack.pop();
//    	}
//    	else{
//    		min = min-stack.peek();
//    		stack.pop();
//    	}
    }
    
    public int top() {
    	
    	if(stack.peek()>0){
    		return (int)(stack.peek()+min);
    	}
    	else{
    		
    		return (int)(min-stack.peek());
    	}
    }
    
    public int getMin() {
    	return (int)min;
    }
    
    public static void main(String[] args) {
    	MinStack stack = new MinStack();
    	stack.push(2147483646);
    	stack.push(2147483646);
    	stack.push(2147483647);
    	System.out.println(stack.top());
    	System.out.println(stack.getMin());
    	stack.pop();
    	System.out.println(stack.top());
    	System.out.println(stack.getMin());
    	stack.pop();
    	System.out.println(stack.top());
    	System.out.println(stack.getMin());
    	stack.pop();

    	stack.push(2147483647);
    	System.out.println(stack.top());
    	System.out.println(stack.getMin());
    	stack.push(-2147483648);
    	System.out.println(stack.top());
    	System.out.println(stack.getMin());
    	
    	stack.pop();
    	System.out.println(stack.top());
    	System.out.println(stack.getMin());
	}

}
