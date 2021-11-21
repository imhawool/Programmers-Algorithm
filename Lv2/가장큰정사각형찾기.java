class Solution
{
    public int solution(int [][]board)
    {
        int[][] board_new = new int[board.length + 1][board[0].length + 1];
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[i].length; j++)
                board_new[i + 1][j + 1] = board[i][j];
        
        int max = 0;        
        for(int i = 1; i < board_new.length; i++){
            for(int j = 1; j<board_new[i].length; j++){ 
                if(board_new[i][j] == 1){
                    int left = board_new[i-1][j];    
                    int up = board_new[i][j-1];      
                    int cross = board_new[i-1][j-1];
                    int min = Math.min(left, Math.min(up, cross)); 
                    board_new[i][j] = min+1;
                    max = Math.max(max, min+1);
                }
            }
        }
        int answer = max * max;
        return answer;
    }
}
