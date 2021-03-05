import java.util.PriorityQueue; 
import java.util.Collections;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder());
		
		String operation = "";
		for(int i = 0; i < operations.length; i++){
			if(operations[i].contains("I")){
				operation = operations[i].replaceAll("[I]"," ").trim();
				pq.add(Integer.valueOf(operation));
				rpq.add(Integer.valueOf(operation));
			}else if(!pq.isEmpty()){
				if(operations[i].contains("-1")){
					int min = pq.peek();
					rpq.remove(min);
					pq.remove(min);
				}else{
					int max = rpq.peek();
					rpq.remove(max);
					pq.remove(max);
				}
			}			
		}

		if(pq.isEmpty() || rpq.isEmpty()){
			answer[0] = 0;
			answer[1] = 0;
		}else{
			answer[0] = rpq.peek();
			answer[1] = pq.peek();	
		}
        return answer;
    }
}
