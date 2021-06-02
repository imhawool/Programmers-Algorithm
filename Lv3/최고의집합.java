import java.util.Arrays;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {};
        int ans = s/n;
        if(s <= 1 || n > s){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        answer = new int[n];
        for(int i = 0; i < n; i++){
            answer[i] = ans;
        }

        for(int i = 0; i < s%n; i++){
            answer[i]++;
        }
        Arrays.sort(answer);
        return answer;
    }
}
