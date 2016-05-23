package org.dp;
// http://www.programcreek.com/2013/02/leetcode-maximum-subarray-java/

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
     if(nums==null || nums.length ==0){
    	 throw new IllegalArgumentException("Error!");
     }
     int n = nums.length;
     int[][] s = new int[n][n];
     
     s[0][0] = nums[0];
     int max = s[0][0];
     for(int i=1; i<n; i++){
    	 s[i][i]=nums[i];
    	 max = Math.max(s[i][i], max);
     }
     
     for(int i=1; i<n-1;i++){
    	 for(int j=i+1; j<n; j++){
    		 s[i][j] = s[i][j-1] + nums[j];
    		 max = Math.max(s[i][j], max);
    	 }
     }
     
     return max;
    }
}
