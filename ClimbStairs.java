package org.dp;

public class ClimbStairs {

	public int climbStairs(int n) {
		int[] c = new int[n+1];
		if(n==0 || n==1 || n==2 )
			return n;
		c[0] = 0;
		c[1] = 1;
		c[2] = 2;
		for(int i = 3; i<=n; i++){
			c[i] = c[i-1] + c[i-2];
		}

		return c[n];
	}

	public static void main(String[] args){
		int n = 5;
		ClimbStairs sol = new ClimbStairs();
		int res = sol.climbStairs(n);
		System.out.println(res);
	}
	
}
