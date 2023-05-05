package com.company.v2.릿코드.알고리즘.medium;

public class _1339 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static long allSum = 0;
    private static long maxProduct = 0;

    public int maxProduct(TreeNode root) {
        allSum = sum(root);
        getMaxProduct(root);

        return (int) (maxProduct % (int)(Math.pow(10, 9) + 7));
    }

    private static long sum(TreeNode node) {
        if(node == null) return 0;

        long leftSum = sum(node.left);
        long rightSum = sum(node.right);

        return leftSum + rightSum + node.val;
    }

    private static long getMaxProduct(TreeNode node) {
        if(node == null) return 0;

        long leftSum = getMaxProduct(node.left);
        long rightSum = getMaxProduct(node.right);

        long curSum = leftSum + rightSum + node.val;
        maxProduct = Math.max(maxProduct, curSum * (allSum - curSum));

        return curSum;
    }
}
