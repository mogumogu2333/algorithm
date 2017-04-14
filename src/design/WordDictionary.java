package design;


class DictNode{
	DictNode[] children;
	boolean isleaf;
	DictNode(){
		children = new DictNode[26];
		isleaf = false;
	}
}

public class WordDictionary {
	
	 /** Initialize your data structure here. */
	DictNode root;
    public WordDictionary() {
        root = new DictNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        DictNode cur = root;
        for(int i = 0;i<word.length();i++){
        	int id = word.charAt(i)-'a';
        	if(cur.children[id]==null){
        		cur.children[id] = new DictNode();
        	}
        	cur = cur.children[id];
        }
        cur.isleaf = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	if(word==null || word.length()==0)return false;
    	DictNode cur = root;
    	return dfs_helper(word, 0, cur);
        
    }
    
    public boolean dfs_helper(String word, int wid, DictNode cur){
    	if(wid == word.length())return cur.isleaf;
    	//id < word.length
    	char ch = word.charAt(wid);
    	if(ch == '.'){
    		boolean dotMatch = false;
    		wid++;
    		for(int i = 0;i<cur.children.length;i++){
    			if(cur.children[i]!=null){
    				dotMatch = dotMatch || dfs_helper(word, wid, cur.children[i]);
    			}
    		}
    		return dotMatch;
    	}
    	else{
    		int id = ch-'a'; 
    		if(cur.children[id]==null)return false;
    		else{
    			return dfs_helper(word, ++wid, cur.children[id]);
    		}
    	}
    	
    }
    
    public static void main(String[] args) {
    	WordDictionary dict = new WordDictionary();
    	dict.addWord("abc");
    	dict.addWord("b");
    	System.out.println(dict.search("."));
	}
}
