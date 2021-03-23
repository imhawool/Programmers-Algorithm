import java.util.Stack;

public class Solution {
    public int[] solution(int []arr) {        
      Stack<Integer> stk = new Stack<Integer>();
        stk.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            if(stk.peek() != arr[i]){
                stk.add(arr[i]);
            }
        }
        int size = stk.size();
        int[] answer = new int[stk.size()];
        for(int i = size-1; i >= 0  ; i--){
            answer[i] = stk.pop();
        }

        return answer;
    }
}
