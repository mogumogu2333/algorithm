package string;


public class H65_ValidNumber {
	public boolean isNumber(String s) {
		int[][] transferMatrix = new int[9][6];
		transferMatrix[0] = new int[]{-1,0,3,1,2,-1};
		transferMatrix[1] = new int[]{-1,8,-1,1,4,5};
		transferMatrix[2] = new int[]{-1,-1,-1,4,-1,-1};
		transferMatrix[3] = new int[]{-1,-1,-1,1,2,-1};
		transferMatrix[4] = new int[]{-1,8,-1,4,-1,5};
		transferMatrix[5] = new int[]{-1,-1,6,7,-1,-1};
		transferMatrix[6] = new int[]{-1,-1,-1,7,-1,-1};
		transferMatrix[7] = new int[]{-1,8,-1,7,-1,-1};
		transferMatrix[8] = new int[]{-1,8,-1,-1,-1,-1};
		
		int status = 0;
		int input;
		// SPACE=1, SIGN=2, DIGIT=3, DOT=4, E/e=5, INVALID=0
		System.out.println("instatus\tinput\toutstatus");
		for(char c:s.toCharArray()){
			if(c==' ')input = 1; 
			else if(c=='+'||c=='-')input=2;
			else if(Character.isDigit(c))input=3;
			else if(c=='.')input=4;
			else if(c=='e' || c == 'E')input=5;
			else input = 0;
			System.out.print(status+"\t"+input+"\t");
			
			status = transferMatrix[status][input];
			System.out.println(status);
			if(status == -1) return false;
		}
		return (status==1 || status==4 || status==7 || status==8);
    }
	
	public static void main(String[] args) {
		H65_ValidNumber sol = new H65_ValidNumber();
		String input = " 1 ";
		System.out.println(input);
		System.out.println(sol.isNumber(input));
	}
	
	
	
	
	
	
}
