class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long result = 0;
        long min = 0;
        long max = 400000000000000L;

        while (min <= max){
            long mid = (min + max) /2;

            long gold = 0;
            long silver = 0;
            long total = 0;

            for(int i = 0; i < t.length; i++){
                long gg = g[i];
                long ss = s[i];
                long ww = w[i];
                long tt = t[i];

                long count = mid / (tt * 2);
                if(mid % (tt * 2) >= tt){
                    count++;
                }

                total += Math.min(gg + ss, count * ww);
                gold += Math.min(gg, count * ww);
                silver += Math.min(ss, count * ww);
            }

            if(a+b <= total && a <= gold && b <= silver){
                result = mid;
                max = mid -1;
            }else{
                min = mid +1;
            }
        }

        return result;
    }
}
