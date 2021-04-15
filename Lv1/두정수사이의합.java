class Solution {
    public long solution(int a, int b) {
        int max = Math.max(a,b);
        int min = Math.min(a,b);

        long answer = max;
        while(max > min){
            max--;
            answer += max;          
        }
        return answer;
    }
}
