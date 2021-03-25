class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
		
		for(int i = 0; i < new_id.length(); i++){
			char c = new_id.charAt(i);
			if('a' <= c && c <= 'z'){
				answer += c;
			}else if('0' <= c && c <= '9'){
				answer += c;
			}else if(c == '-' || c == '_'){
				answer += c;
			}else if(c == '.'){
				if(answer.length() == 0){
					answer += c;
				}else if(answer.charAt(answer.length() - 1) != '.'){
					answer += c;
				}					
			}			
		}

		if(answer.charAt(0) == '.'){
			answer = answer.substring(1);
		}
		if(answer.length() != 0 && answer.charAt(answer.length() - 1) == '.'){
			answer = answer.substring(0,answer.length() - 1);
		}
		
		if(answer.length() == 0) answer = "a";
		
		if(answer.length() >= 16){
			answer = answer.substring(0,15);
			if(answer.charAt(answer.length() - 1) == '.'){
				answer = answer.substring(0,answer.length() - 1);
			}
		}
		
		while(answer.length() < 3){
			answer += answer.charAt(answer.length() - 1);
		}
        return answer;
    }
}
