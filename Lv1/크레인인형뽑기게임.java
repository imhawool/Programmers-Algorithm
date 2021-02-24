import java.util.Stack;

class Solution {
    public Stack<Integer> stack = new Stack<>();
    public int answer = 0;

    public int solution(int[][] board, int[] moves) {
        for(int move : moves){
            for(int i = 0; i<board.length; i++){
                int target = board[i][move-1];
                if(target != 0){
                    stackChk(target);
                    board[i][move-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    public void stackChk(int target){
        if(!stack.empty() && stack.peek() == target){
            stack.pop();
            answer += 2;
        }else{
            stack.push(target);
        }
    }
}
