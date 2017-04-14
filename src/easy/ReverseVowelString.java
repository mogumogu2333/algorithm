package easy;


/**
 * 
 * @author y80048376
 * Hashset solution is about 16 ms.
 * Use a list and traverse it is abouut 6ms
 * Hard code is more efficient!
 *
 */
public class ReverseVowelString {
	
	char[] vowels = new char[]{'a','e','i','o','u','A','E','I','O','U'};

	public boolean isVowel(char ch){
		for(char v : vowels){
			if(v == ch)return true;
		}
		return false;
	}
	
	
	public String reverseVowels(String s) {
        if(s==null || s.equals(""))return s;
        char[] arr = s.toCharArray();
        
        
        int left = 0;
        int right = s.length()-1;
        while(left < right){
        	if(!isVowel(arr[left])){
        		left++;
        		continue;
        	}
        	if(!isVowel(arr[right])){
        		right--;
        		continue;
        	}
        	char tmp = '\0';
        	if(left<right){
        		tmp = arr[left];
        		arr[left++] = arr[right];
        		arr[right--] = tmp;
        	}
        }
        
        return new String(arr);
    }
	
	public static void main(String[] args) {
		String test = "hello";
		
		ReverseVowelString sol = new ReverseVowelString();
		System.out.println(sol.reverseVowels(test));
	}
	
}
