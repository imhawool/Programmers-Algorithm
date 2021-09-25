import java.util.*;
class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        List<Integer> list = new ArrayList();
        
        int idx = 0;
        for(int i = 0; i < enter.length; i++){
            list.add(enter[i]);
            for(int j = 0; j < list.size(); j++){
                if(enter[i] == list.get(j)){
                    answer[list.get(j)-1] = list.size()-1;
                }else{
                    answer[list.get(j)-1]++;
                }          
            }
            while(idx < answer.length && list.contains(leave[idx])){
                list.remove(Integer.valueOf(leave[idx++]));
            }
        }
        
        return answer;
    }
}
