import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] stringtoChar = s.toCharArray();
        Arrays.sort(stringtoChar);
        answer = new String(stringtoChar);
        StringBuffer stringBuffer = new StringBuffer(answer);
        answer = stringBuffer.reverse().toString();

        return answer;
    }
}
