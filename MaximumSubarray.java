package org.dp;
// http://www.programcreek.com/2013/02/leetcode-maximum-subarray-java/

/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			throw new IllegalArgumentException("Error!");
		}
		int n = nums.length;
		int[] s = new int[n];
		int max = nums[0];
		s[0] = nums[0];
		for (int i = 1; i < n; i++) {
			s[i] = Math.max(nums[i], nums[i] + s[i - 1]);
			max = Math.max(max, s[i]);
		}
		return max;
	}
}
