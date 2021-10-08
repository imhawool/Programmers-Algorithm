class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = Integer.bitCount(n);
        for(int i = n + 1; ;i++){
            if(cnt == Integer.bitCount(i))
                return i;     
        }        
    }
}
