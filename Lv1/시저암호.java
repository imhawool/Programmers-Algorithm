class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i); 
            if(Character.isUpperCase(c)){
                int num = (int)c + n;
                if(num > 90){
                    num = num - 90 + 64;
                }
                answer += (char)num;
            }else if(Character.isLowerCase(c)){
                int num = (int)c + n;
                if(num > 122){
                    num = num - 122 + 96;
                }
                answer += (char)num;
            }else{
                answer += " ";
            }

        }
        return answer;
    }
}
