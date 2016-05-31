package org.dp;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {

		if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0)
			return 0;

		ArrayList<Integer> preSum = new ArrayList<Integer>();
		preSum.add(triangle.get(0).get(0));
		
		int min = 0;
		if(triangle.size()==1){
			min = triangle.get(0).get(0);
		}

		for (int i = 1; i < triangle.size(); i++) {
			
			int localMin = Integer.MAX_VALUE;

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
				localMin = Math.min(currVal, localMin);
				currSum.add(currVal);
			}

			min = localMin;
			preSum = currSum;
		}

		return min;
	}

	
	public static void main(String args[]){
		Triangle sol = new Triangle();
		List<Integer> list = new ArrayList<>();
		list.add(-10);
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(list);
		int res = sol.minimumTotal(triangle);
		System.out.println(res);
	}
	
	
}
