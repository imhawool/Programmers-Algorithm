import java.util.Stack;
class Solution {
    int answer = 0;
    public int solution(String s) {
        StringBuffer sb = new StringBuffer(s);

        for(int i = 0; i < s.length(); i++){
            check(sb);
            sb.append(sb.charAt(0)).deleteCharAt(0);
        }
        return answer;
    }

    public void check(StringBuffer sb){
        Stack<Character> stack = new Stack<Character>();
        int a = 0, b = 0, c = 0;
        for(int i =0; i< sb.length(); i++){
            char ch = sb.charAt(i);
            switch(ch){

            case '(' :
                stack.push(ch);
                a++;
                break;
            case ')' :
                if(stack.size() == 0 || stack.pop()!= '('){
                    return;
                }else{
                    a--;
                }
                break;
            case '{' :
                stack.push(ch);
                b++;
                break;
            case '}' :
                if(stack.size() == 0 || stack.pop()!= '{'){
                    return;
                }else{
                    b--;
                }
                break;
            case '[' :
                stack.push(ch);
                c++;
                break;
            case ']' :
                if(stack.size() == 0 || stack.pop()!= '['){
                    return;
                }else{
                    c--;
                }
                break;
            }

        }
        if(a == 0 && b == 0 && c == 0){
            answer++;
        }
    }
}
