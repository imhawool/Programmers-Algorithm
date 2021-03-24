class Solution {
    public String solution(int n) {
        String answer = "";
        String[] number = {"4","1","2"};
        while(n > 0){
            int temp = n % 3;
            n/=3;

            if(temp == 0) n--;
            answer = number[temp] + answer;
        }
        return answer;
    }
}
