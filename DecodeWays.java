package org.dp;
/*Decode Ways
 * corner cases
 * 01111 return 0
 * 2300001 return 0
 * 
 * 110
 * 230
 * */
public class DecodeWays {
// failed solution
	public int numDecodings(String s) {
		if (s == null || s.length() == 0)
			return 0;

		char[] A = s.toCharArray();
		if (A[0] == '0')
			return 0;
		int n = s.length();
		int[] sum = new int[n];
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				sum[0] = 1;
			} else if (i == 1) {
				if (A[1] != '0' && (A[0] == '1' || (A[0] == '2' && A[1] <= '6'))) {
					sum[1] = 2;
				} else {
					sum[1] = 1;
				}

			} else {
				if (A[i] == '0' && A[i - 1] == '0') {
					return 0;
				}
				if (A[i] != '0' && (A[i - 1] == '1' || (A[i - 1] == '2' && A[i] <= '6'))) {
					sum[i] = sum[i - 1] + sum[i - 2];
				} else if (A[i] == '0') {  // handle "110", can't handle "230"
					sum[i] = sum[i - 2];
				}

				else {
					sum[i] = sum[i - 1];
				}
			}
		}

		return sum[n - 1];
	}

	public static void main(String[] args) {

		String s = "110";
		DecodeWays sol = new DecodeWays();
		int res = sol.numDecodings(s);
		System.out.println(res);

	}

}
