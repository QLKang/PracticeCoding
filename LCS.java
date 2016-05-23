package org.dp;

import java.util.ArrayList;

/*
int[] A = {1,0,0,1,0,1,0,1}
int[] B = {0,1,0,1,1,0,1,1,0}
*/
class LCS {
	char[][] LCSImp(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		int[][] mat = new int[m + 1][n + 1];
		char[][] bat = new char[m + 1][n + 1];
		lcsHelp(A, B, m, n, mat, bat);
		return bat;
	}

	void lcsHelp(int[] A, int[] B, int m, int n, int[][] mat, char[][] bat) {

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (A[i] == B[j]) {
					mat[i + 1][j + 1] = mat[i][j] + 1;
					bat[i + 1][j + 1] = 'Q';
				} else {
					if (mat[i + 1][j] >= mat[i][j + 1]) {
						mat[i + 1][j + 1] = mat[i + 1][j];
						bat[i + 1][j + 1] = 'L';
					} else {
						mat[i + 1][j + 1] = mat[i][j + 1];
						bat[i + 1][j + 1] = 'U';
					}
				}
			}
		}
	}
	
	void printLCS(char[][] bat, int[] A, int[] B, int i, int j){
		if(i==0 || j==0){
			return;
		}
		if(bat[i][j]=='Q'){
			System.out.print(A[i-1]);
			printLCS(bat, A, B, i-1, j-1);
		}else if(bat[i][j]=='L'){
			printLCS(bat, A, B, i, j-1);
		}else{
			printLCS(bat, A, B, i-1, j);
		}
		
		
	}

	public static void main(String[] args) {

		int[] A = { 1, 0, 0, 1, 0, 1, 0, 1 };
		int[] B = { 0, 1, 0, 1, 1, 0, 1, 1, 0 };

		LCS sol = new LCS();
		char[][] bat = sol.LCSImp(A, B);
		for(int i=0; i<A.length+1; i++){
			for(int j=0; j<B.length+1; j++){
				System.out.print(bat[i][j]+" ");
			}
			System.out.println();
		}
		sol.printLCS(bat, A, B, A.length, B.length);
		
	}
}
