package org.dp;

public class OptimalParens {
	int[][] m = null;
	int[][] s = null;
	int n;
	public OptimalParens(int n){
		this.n = n;
		m = new int[n][n];
		s = new int[n][n];
	}
	void findOptimalParens(int n, int[] p){

		for(int i=0; i<n; i++){
			m[i][i] = 0;
		}
		for(int l =2; l<=n; l++){
			for(int i=1; i<=n-l; i++){
				int j = i+l-1;
				m[i][j] = Integer.MAX_VALUE;
				for(int k=i; k<=j-1;k++){
					int q = m[i][k]+m[k+1][j]+p[i]*p[k]*p[j];
					if(m[i][j]>q){
						m[i][j] = q;
						s[i][j] = k;
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args){
		int[] p = {5, 10, 3, 12, 5, 50, 6};
		int n = p.length - 1;
		
	}
	
	
	

}
