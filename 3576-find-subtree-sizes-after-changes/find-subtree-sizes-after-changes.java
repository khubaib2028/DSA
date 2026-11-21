class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> origTree = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            origTree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            origTree.get(parent[i]).add(i);
        }

        int[] newParent = Arrays.copyOf(parent, n);
        @SuppressWarnings("unchecked")
        Deque<Integer>[] ancestorStack = new ArrayDeque[26];
        for (int c = 0; c < 26; c++) {
            ancestorStack[c] = new ArrayDeque<>();
        }

        reassignParents(0, s, origTree, ancestorStack, newParent);

        List<List<Integer>> finalTree = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            finalTree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            finalTree.get(newParent[i]).add(i);
        }

        int[] ans = new int[n];
        computeSubtreeSizes(0, finalTree, ans);
        return ans;
    }

    private void reassignParents(
            int u,
            String s,
            List<List<Integer>> origTree,
            Deque<Integer>[] ancestorStack,
            int[] newParent) {
        int idx = s.charAt(u) - 'a';
        if (!ancestorStack[idx].isEmpty()) {
            newParent[u] = ancestorStack[idx].peek();
        }

        ancestorStack[idx].push(u);
        for (int v : origTree.get(u)) {
            reassignParents(v, s, origTree, ancestorStack, newParent);
        }
        ancestorStack[idx].pop();
    }

    private int computeSubtreeSizes(int u, List<List<Integer>> finalTree, int[] ans) {
        int size = 1;
        for (int v : finalTree.get(u)) {
            size += computeSubtreeSizes(v, finalTree, ans);
        }
        ans[u] = size;
        return size;
    }
}