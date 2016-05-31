package org.dp;
// need to implement again
import java.util.Arrays;

public class PerfectSquares {
	public int numSquares(int n) {
		int dp[] = new int[n + 1];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		for (int i = 1; i * i <= n; i++) {
			dp[i * i] = 1;
		}
		for (int i = 1; i <= n; i++) {

			System.out.println("for loop --i=" + i + "---");

			for (int j = 1; i + j * j <= n; j++) {

				System.out.println("i=" + i + ", j=" + j);
				int tmp1 = dp[i] + 1;
				int tmp2 = dp[i + j * j];

				dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);

				System.out.println("min(" + tmp1 + ", " + tmp2 + ")");
				int k = i + j * j;
				System.out.println("i+j*j=" + k + ", dp[" + k + "]=" + dp[k]);
			}
			System.out.println();
		}
		return dp[n];
	}

	public static void main(String[] args) {
		PerfectSquares sol = new PerfectSquares();
		int res = sol.numSquares(13);
		System.out.println(res);
	}
/* help to understand the algorithm
	for loop --i=1---
			i=1, j=1
			min(2, 2147483647)
			i+j*j=2, dp[2]=2
			i=1, j=2
			min(2, 2147483647)
			i+j*j=5, dp[5]=2
			i=1, j=3
			min(2, 2147483647)
			i+j*j=10, dp[10]=2

			for loop --i=2---
			i=2, j=1
			min(3, 2147483647)
			i+j*j=3, dp[3]=3
			i=2, j=2
			min(3, 2147483647)
			i+j*j=6, dp[6]=3
			i=2, j=3
			min(3, 2147483647)
			i+j*j=11, dp[11]=3

			for loop --i=3---
			i=3, j=1
			min(4, 1)
			i+j*j=4, dp[4]=1
			i=3, j=2
			min(4, 2147483647)
			i+j*j=7, dp[7]=4
			i=3, j=3
			min(4, 2147483647)
			i+j*j=12, dp[12]=4

			for loop --i=4---
			i=4, j=1
			min(2, 2)
			i+j*j=5, dp[5]=2
			i=4, j=2
			min(2, 2147483647)
			i+j*j=8, dp[8]=2
			i=4, j=3
			min(2, 2147483647)
			i+j*j=13, dp[13]=2

			for loop --i=5---
			i=5, j=1
			min(3, 3)
			i+j*j=6, dp[6]=3
			i=5, j=2
			min(3, 1)
			i+j*j=9, dp[9]=1

			for loop --i=6---
			i=6, j=1
			min(4, 4)
			i+j*j=7, dp[7]=4
			i=6, j=2
			min(4, 2)
			i+j*j=10, dp[10]=2

			for loop --i=7---
			i=7, j=1
			min(5, 2)
			i+j*j=8, dp[8]=2
			i=7, j=2
			min(5, 3)
			i+j*j=11, dp[11]=3

			for loop --i=8---
			i=8, j=1
			min(3, 1)
			i+j*j=9, dp[9]=1
			i=8, j=2
			min(3, 4)
			i+j*j=12, dp[12]=3

			for loop --i=9---
			i=9, j=1
			min(2, 2)
			i+j*j=10, dp[10]=2
			i=9, j=2
			min(2, 2)
			i+j*j=13, dp[13]=2

			for loop --i=10---
			i=10, j=1
			min(3, 3)
			i+j*j=11, dp[11]=3

			for loop --i=11---
			i=11, j=1
			min(4, 3)
			i+j*j=12, dp[12]=3

			for loop --i=12---
			i=12, j=1
			min(4, 2)
			i+j*j=13, dp[13]=2

			for loop --i=13---

			2	
			*/
}
