package org.dp;

public class UniqueBinarySearchTrees {

	public int numTrees(int n) {
		if (n <= 0)
			return 0;

		int[] s = new int[n + 1];
		s[0] = 1;
		s[1] = 0;  // notice: intial value is 0, will calculate in for loop.

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				s[i] += s[j - 1] * s[i - j];
			}
		}

		return s[n];
	}

	public static void main(String[] args) {
		UniqueBinarySearchTrees sol = new UniqueBinarySearchTrees();
		int n = 4;
		int res = sol.numTrees(n);
		System.out.println(res);
	}

}
