package org.dp;

import java.util.ArrayList;

public class UglyNumber {
	/* test case: n = 1, n <=0, n= 7 */
	public int nthUglyNumber(int n) {
		// corner case
		if (n <= 0) {
			return -1;
		}

		if (n == 1) {
			return 1;
		}

		int k = 0;
		int m2 = 0, m3 = 0, m5 = 0;
		int i2 = 0, i3 = 0, i5 = 0;
		int min = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		// 1 is the first ugly number, k is used to count the number of ugly
		// number
		while (k < n - 1) {

			k++;

			m2 = list.get(i2) * 2;
			m3 = list.get(i3) * 3;
			m5 = list.get(i5) * 5;
			min = Math.min(Math.min(m2, m3), m5);
			list.add(min);
			
			if (min == m2) {
				i2++;
			}
			if (min == m3) {
				i3++;
			}
			if (min == m5) {
				i5++;
			}

		}

		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 11;
		UglyNumber sol = new UglyNumber();
		int res = sol.nthUglyNumber(n);
		System.out.println(res);

	}

}
