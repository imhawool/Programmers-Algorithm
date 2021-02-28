class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean chk[] = new boolean[n];
        for(int i = 0; i<n; i++){
            if(!chk[i]){
                dfs(computers, i, chk);
                answer++;              
            }           
        }
        return answer;
    }
  
    public boolean[] dfs(int[][]computers,int i, boolean[] check){
        check[i] = true;

    for (int j = 0; j < computers.length; j++) {
      if (i != j && computers[i][j] == 1 && check[j] == false) {
        check = dfs(computers, j, check);
      }
    }
    return check;
    }
        
}
