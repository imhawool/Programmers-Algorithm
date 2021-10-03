import java.util.*;

class Solution {
    
    long answer;
    boolean[] visited;
    long[] weight;
    ArrayList<Integer>[] children;

    public long solution(int[] a, int[][] edges) {
        answer = 0;
        visited = new boolean[a.length];
        children = new ArrayList[a.length];
        weight = new long[a.length];

        long sum = 0;
        for(int i = 0; i < a.length; i++){
            sum += a[i];
            children[i] = new ArrayList<>();
            weight[i] = a[i];
        }

        if(sum != 0) return -1;

        for(int i = 0 ; i < edges.length; i++){
            children[edges[i][0]].add(edges[i][1]);
            children[edges[i][1]].add(edges[i][0]);
        }

        dfs(0);

        return answer;
    }

    public long dfs(int v){
        visited[v] = true;

        for(int i = 0; i < children[v].size(); i++){
            int next = children[v].get(i);
            if(!visited[next]){
                weight[v] += dfs(next);
            }
        }

        answer += Math.abs(weight[v]);

        return weight[v];
    }

}
