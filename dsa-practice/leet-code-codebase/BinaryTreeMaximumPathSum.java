class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));

        int currentPath = left + right + root.val;

        maxSum = Math.max(maxSum, currentPath);

        return Math.max(left, right) + root.val;
    }
}
