import static java.lang.Math.abs;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {

    public static void main(String [] args) {

        TreeNode root = new TreeNode(1);
        TreeNode leftTree = new TreeNode(2);
        root.left = leftTree;
        TreeNode rightTree4 = new TreeNode(4);
        TreeNode rightTree5 = new TreeNode(5);
        TreeNode rightTree = new TreeNode(3);
        rightTree.left = rightTree4;
        rightTree.right = rightTree5;
        root.right = rightTree;

        Solution a = new Solution();
        System.out.println(a.isBalanced(root));
    }

    class ResultType{
        public boolean isBalance;
        public int depth;
        public ResultType(boolean isBalance, int depth){
            this.isBalance = isBalance;
            this.depth = depth;
        }
    }

    /*
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {

        return helper(root).isBalance;
    }

    public ResultType helper(TreeNode root){


        if(root == null){
            return new ResultType(true,0);
        }

        ResultType leftTree = helper(root.left);
        ResultType rightTree = helper(root.right);


        if(!leftTree.isBalance || !rightTree.isBalance){
            return new ResultType(false,-1);
        }

        if(Math.abs(leftTree.depth - rightTree.depth) > 1){
            return new ResultType(false,-1);
        }

        return new ResultType(true,Math.max(rightTree.depth, leftTree.depth)+1);

    }


}