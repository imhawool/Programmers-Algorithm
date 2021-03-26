class Solution {
    public int solution(int n) {
        int answer = 0;
        String ans = "";
        
        while(n > 0){
            ans = (n % 3) + ans;
            n /=3;
        }
        
        ans = new StringBuilder(ans).reverse().toString();        
        
        answer = Integer.parseInt(ans,3);
        return answer;
    }
}
