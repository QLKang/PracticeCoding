package org.dp;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {

		if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0)
			return 0;

		ArrayList<Integer> preSum = new ArrayList<Integer>();
		preSum.add(triangle.get(0).get(0));

		for (int i = 1; i < triangle.size(); i++) {

			ArrayList<Integer> currSum = new ArrayList<Integer>();
			List<Integer> currList = triangle.get(i);

			for (int j = 0; j < currList.size(); j++) {

				int currVal = 0;

				if (j == 0) {
					currVal = currList.get(j) + preSum.get(j);
				} else if (j == currList.size() - 1) {
					currVal = currList.get(j) + preSum.get(j - 1);
				} else {
					currVal = currList.get(j) + Math.min(preSum.get(j), preSum.get(j - 1));
				}

				currSum.add(currVal);
			}

			preSum = currSum;
		}

		int min = Integer.MAX_VALUE;
		for (Integer ii : preSum) {
			min = Math.min(min, ii);
		}

		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
