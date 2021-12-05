class Solution {
    public int solution(int[] arr) {
        int tmp = arr[0];
        for(int i = 1; i < arr.length; i++){
            int gcd = getGcd(tmp, arr[i]);
            tmp = tmp * arr[i] / gcd;
        }        
        return tmp;
    }
    
    public int getGcd(int x, int y)
    {
        if(x % y == 0) return y;
        return getGcd(y, x%y);
    }
			 
}
