class Solution {
    boolean solution(String s) {
       boolean answer = true;
        int ans = 0;

        if(s.charAt(0) == ')')
            return false; 

        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == '(')
                ans++;
            else ans--;

            i++;
            if(ans < 0)
                return false;
        }

        if(ans == 0)
            answer = true;
        else answer = false;

        return answer;
    }
}
