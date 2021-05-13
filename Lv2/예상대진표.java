class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        for(int i =0; i < n/2; i++){
            answer++;
            //a가 짝수일때
            if(a%2 == 0){
                if(a - 1 == b) break;
                a /= 2;

            }else{//a가 홀수일때
                if(a + 1 == b) break;
                a = (a + 1)/2; 
            }

            if(b%2 == 0){
                b /=2;
            }else{
                b = (b + 1)/2; 
            }
        }
        return answer;
    }
}
