package hard;

import java.util.Stack;

public class LargestRectangleInHist {
	public int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int sumArea = 0;
		for(int i = 0;i<=heights.length;i++){
			int hi = (i==heights.length)?0:heights[i];
			if(stack.isEmpty() || heights[stack.peek()] <= hi){
				stack.push(i);
			}
			else{
				int top = stack.pop();
//				sumArea = Math.max(sumArea, heights[top] * ((stack.isEmpty())?i: (i-stack.peek()-1)));
				sumArea = Math.max(sumArea, heights[top] * ((stack.isEmpty())?i: (i-1 -(stack.peek()+1) + 1)));
				i--;
			}
		}
		return sumArea;
        
    }
	
	// hard to understand
//	public int largestRectangleArea(int[] height) {
//        int len = height.length;
//        Stack<Integer> s = new Stack<Integer>();
//        int maxArea = 0;
//        for(int i = 0; i <= len; i++){
//            int h = (i == len ? 0 : height[i]);
//            System.out.println("i="+i+"\th[i]="+h+"\tloop start, stack: "+s.toString());
//            if(s.isEmpty() || h >= height[s.peek()]){
//                s.push(i);
//                System.out.println("\t\tPUSH i to stack: "+s.toString());
//            }else{
//                int tp = s.pop();
//                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
//                i--;
//                System.out.println("\t\tPOP top, now stack: "+s.toString());
//            }
//        }
//        return maxArea;
//    }
	
	public static void main(String[] args) {
//		int[] nums = new int[]{2,1,2};
		int[] nums = new int[]{4,2,0,3,2,5};
		LargestRectangleInHist sol = new LargestRectangleInHist();
		int sum = sol.largestRectangleArea(nums);
		System.out.println(sum);
		
	}
}
