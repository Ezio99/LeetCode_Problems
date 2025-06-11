package org.hireme.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            for (int i = queue.size(); i > 0; i--) {
                TreeNode curr = queue.poll();
                if (curr == null) {
                    continue;
                }
                level.add(curr.val);
                queue.add(curr.left);
                queue.add(curr.right);
            }
            if (!level.isEmpty()) {
                result.add(level);
            }
        }

        return result;
    }
}
