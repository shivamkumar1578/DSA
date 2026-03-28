package Hard;
class DSU{
        int[] parent;
        int[] rank;
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
        }
        int find(int x){
            if(parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        void union(int a, int b){
            int pa = find(a);
            int pb = find(b);
            if(pa == pb) return;
            if(rank[pa] < rank[pb]){
                parent[pa] = pb;
            }else if(rank[pa] > rank[pb]){
                parent[pb] = pa;
            }else{
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    

public class Find_the_String_with_LCP_2573 {
class Solution {
    
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        for(int i = 0; i < n; i++){
            if(lcp[i][i] != n - i) return "";
            for(int j = 0; j < n; j++){
                if(lcp[i][j] != lcp[j][i]) return "";
            }
        }
        DSU dsu = new DSU(n);
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(lcp[i][j] > 0){
                    dsu.union(i, j);
                }
            }
        }
        char[] word = new char[n];
        Arrays.fill(word, '#');
        Map<Integer, Character> map = new HashMap<>();
        char ch = 'a';
        for(int i = 0; i < n; i++){
            int root = dsu.find(i);
            if(!map.containsKey(root)){
                if(ch > 'z') return "";
                map.put(root, ch++);
            }
            word[i] = map.get(root);
        }
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                boolean same = word[i] == word[j];
                if(same && lcp[i][j] == 0) return "";
                if(!same && lcp[i][j] > 0) return "";
            }
        }
        int[][] dp = new int[n + 1][n + 1];
        for(int i = n - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(word[i] == word[j]){
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
                if(dp[i][j] != lcp[i][j]) return "";
            }
        }
        return new String(word);
    }
}
}
}
