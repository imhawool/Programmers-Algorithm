import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {    
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int idx =  A.length - 1;
        for(int i = idx; i > -1; i--){
            if(B[idx] > A[i]){
                answer++;
                idx--;
            }
        }
        return answer;
    }
}
