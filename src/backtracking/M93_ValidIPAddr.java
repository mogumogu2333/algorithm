package backtracking;

import java.util.ArrayList;
import java.util.List;

public class M93_ValidIPAddr {
	public List<String> restoreIpAddresses(String s) {
		List<String> result= new ArrayList<>();
		dfs(result, "", s, 0,0);
		return result;
    }
	
	public void dfs(List<String> result, String cur, String s, int pos, int step){
		if(s.length() == pos && step == 4){
			result.add(cur);
			return;
		}
		if(step>4)return;
		for(int i = 0;i<3;i++){
			if(pos+i+1>s.length())break;
			String strNext = s.substring(pos, pos+i+1);
			if(strNext.length()>1 && strNext.startsWith("0"))continue;
			int nextInt = Integer.parseInt(s.substring(pos, pos+i+1));
			if(nextInt>=0 && nextInt<256){
				String newCur = (pos==0)?strNext:(cur + "." + strNext);
				dfs(result, newCur, s, pos+i+1,step+1);
			}
			else{
				return;
			}
		}
		
	}
	
	public static void main(String[] args) {
		String s = "010010";
		M93_ValidIPAddr sol = new M93_ValidIPAddr();
		List<String> res = sol.restoreIpAddresses(s);
		for(String x:res)System.out.println(x);
	}

}
