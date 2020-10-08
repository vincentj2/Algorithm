//104   Maximum Depth of Binary Tree
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
public int maxDepth(TreeNode root) {
        int max =0;

        if(root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> cntStack = new Stack<>();

        stack.push(root);
        cntStack.push(1);

        while(!stack.isEmpty()){
        TreeNode node = stack.pop();
        int cnt = cntStack.pop();
        max = Math.min(max,cnt);
        if(node.left != null){
        stack.push(node.left);
        cntStack.push(cnt+1);
        }
        if(node.right != null){
        stack.push(node.right);
        cntStack.push(cnt+1);
        }
        }
        return max;
        }