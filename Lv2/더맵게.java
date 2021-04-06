import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
       int answer = 0;
        int mix = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            priorityQueue.add(scoville[i]);
        }

        while(priorityQueue.peek() < K){
            if(priorityQueue.size() == 1){
                answer = -1;
                break;
            }
            mix = priorityQueue.poll() + (priorityQueue.poll()*2);  
            priorityQueue.add(mix);
            answer++;
        }
        return answer;
    }
}
