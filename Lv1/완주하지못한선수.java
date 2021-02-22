import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> participantMap = new HashMap<>();
        for (int i = 0; i < participant.length; i++){
            if (participantMap.containsKey (participant[i])){
                participantMap.put(participant[i], participantMap.get(participant[i]) +1);
            }else {
                participantMap.put(participant[i], 1);
            }
        }
        for (int i = 0; i < completion.length; i++){
            if (participantMap.containsKey (completion[i])){
                if(participantMap.get(completion[i]) > 1){
                    participantMap.put(completion[i], participantMap.get(completion[i]) - 1);
                }else{
                    participantMap.remove(completion[i]);
                }              
            }
        }
        
        for(Map.Entry<String, Integer> elem: participantMap.entrySet()){
            answer = elem.getKey();
        }
        return answer;
    }
}
