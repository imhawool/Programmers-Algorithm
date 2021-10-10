class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int i = 1;
        sb.append(0);
        while(sb.length() < m * t) {
            sb.append(conversion(i++,n));
        }
        
        for(int j= p-1; j < m * (t-1) + p; j += m) {
            answer += sb.charAt(j);
        }
        return answer;
    }
    
    
    public StringBuilder conversion(int number, int N){
        StringBuilder sb = new StringBuilder();
	    int current = number;
	    
        while(current > 0){
            if(current % N < 10){
                sb.append(current % N);
                
            } else {
                sb.append((char)(current % N - 10 + 'A'));
            }
            current /= N;
        }
		
		return sb.reverse();
    }
    
}
