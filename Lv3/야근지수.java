import java.util.PriorityQueue;
import java.util.Collections;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int total = 0;
        for(int i = 0; i < works.length; i++){
            priorityQueue.add(works[i]);
            total += works[i];
        }

        if(n > total){
            return 0;
        }

        while(n > 0){
            int max = priorityQueue.poll(); 

            priorityQueue.add(max - 1);
            n--;
        }

        for(int i = 0; i < works.length; i++){
            answer += Math.pow(priorityQueue.poll(), 2);
        }

        return answer;
    }
}
