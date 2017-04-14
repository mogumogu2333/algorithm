package medium;

import java.util.ArrayList;
import java.util.List;

public class M6_Zigzag {

    public String convert(String s, int numRows) {
    	if(numRows==1)return s;
    	List<StringBuffer> buffs = new ArrayList<>(numRows);
    	for(int i = 0;i<numRows;i++)buffs.add(new StringBuffer());
    	
    	int i=0;
    	while(i<s.length()){
    		for(int j = 0;j<numRows && i<s.length();j++){
    			//down
    			buffs.get(j).append(s.charAt(i));
    			i++;
    		}
    		
    		for(int j = numRows-2;j>0&& i<s.length();j--){
    			//obliquely up
    			buffs.get(j).append(s.charAt(i));
    			i++;
    		}
    	}
    	
    	for(i = 1;i<numRows;i++){
    		buffs.get(0).append(buffs.get(i));
    	}
    	return buffs.get(0).toString();
        
    }
    
    public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int n = 3;
		M6_Zigzag sol = new M6_Zigzag();
		String t = sol.convert(s, n);
		System.out.println(t);
	}

}
