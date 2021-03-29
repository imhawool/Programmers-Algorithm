class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        long square = 0;

        answer = (long)w * (long)h;
        square = w + h - GCD(w,h);
      
        answer -= square;

        return answer;
    }

    public long GCD(long w, long h){ 
       if (w % h == 0) {
            return h;
        }
        return GCD(h, w % h);
    }
}
