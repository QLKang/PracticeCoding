package org.dp;

class TreeNode {
	int val;
	int sum;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class RobHouseIII {

	public int rob(TreeNode root) {
		if (root == null)
			return 0;
		return robHelp(root);
	}

	private int robHelp(TreeNode p) {
		if (p == null) {
			return 0;
		}
		if (p.sum != 0) {
			return p.sum;
		}
		// case I: do not contain p
		int sl = robHelp(p.left);
		int sr = robHelp(p.right);
		int s1 = sl + sr;

		// case II: contain p
		int sl2 = 0, sr2 = 0;
		if (p.left != null) {
			sl2 = robHelp(p.left.left) + robHelp(p.left.right);
		}
		if (p.right != null) {
			sr2 = robHelp(p.right.left) + robHelp(p.right.right);
		}

		int s2 = p.val + sl2 + sr2;
		p.sum = Math.max(s1, s2);

		return p.sum;
	}

	public static void main(String[] args) {
		TreeNode a1 = new TreeNode(3);
		TreeNode a2 = new TreeNode(2);
		TreeNode a3 = new TreeNode(3);
		TreeNode a4 = new TreeNode(3);
		TreeNode a5 = new TreeNode(1);
		a1.left = a2;
		a1.right = a3;
		a2.right = a4;
		a3.right = a5;
		RobHouseIII sol = new RobHouseIII();
		int res = sol.rob(a1);
		System.out.println(res);
	}

}
