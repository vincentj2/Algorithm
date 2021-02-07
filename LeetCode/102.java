package Algorthm.LeetCode;//102. Binary Tree Level Order Traversal
//bfs + queue
/*
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
*/

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

public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        if(root== null) return answer;

        queue.offer(root);


        while (!queue.isEmpty()){
        level = queue.size();
        List<Integer> sublist = new ArrayList<>();
        for(int i=level; i>0; i--){
        if(queue.peek().left != null){
        queue.offer(queue.peek().left);
        }
        if(queue.peek().right !=  null){
        queue.offer(queue.peek().right);
        }
        sublist.add(queue.poll().val);
        }
        answer.add(sublist);
        }
        return answer;
        }