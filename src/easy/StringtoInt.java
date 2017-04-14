package easy;

public class StringtoInt {
	/**
	 * stop when encounter non-digit
	 * consider -,+ at the head of string
	 * @param str
	 * @return
	 */
	public int myAtoi(String str) {
		if(str==null)return 0;
		str = str.trim();
		if(str.equals(""))return 0;
		boolean sign = true;
		if(str.charAt(0)=='-'){
			sign = false;
			str = str.substring(1);
		}
		else if(str.charAt(0)=='+')
			str = str.substring(1);
		
		int val = 0;
		for(int i = 0; i<str.length(); i++){
			char ch = str.charAt(i);
			if(ch<'0'||ch>'9')break;
			int digit = ch-'0';
			double max = sign? (Integer.MAX_VALUE/10.0-digit/10.0):(Integer.MAX_VALUE/10.0+(1-digit)/10.0);
			if(val > max){
				return sign?Integer.MAX_VALUE:Integer.MIN_VALUE;
			}
			val = val*10+(ch-'0');
		}
			
			
        return (!sign)?(-1*val):val;
    }
	
	public static void main(String[] args) {
		String number = "-00134";
		StringtoInt sol = new StringtoInt();
		int num = sol.myAtoi(number);
		System.out.println(num);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
	}

}
