class Solution {
    public int solution(String name) {
       int answer = 0;
       int len = name.length();
       int move = len - 1;

       for (int i=0; i<len; i++) {
			if( name.charAt(i) < 78 ) answer += name.charAt(i) % 65;
			else answer += 91 - name.charAt(i);

			int next = i + 1;
			while(next < len && name.charAt(next) == 'A')
				next++;         

			move = Math.min(move, i+len-next + i);          
       }
       answer += move;
       return answer;
    }
}
