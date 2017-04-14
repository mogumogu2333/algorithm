package easy;

public class E38_CountandSay {

    public String countAndSay(int n) {
        String start = "1";
        for(int i = 1;i<n;i++){
        	start = findNext(start.toCharArray());
        }
        return start;
    }
    
    public String findNext(char[] cur){
        if(cur.length==1){
            char[] ret = new char[2];
            ret[0] = '1';
            ret[1] = cur[0];
            return new String(ret);
        }
        
        int counter = 1;
        StringBuffer result = new StringBuffer();
        int i = 0;
        while(i<cur.length){
        	
            for(int j = i+1;j<cur.length;j++){
                if(cur[i]==cur[j]){
                    counter++;
                    continue;
                }
                else break;
            }
            
            result.append(counter);
            result.append(cur[i]);
            i = i+counter;
            counter = 1;
        }
        return result.toString();
    }

    
    public static void main(String[] args) {
    	E38_CountandSay sol = new E38_CountandSay();
    	System.out.println(sol.countAndSay(5));
    	
//    	String s = "1211";
//    	System.out.println(sol.findNext(s.toCharArray()));
	}

}
