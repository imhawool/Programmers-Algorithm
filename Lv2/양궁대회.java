class Solution {
    int maxPoint = 0;
    int[] result = new int[11];

    public int[] solution(int n, int[] info) {

        dfs(0, info, new int[11], n);

        if (maxPoint == 0){
            return new int[]{-1};
        }
        return result;
    }

    public void dfs(int level, int[] info, int[] player, int n){
        if (level == 11) {
            player[10] += n;
            int diff = difference(info, player);
            if (diff > maxPoint) {
                maxPoint = diff;
                System.arraycopy(player, 0, result, 0, 11);
            }else if (diff == maxPoint) {
                for (int i = 10; i >= 0; i--){
                    if (player[i] == result[i]) continue;

                    if (player[i] > result[i]){
                        System.arraycopy(player, 0, result, 0, 11);
                    } 
                    break;
                }
            }
            player[10] = 0;
            return;
        }

        if(info[level] < n) {
            player[level] = info[level] + 1;
            dfs(level + 1, info, player, n - player[level]);
            player[level] = 0;
        }
        dfs(level + 1, info, player, n);
    }


    public int difference(int[] info, int[] player){
        int dif = 0;
        for (int i = 0; i <= 10; i++) {
            if (player[i] == 0 && info[i] == 0) continue;
            if (player[i] > info[i]){
                dif += 10 - i;
            } else {
                dif -= 10 - i;
            }
        }
        return dif;
    }
}
