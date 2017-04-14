package medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class M71_SimplifyPath {
	public String simplifyPath(String path) {
//		Stack<String> stack = new Stack<>();
		Deque<String> stack = new LinkedList<>();
        Set<String> ignore = new HashSet<>(Arrays.asList(".","..",""));
        
        for(String s : path.split("/")){
        	if(!ignore.contains(s)){
        		stack.push(s);
        	}
        	else{
        		if(s.equals("..") && !stack.isEmpty())stack.pop();
        	}
        }
        if(stack.isEmpty())return "/";
        String res = "";
        for(String s: stack)res = "/"+s+res;
        return res;
    }
	
	public static void main(String[] args) {
		String s = "/a/./b/../c/";
		M71_SimplifyPath sol = new M71_SimplifyPath();
		System.out.println(sol.simplifyPath(s));
	}
}
