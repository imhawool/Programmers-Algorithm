class Solution {
    boolean[][] map = new boolean[51][51];
    boolean[][] v= new boolean[51][51];
    int check;
    int sum = -1;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        for(int[] arr : rectangle){
            for(int i = arr[1]; i < arr[3]; i++){
                for(int j = arr[0]; j < arr[2]; j++){
                    map[i][j] = true;
                }
            }
        }
        dfs(characterY, characterX, itemY, itemX);
        answer = Math.min(sum + 1 - check, check);
        return answer;
    }
    public int dfs(int x, int y, int tx, int ty){
        v[x][y] = true;
        sum++;
        if(x == tx && y == ty)
          check = sum;

        int[] move = {-1,1,0,0};
        int[][] dms = {{-1,-1,-1,0}, {0,0,0,-1}, {-1,-1,0,-1}, {-1,0,0,0}};
        for(int i = 0; i < 4; i++){
            int dx = x+move[i];
            int dy = y+move[(i+2)%4];
            if(dx>=1 && dx<=50 && dy>=1 && dy<=50){
                int b1x = x + dms[i][0];
                int b1y = y + dms[i][1];
                int b2x = x + dms[i][2];
                int b2y = y + dms[i][3];

                if(!v[dx][dy] && (map[b1x][b1y] != map[b2x][b2y])){
                    dfs(dx, dy, tx, ty);
                }
            }
        }
        return sum;
    }
}
