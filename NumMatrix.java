package org.dp;

public class NumMatrix {
	int m;
	int n;
	static int[][] sum;

	public NumMatrix(int[][] matrix) {
		matrix = new int[m][n];
	}

	int[][] calculate(int[][] mat, int m, int n) {
		sum = new int[m][n];
		for (int j = 0; j < n; j++) {
			if (j == 0) {
				sum[0][0] = mat[0][0];
			} else {
				sum[0][j] = sum[0][j - 1] + mat[0][j];
			}
		}
		for (int i = 0; i < m; i++) {
			if (i == 0) {
				sum[0][0] = mat[0][0];
			} else {
				sum[i][0] = sum[i - 1][0] + mat[i][0];
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i][j];
			}
		}
		return sum;
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		// corner case
		if (row1 == 0 && col1 == 0)
			return sum[row2][col2];
		else if (row1 == 0) {
			return sum[row2][col2] - sum[row2][col1 - 1];
		} else if (col1 == 0) {
			return sum[row2][col2] - sum[row1 - 1][col2];
		} else {
			return sum[row2][col2] - sum[row1 - 1][col2] - sum[row2][col1 - 1] + sum[row1 - 1][col1 - 1];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
