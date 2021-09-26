class Solution {
    public String solution(String s) {
        String answer = "";

        s = s.toLowerCase();
        String[] str = s.split(" ");
        
        for(int i = 0;i < str.length;i++){  
            if ("".equals(str[i])) { 
                answer += str[i];
            }else('a' <= str[i].charAt(0) && str[i].charAt(0) <= 'z'){
                answer += Character.toUpperCase(str[i].charAt(0)) +str[i].substring(1);
            }else {
                answer += str[i];
            }

            if(i + 1 != str.length){
                answer += " ";
            }
        }
		
        if(s.charAt(s.length() - 1) == ' '){
            answer += " ";
        }
        return answer;
    }
}
