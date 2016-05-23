package org.dp;

public class RobHouseI {

	public int rob(int[] nums) {
		if (nums == null)
			return 0;
		int len = nums.length;
		int[] sum = new int[len + 1];
		if (len == 0) {
			return 0;
		}
		sum[0] = nums[0];
		sum[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < len; i++) {
			sum[i] = Math.max(nums[i] + sum[i - 2], sum[i - 1]);
		}
		
		return sum[len-1];
	}

}
