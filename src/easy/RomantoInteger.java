package easy;

import java.util.HashMap;

/**
 * The problem description limit the number from 1-3999.
 * That means we don't need to consider 5000(symbol with 'delta'). with then, 4000=5000-1000
 * But 3999 we can represent as MMMIM
 * 
 * 
 * @author Shang
 *
 */
public class RomantoInteger {
	public int romanToInt(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		
		
        int retVal=0;
        int val = map.get(s.charAt(0));
        
        for(int i = 0;i<s.length()-1;i++){
        	int valNext = map.get(s.charAt(i+1));
        	
        	if(val<valNext){
        		retVal-=val;
        	}
        	else{
        		retVal+=val;
        	}
        	
        	val = valNext;
        }
        retVal+=map.get(s.charAt(s.length()-1));
        return retVal;
    }
	
	public int charToInt(char ch){
		switch(ch){
		case 'I': return 1;
    	case 'V': return 5;
    	case 'X': return 10;
    	case 'L': return 50;
    	case 'C': return 100;
    	case 'D': return 500;
    	case 'M': return 1000;  
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		String s = "MMMIM";
		
		RomantoInteger sol = new RomantoInteger();
		int val = sol.romanToInt(s);
		System.out.println(val);
	}
}
