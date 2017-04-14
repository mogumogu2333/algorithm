package design;

import java.util.HashMap;

class TrieNode{
	HashMap<Character, TrieNode> children;
	boolean isLeaf;
	TrieNode(){
		children = new HashMap<>();
		isLeaf = false;
	}
}
public class Trie {

	TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
    	root = new TrieNode();
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode cur = root;
        for(int i = 0; i<word.length(); i++){
        	char ch = word.charAt(i);
        	if(!cur.children.containsKey(ch)){
        		cur.children.put(ch, new TrieNode());
        	}
        	cur = cur.children.get(ch);
        }
        cur.isLeaf = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i<word.length(); i++){
        	char ch = word.charAt(i);
        	if(!cur.children.containsKey(ch)){
        		return false;
        	}
        	cur = cur.children.get(ch);
        }
        if(cur.isLeaf==false)return false;
        else return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode cur = root;
        for(int i = 0; i<prefix.length(); i++){
        	char ch = prefix.charAt(i);
        	if(!cur.children.containsKey(ch))return false;
        	cur = cur.children.get(ch);
        }
        return true;
    }

    public static void main(String[] args) {
		Trie trie= new Trie();
		trie.insert("ab");
		trie.insert("a");
		System.out.println(trie.search("a"));
		System.out.println(trie.search("ab"));
		System.out.println(trie.startsWith("a"));
		System.out.println(trie.startsWith("ab"));
		
	}

}
