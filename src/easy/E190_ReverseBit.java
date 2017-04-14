package easy;


public class E190_ReverseBit {
	public int reverseBits(int n) {
		int[] binarylist = new int[32];
		for(int i = 0;i<32;i++) binarylist[i] = ( ((1<<i)&n) ==0)?0:1;
		int res = 0;
		for(int val:binarylist) res = (res<<1) | val;
        return res;
    }
	
	public static void main(String[] args) {
		E190_ReverseBit sol = new E190_ReverseBit();
		int n = 43261596;
		int rn = sol.reverseBits(n);
		System.out.println(rn);
	}
	
	
}
