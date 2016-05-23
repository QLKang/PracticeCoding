package org.dp;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        if(obstacleGrid == null || obstacleGrid.length==0 || obstacleGrid[0].length ==0)
        	return 0;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] s = new int[m][n];
        int y = 0;
        while(y < n && obstacleGrid[0][y]==0){
        	s[0][y] = 1;
        	y++;
        }
        int x = 0;
        while(x<m && obstacleGrid[x][0]==0){
        	s[x][0] = 1;
        	x++;
        }
        
        for(int i=1; i<m; i++){
        	for(int j=1; j<n; j++){
        	    if(obstacleGrid[i][j] == 1){
        	        continue;
        	    }
        		if(obstacleGrid[i-1][j]==0){
        			s[i][j]+=s[i-1][j];
        		}
        		if(obstacleGrid[i][j-1]==0){
        			s[i][j]+=s[i][j-1];
        		}
        	}
        }
        return s[m-1][n-1];
    }

	
}
