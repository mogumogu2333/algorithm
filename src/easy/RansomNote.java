package easy;

public class RansomNote {
	/**
	 * This question: cut chars from magazines to get the note. 
	 * So the goal is to ensure, the count of each letter need to construct the note 
	 * is no less than the count of it in magazine
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
	public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        
        //initalize to zero
        for(int i = 0;i<26;i++) count[i]=0;
        
        for(char ch : magazine.toCharArray()){
        	count[ch-'a']+=1;
        }
        
        for(char ch:ransomNote.toCharArray()){
        	count[ch-'a']-=1;
        }
        
        for(int num:count){
        	if(num<0)return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		RansomNote sol = new RansomNote();
		System.out.println(sol.canConstruct("ab", "aaaba"));
	}


}
