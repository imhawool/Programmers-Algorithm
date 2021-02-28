import java.util.ArrayList;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
		int[] time = new int[len];
		
		for(int i = 0; i<len; i++){
			int n = 1;
			while(progresses[i]+(speeds[i]*n) < 100){
				n++;
			}
			time[i] = n;			
		}
	
		ArrayList<Integer> list = new ArrayList<>();
		int i = 0;
		while(i < len){
			int tmp = time[i];
			int cnt = 0;
			while(i < len && tmp >= time[i]){
				cnt++;
				i++;
			}
			list.add(cnt);
			cnt = 0;
		}
		
		int[] answer = new int[list.size()];
		for(int k =0; k<list.size(); k++){
			answer[k] = list.get(k);
		}
        return answer;
    }
}
