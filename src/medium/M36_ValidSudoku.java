package medium;

import java.util.HashSet;

public class M36_ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		//check row
		for(int i = 0;i<9;i++){
			HashSet<Integer> set = new HashSet<>();
			for(int j = 0;j<9;j++){
				char c = board[i][j];
				if(c=='.')continue;
				int val = c-'0';
				if(set.contains(val))return false;
				else set.add(val);
			}
		}
		
		//check col
		for(int j = 0;j<9;j++){
			HashSet<Integer> set = new HashSet<>();
			for(int i = 0;i<9;i++){
				char c = board[i][j];
				if(c=='.')continue;
				int val = c-'0';
				if(set.contains(val))return false;
				else set.add(val);
			}
		}
		
		//check square
		for(int i = 0;i<9;i++){
			HashSet<Integer> set = new HashSet<>();
			for(int j = 0;j<9;j++){
				char c = board[3*(i/3)+j/3][3*(i%3)+(j%3)];
				if(c=='.')continue;
				int val = c-'0';
				if(set.contains(val))return false;
				else set.add(val);
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		String[] strboard = new String[]{
				"....5..1.",
				".4.3.....",
				".....3..1",
				"8......2.",
				"..2.7....",
				".15......",
				".....2...",
				".2.9.....",
				"..4......"
			};
		char[][] board = new char[9][9];
		for(int i = 0;i<9;i++){
			board[i] = strboard[i].toCharArray();
		}
		
		M36_ValidSudoku sol = new M36_ValidSudoku();
		System.out.println(sol.isValidSudoku(board));
	}

}
