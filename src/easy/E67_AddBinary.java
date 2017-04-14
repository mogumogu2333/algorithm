package easy;

public class E67_AddBinary {
	public String addBinary(String a, String b) {
		int i = a.length()-1;
		int j = b.length()-1;
		String s = "";
		int carry=0;
		int sum = 0;
		while(i>=0 || j>=0 || carry==1){
			int ai = (i<0)?0:a.charAt(i--)-'0';
			int bj = (j<0)?0:b.charAt(j--)-'0';
			sum = (ai ^ bj) ^ carry;
			carry = (ai+bj+carry)>>1;
			s = sum+s;
		}
		return s;
	}
	
	public static void main(String[] args) {
		String a = "111";
		String b = "111";
		E67_AddBinary sol = new E67_AddBinary();
		System.out.println(sol.addBinary(a, b));
	}

}
