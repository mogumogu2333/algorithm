//package string;
//
//public class H10_RegularExpMatching {
//	
//	boolean isMatch(String s, String p){
//		int cur = 0;
//		for(int i = 0;i<p.length()-1;i++){
//			char ch = p.charAt(i);
//			if(ch=='.'){
//				if(p.charAt(i+1)=='*' || p.charAt(i+1)=='+'){
//					return true;
//				}
//				else{
//					cur += 1;
//				}
//			}
//			else if(Character.isAlphabetic(ch)){
//				if(p.charAt(i+1)=='*'){
//					while(cur<s.length() && s.charAt(cur)==ch)cur++;
//				}
//				else if(p.charAt(i+1)=='+'){
//					
//				}
//				else{
//					
//				}
//			}
//		}
//	}
//
//}
