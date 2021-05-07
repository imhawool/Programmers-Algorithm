import java.util.Stack;
class Solution
{
    public int solution(String s)
    {
       int answer = 1;

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for(int i = 1; i < s.length(); i++){
            if(stack.size() == 0 || stack.peek() != s.charAt(i)){
                stack.push(s.charAt(i));
            }else{
                stack.pop();
            }
        }

        if(stack.size() == 0) answer = 1;
        else answer = 0;
        return answer;
    }
}
