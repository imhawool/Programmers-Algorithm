import java.util.PriorityQueue;
import java.util.Arrays;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int cnt = 0; 
		int idx = 0; 
      
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
		int end = jobs[idx][0];; 
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); 

		while(cnt < jobs.length){			
		
			while(idx < jobs.length && jobs[idx][0] <= end){
				pq.add(jobs[idx++]);
			}
			
			if(!pq.isEmpty()){
				int[] temp = pq.poll();
				answer += temp[1] + end - temp[0];
				end += temp[1];
				cnt++;
			}else{
				end = jobs[idx][0];
			}
			
		}        
        return (int)(answer/jobs.length);
    }
}
