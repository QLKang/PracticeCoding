package org.dp;
/*
 * test cases:
 * coins = {1}, amount = 1
 * coins = {2}, amount = 3
 * coins = Integer.MAX_VALUE
 */


// should consider corner cases
public class CoinChange {
// should pay more attention to the corner case!!!
	
	// correct one
	public int coinChangeII(int[] coins, int amount) {

		if (coins == null || coins.length == 0 || amount <= 0) {
			return 0;
		}

		int[] ss = new int[amount + 1];

		for (int i = 1; i <= amount; i++) {  // i start with 1, since when coin = 5, i =5, ss[0] should be zero.
			ss[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					if (ss[i - coins[j]] != Integer.MAX_VALUE) {   // pay more attention here: ss[i-coins[j]
						ss[i] = Math.min(ss[i], ss[i - coins[j]] + 1);
					}
				}
			} // end for
		} // end for

		if (ss[amount] == Integer.MAX_VALUE) {
			return -1;
		}

		return ss[amount];
	}
 
	
	// incorrect one
	public int coinChange(int[] coins, int amount) {
		if (coins.length == 0 || amount <= 0) {
			return -1;
		}

		int[] dp = new int[amount + 1];
		dp[0] = 0; // do not need any coin to get 0 amount
		for (int i = 1; i <= amount; i++)
			dp[i] = Integer.MAX_VALUE;

		for (int i = 0; i <= amount; i++) {
			for (int coin : coins) {
				if (i + coin <= amount) { // i+coin may overflow!!!!
					if (dp[i] == Integer.MAX_VALUE) {
						dp[i + coin] = dp[i + coin];
					} else {
						dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
					}
				}
			}
		}

		if (dp[amount] == Integer.MAX_VALUE)
			return -1;

		return dp[amount];
	}

	public static void main(String[] args) {
		int[] coins = { 1 };
		int amount = 1;
		CoinChange sol = new CoinChange();
		int res = sol.coinChangeII(coins, amount);
		System.out.println(res);
	}

}
