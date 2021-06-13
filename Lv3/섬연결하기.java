import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        Comparator<int[]> c1 = (a,b)->{
            return a[2]-b[2];
        };
        Arrays.sort(costs,c1);
        boolean[] bridge = new boolean[costs.length];   
        boolean[] visit = new boolean[n];   
        visit[costs[0][0]] = true;  
        visit[costs[0][1]] = true;
        bridge[0] = true;
        int answer = costs[0][2];  
        int island = 2;    

        while(island<n) {  
            for(int i=1;i<bridge.length;i++) {
                if(!bridge[i] && ((visit[costs[i][0]]&&!visit[costs[i][1]])||(visit[costs[i][1]]&&!visit[costs[i][0]]))) {
                    bridge[i] = true;
                    visit[costs[i][0]] = true;
                    visit[costs[i][1]] = true;
                    island++;
                    answer+=costs[i][2];
                    break;
                }
            }
        }
        return answer;
    }
}
