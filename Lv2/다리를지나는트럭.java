import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();

        int max = 0;
        for(int w : truck_weights) {

            while(true) {
                if(q.isEmpty()) {
                    q.offer(w);
                    max += w;
                    answer++;
                    break;
                } else if(q.size() == bridge_length) {
                    max -= q.poll();
                } else {
                    if( max + w > weight) {
                        q.offer(0);
                        answer++;
                    } else {
                        q.offer(w);
                        max += w;
                        answer++;
                        break;
                    }
                }
            } 
        }
        return answer + bridge_length;
    }
}
