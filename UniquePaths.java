package org.dp;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		if (m <= 0 || n <= 0)
			return 0;
		int[][] s = new int[m][n];
		
		for(int j=0; j<n; j++){
			s[0][j]=1;
		}
		for(int i=0; i<m; i++){
			s[i][0]=1;
		}
		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				s[i][j] = s[i-1][j] + s[i][j-1];
			}
		}
		
		return s[m-1][n-1];
	}
}
