package easy;

public class ExcelSheetColumnNum {
public int titleToNumber(String s) {
	int retNum = 0;
        for(int i = 0;i<s.length();i++){
        	int num = s.charAt(i)-'A'+1;
        	retNum = retNum*26+num;
        }
        
        return retNum;
    }

public static void main(String[] args) {
	String s = "AB";
	
	ExcelSheetColumnNum sol = new ExcelSheetColumnNum();
	System.out.println(sol.titleToNumber(s));
}

}
