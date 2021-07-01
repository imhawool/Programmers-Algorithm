import java.util.Queue;
import java.util.LinkedList;

class Solution {
    boolean[][] isVisted;
    int answer = Integer.MAX_VALUE;;
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public int solution(int[][] maps) {
        isVisted = new boolean[maps.length][maps[0].length];

        bfs(maps);
        if(answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }

    public void bfs(int[][] maps){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1));
        isVisted[0][0] = true;

        while(!queue.isEmpty()){
            Point point = queue.poll();

            if(point.r == maps.length - 1 && point.c == maps[0].length - 1){
                answer = Math.min(answer, point.score);
                return;
            }

            for(int i = 0; i < 4; i++){
                int r2 = point.r + dr[i];
                int c2 = point.c + dc[i];

                if(r2 >= 0 && r2 < maps.length && c2 >= 0 && c2 < maps[0].length && !isVisted[r2][c2] && maps[r2][c2] == 1){
                    queue.add(new Point(r2, c2, point.score + 1));
                    isVisted[r2][c2] = true;
                }
            }
        }
    }

    public class Point{
        int r = 0;
        int c = 0;
        int score = 0;

        Point(int r, int c, int score){
            this.r = r;
            this.c = c;
            this.score = score;
        }
    }
}
