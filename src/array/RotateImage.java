package array;


public class RotateImage {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for(int layer = 0; layer <n/2;layer++)
			rotate(matrix, layer, n);
        
    }
	
	public void rotate(int[][] matrix, int layer, int n){
		for(int i = layer;i<n-layer-1;i++){
			int upleft = matrix[layer][i];
			matrix[layer][i] = matrix[n-1-i][layer];
			
			matrix[n-1-i][layer] = matrix[n-1-layer][n-1-i];
			
			matrix[n-1-layer][n-1-i] = matrix[i][n-1-layer];
			
			matrix[i][n-1-layer] = upleft;
			
			
		}
		
	}
	
	public static void main(String[] args) {
		int[][] mat = new int[3][3];
		mat[0] = new int[]{1,2,3};
		mat[1] = new int[]{4,5,6};
		mat[2] = new int[]{7,8,9};
		for(int i = 0;i<3;i++){
			for(int j = 0;j<3;j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		
		RotateImage sol = new RotateImage();
		sol.rotate(mat);
		for(int i = 0;i<3;i++){
			for(int j = 0;j<3;j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
	
	
}
