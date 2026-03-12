package Hard;

public class Maximize_Spanning_Tree_Stability_with_Upgrades_3600 {
    static class DSU {
        int[] parent;
        int[] rank;
        int components;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            components = n;
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return false;

            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else if (rank[pa] > rank[pb]) {
                parent[pb] = pa;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }
            components--;
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {
        if (!can(n, edges, k, 1)) return -1;

        int low = 1;
        int high = 200000;
        int ans = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (can(n, edges, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean can(int n, int[][] edges, int k, int target) {
        DSU base = new DSU(n);

        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];
            if (must == 1) {
                if (s < target) return false;
                if (!base.union(u, v)) return false;
            }
        }

        DSU zero = new DSU(n);
        zero.parent = base.parent.clone();
        zero.rank = base.rank.clone();
        zero.components = base.components;

        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];
            if (must == 0 && s >= target) {
                zero.union(u, v);
            }
        }

        int need = zero.components - 1;
        if (need > k) return false;

        DSU all = new DSU(n);
        all.parent = zero.parent.clone();
        all.rank = zero.rank.clone();
        all.components = zero.components;

        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];
            if (must == 0 && s < target && 2L * s >= target) {
                all.union(u, v);
            }
        }

        return all.components == 1;
    }
}
