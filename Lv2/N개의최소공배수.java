class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i = 0; i < arr.length; i++){
            int num = gcd(answer, arr[i]);
            answer = answer * arr[i] / num;  
        }
        return answer;
    }
    
    public int gcd(int a, int b) {
			 while(b!=0) {
				 int r=a%b;
				 a=b;
				 b=r;
			 }
			 return a;
		 }
}
