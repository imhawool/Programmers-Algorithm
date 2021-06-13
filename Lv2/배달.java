class Solution {
    public int solution(int N, int[][] road, int K) {

        int[][] map = new int[N][N];                                       
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (i == j) {                                               
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = 500001;                                         
            }
        }
 
        for (int i = 0; i < road.length; i++) {
            if(map[road[i][0] - 1][road[i][1] - 1] < road[i][2])  continue; 
            map[road[i][0] - 1][road[i][1] - 1] = road[i][2];               
            map[road[i][1] - 1][road[i][0] - 1] = road[i][2];
        }
        
        for (int k = 0; k < N; k++) {                                       
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(i == j) continue;
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
 
        int answer = 0;                                                       
 
        for (int i = 0; i < map[0].length; i++) {
            if (map[0][i] <= K) 
                answer++;
        }
        return answer;
    }
}
