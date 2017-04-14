package array;

public class hindex_274 {
	public int hIndex(int[] citations) {
        if(citations==null)return 0;
        int length = citations.length;
        if(length==0)return 0;
        
        int[] arr = new int[length+1];
        
        for(int i = 0;i<length;i++){
        	if(citations[i]>length)arr[length]+=1;
        	else{
        		arr[citations[i]]+=1;
        	}
        }
        
        int tot = 0;
        for(int i = length;i>=0;i--){
        	tot += arr[i];
        	if(tot>=i)return i;
        	
        }
        return 0;
        	
        	
        		
    }

	public static void main(String[] args) {
		int[] citations = new int[]{3,0,6,1,5};
		hindex_274 sol = new hindex_274();
		System.out.println(sol.hIndex(citations));
				
	}
}
