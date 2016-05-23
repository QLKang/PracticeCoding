package org.dp;

/*Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int max = 0;
		int n = nums.length;
		int[] s = new int[n];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					s[i] = Math.max(s[j] + 1, s[i]);
				}
			}
			max = Math.max(s[i], max);
		}

		return max+1;
	}

}