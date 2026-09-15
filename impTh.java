import java.util.*;
public class impTh {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return l;
        }
        q.add(root);
        q.add(null);

        List<Integer> temp = new ArrayList<>();


        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    l.add(new ArrayList<>(temp));
                    temp.clear();
                    break;
                }else{
                    l.add(new ArrayList<>(temp));
                    temp.clear();
                    q.add(null);
                }
            }else{
                temp.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return l;
        // In Java, when working with a List<List<Integer>>, a common pitfall occurs if we try to add a temporary list (temp) to the main list and then clear or reuse temp. This happens because lists are reference types in Java, meaning l.add(temp) adds a reference to the same list object. If we then call temp.clear(), it also clears the list inside l, resulting in empty sublists. The correct approach is to add a copy of temp using l.add(new ArrayList<>(temp)), which creates a new independent list containing the current elements. In the context of level-order traversal of a binary tree, we use a queue to process nodes level by level. At the end of each level (often marked by a null in the queue), we add a copy of the current temp list to the result list and then clear temp for the next level. This ensures each level’s values are stored correctly and avoids the reference-sharing pitfall. For example, in the traversal code, only the current node’s value is added to temp, and its children are enqueued but not added immediately; when a null is reached, l.add(new ArrayList<>(temp)) safely stores that level, and temp.clear() prepares for the next one.

        //this way we create a copy of the temp array in memeory -> pass the array name as argument -> in built constructor makes a new array with same elements -> if we do this using a varible -> then it will store the reference and not actually create a copy

        // In a level-order traversal of a binary tree using a queue, we often use a temp list to store the values of nodes at the current level and a null marker to indicate the end of a level. For each node dequeued, we add its value to temp and enqueue its children without adding their values yet. When a null marker is reached, it signals the end of the current level, so we add a copy of temp to the main list and clear temp for the next level. A common bug occurs when handling the last level: if the queue becomes empty immediately after removing the final null marker, some implementations break the loop without adding the last temp list. This causes the last level’s values to be skipped in the result. The fix is to always add temp to the result when a null marker is dequeued, and only add a new null marker if the queue still contains nodes, ensuring that every level, including the last one, is recorded correctly.
    }
    public static void main(String[] args) {
        
    }
}
