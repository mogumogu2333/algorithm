package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M54_SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		if(matrix==null)return null;
		List<Integer> res = new ArrayList<>();
		if(matrix.length==0)return res;
		int nRow = matrix.length; //5
		int nCol = matrix[0].length; //1
		for(int layer = 0; layer<Math.ceil((Math.min(nCol, nRow)/2.0));layer++){
			//top
			for(int i = layer;i<nCol-layer;i++)res.add(matrix[layer][i]);
			//right
			for(int j = layer+1;j<nRow-layer;j++)res.add(matrix[j][nCol-1-layer]);
			//bottom: nRow-layer
			if(layer!=nRow-1-layer)
				for(int i = nCol-2-layer;i>layer;i--)res.add(matrix[nRow-1-layer][i]);
			//left: layer 
			if(nCol-1-layer!=layer)
				for(int j = nRow-1-layer;j>layer;j--)res.add(matrix[j][layer]);
		}
		return res;
        
    }
	
	public static void main(String[] args) {
//		int[][] matrix = new int[2][3];
//		matrix[0] = new int[]{1,2,3};
//		matrix[1] = new int[]{4,5,6};
		
		int[][] matrix = new int[3][4];
		matrix[0] = new int[]{1,2,3,4};
		matrix[1] = new int[]{5,6,7,8};
		matrix[2] = new int[]{9,10,11,12};
		
//		int[][] matrix = new int[4][1];
//		matrix[0] = new int[]{1};
//		matrix[1] = new int[]{2};
//		matrix[2] = new int[]{3};
//		matrix[3] = new int[]{4};
		
		M54_SpiralMatrix sol = new M54_SpiralMatrix();
		System.out.println(Arrays.toString(sol.spiralOrder(matrix).toArray()));
	}
}
