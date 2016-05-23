package org.dp;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0|| grid[0].length==0){
        	return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] s = new int[m][n];
        
        s[0][0]=grid[0][0];
        
        for(int j=1; j<n; j++){
        	s[0][j] = s[0][j-1] + grid[0][j];
        }
        for(int i=1; i<m; i++){
        	s[i][0] = s[i-1][0] + grid[i][0];
        }
        
        for(int j=1; j<n; j++){
        	for(int i=1; i<m; i++){
        		s[i][j]=grid[i][j]+ Math.min(s[i-1][j], s[i][j-1]);
        	}
        }
        
        return s[m-1][n-1];
    }
	
}
