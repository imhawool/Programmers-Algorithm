class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        int count = 0;
        for(int i = 0; i < s.length();i++)
        {
            if(s.charAt(i) == 'p')
                count++;
            if(s.charAt(i) == 'y')
                count--;
        }
        if(count == 0)
            answer = true;
        else
            answer = false;
        return answer;
    }
}
