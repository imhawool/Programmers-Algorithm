class Solution {
    public String solution(String s) {
        String answer = "";

        String str = s.toLowerCase();
        
        StringBuilder newString = new StringBuilder(str);
        
        if (Character.isLetter(str.charAt(0))){
            newString.setCharAt(0,Character.toUpperCase(newString.charAt(0)));
        }
        int pos = 0;
       
        while(true){
            int findPos = newString.indexOf(" ", pos); 
            
            if (findPos == -1) break;
            pos = findPos + 1;
             newString.setCharAt(findPos + 1, Character.toUpperCase(newString.charAt(findPos + 1))); 
        }
        answer = newString.toString();
        return answer;
    }
}
