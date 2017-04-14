package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class M187_RepeatedDNASequences {
	
	// HashMap solution
	public List<String> findRepeatedDnaSequences_hashmap(String s) {
        HashMap<String,Integer> counts = new HashMap<>();
        List<String> results = new ArrayList<>();
        if(s==null)return results;
        for(int i = 0;i<s.length()-9;i++){
        	String substr = s.substring(i, i+10);
        	if(counts.containsKey(substr)) counts.put(substr, counts.get(substr)+1);
        	else counts.put(substr, 1);
        }
        
        Iterator<String> it = counts.keySet().iterator();
        while(it.hasNext()){
        	String substr = it.next();
        	if(counts.get(substr)>1) results.add(substr);
        }
        return results;
    }
	
	// Coding with bit 
	public List<String> findRepeatedDnaSequences(String s) {

        
        HashSet<Integer> check = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        HashMap<Character, Integer> mapping = new HashMap<>();
        mapping.put('A', 0);
        mapping.put('C', 1);
        mapping.put('G', 2);
        mapping.put('T', 3);
        
        List<String> results = new ArrayList<>();
        if(s.length()<=10)return results;
        int hashVal = 0;
        for(int i = 0;i<9;i++){
            hashVal = hashVal<<2 | mapping.get(s.charAt(i));
        }
        
        int mask = (1<<20)-1;
        for(int i = 9;i<s.length();i++){
            hashVal = hashVal<<2 | mapping.get(s.charAt(i));
            hashVal = mask & hashVal;
            if(!check.contains(hashVal))check.add(hashVal);
            else res.add(s.substring(i-9,i+1));
        }
        return new ArrayList<>(res);
	}
	
	
	
	public static void main(String[] args) {
		M187_RepeatedDNASequences sol = new M187_RepeatedDNASequences();
		String s = "GAGAGAGAGAGA";
		List<String> res = sol.findRepeatedDnaSequences(s);
		for(String str: res){
			System.out.println(str);
		}
	}
	
	
	
	
}
