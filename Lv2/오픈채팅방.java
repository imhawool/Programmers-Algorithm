import java.util.HashMap;
class Solution {
    public String[] solution(String[] record) {
        String[] answer ={};
        HashMap<String, String> changeMap = new HashMap<>();
        int cnt = 0;
        String enter = "님이 들어왔습니다.";
        String leave = "님이 나갔습니다.";

        String[][] records = new String[record.length][3];

        for(int i = 0; i < record.length; i++){
            records[i] = record[i].split(" ");  
            if(records[i][0].charAt(0) != 'L'){
                changeMap.put(records[i][1], records[i][2]);
            }
            if(records[i][0].charAt(0) == 'C'){
                cnt++;
            }
        }       
        answer = new String[record.length - cnt];
        int idx = 0;
        for(int i = 0; i < record.length; i++){

            if(records[i][0].charAt(0) == 'E'){
                answer[idx] = changeMap.get(records[i][1]) + enter;
            }else if(records[i][0].charAt(0) == 'L'){
                answer[idx] = changeMap.get(records[i][1]) + leave;
            }else if(records[i][0].charAt(0) == 'C'){
                idx--;
            }
            idx++;
        }
        return answer;
    }
}
