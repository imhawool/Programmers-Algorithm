import java.util.Arrays;
class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);

        long min, mid, max;
        min = 1;
        max = (long)n * (long)times[times.length -1];
        long sum = 0;

        while(min <= max){
            sum = 0;
            mid = (min + max)/2; 

            for(int i = 0 ; i < times.length; i++){
                sum += mid/times[i];

                if(sum >= n)
                    break;
            }

            if(sum < n ){
                min = mid + 1;
            }else{
                max = mid - 1;
                answer = Math.min(answer, mid);
            }
        }
        return answer;
    }
}
