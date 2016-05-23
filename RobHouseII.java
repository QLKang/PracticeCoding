package org.dp;

public class RobHouseII {

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		if (nums.length == 3)
			return Math.max(Math.max(nums[0], nums[1]), nums[2]);
		int s1 = robHelp(nums, 0, nums.length - 2);
		int s2 = robHelp(nums, 1, nums.length - 1);
		return Math.max(s1, s2);
	}

	private int robHelp(int[] A, int start, int end) {

		int[] s = new int[A.length];
		for (int i = start; i <= end; i++) {
			if (i == start) {
				s[i] = A[start];
			} else if (i == start + 1) {
				s[i] = Math.max(A[start], A[start + 1]);
			} else {
				s[i] = Math.max(A[i] + s[i - 2], s[i - 1]);
			}
		}
		return s[end];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 5, 9, 2, 6 };
		RobHouseII sol = new RobHouseII();
		int res = sol.rob(nums);
		System.out.println(res);

	}

}
