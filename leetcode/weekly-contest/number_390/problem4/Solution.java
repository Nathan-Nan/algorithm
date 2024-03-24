package number_390.problem4;


/**
 * <a href="https://leetcode.cn/contest/weekly-contest-390/problems/longest-common-suffix-queries/">...</a>
 */
public class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Node root = new Node();
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(root, wordsContainer[i], wordsContainer[i].length() - 1, i);
        }
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            int[] best = search(root, wordsQuery[i], wordsQuery[i].length() - 1);
            ans[i] = best[1];
        }
        return ans;
    }


    public void insert(Node root, String s, int index, int id) {
        if (index == -1) {
            root.update(new int[]{s.length(), id});
            return;
        }
        int c = s.charAt(index) - 'a';
        Node next = root.getOrCreate(c);
        insert(next, s, index - 1, id);
        root.update(next.best);
    }

    public int[] search(Node root, String s, int index) {
        if (index == -1 || root.getNode(s.charAt(index) - 'a') == null) {
            return root.best;
        }
        return search(root.getNode(s.charAt(index) - 'a'), s, index - 1);
    }

    static class Node {
        Node[] next = new Node[26];
        int[] best = null;

        public Node getNode(int i) {
            return next[i];
        }

        public Node getOrCreate(int i) {
            if (next[i] == null) {
                next[i] = new Node();
            }
            return next[i];
        }

        public void update(int[] cand) {
            if (cand == null) {
                return;
            }
            if (best == null) {
                best = cand;
            } else {
                for (int i = 0; i < 2; i++) {
                    if (best[i] != cand[i]) {
                        if (best[i] < cand[i]) {
                            return;
                        }
                        best = cand;
                        return;
                    }
                }
            }
        }
    }
}


