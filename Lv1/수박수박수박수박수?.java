class Solution {
    public String solution(int n) {
        String answer = "";
        while(n > 0){
            answer += "수박";
            n -= 2;
        }
        if(n != 0){
            answer = answer.substring(0, answer.length() - 1);
        }
        return answer;
    }
}
