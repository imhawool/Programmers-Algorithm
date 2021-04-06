class Solution {
    int[] startTimes;
    int[] endTimes;
    public int solution(String[] lines) {
        int answer = 0;

        startTimes = new int[lines.length];
        endTimes = new int[lines.length];

        getTimes(lines, startTimes, endTimes);

        for(int i = 0; i < lines.length; i++){  
            int cnt = 0;
            int startFlag = startTimes[i];
            int endFlag = startFlag + 999; 

            for(int j = 0; j < lines.length; j++){
                if(startFlag <= startTimes[j] && startTimes[j] <= endFlag) cnt++; 
                else if(startFlag <= endTimes[j] && endTimes[j] <= endFlag) cnt++; 
                else if(startFlag >= startTimes[j] && endTimes[j] >= endFlag) cnt++; 
            }
            answer = answer > cnt ? answer : cnt;
        }


        for(int i = 0; i < lines.length; i++){  
            int cnt = 0;
            int startFlag = endTimes[i];
            int endFlag = startFlag + 999; 

            for(int j = 0; j < lines.length; j++){
                if(startFlag <= startTimes[j] && startTimes[j] <= endFlag) cnt++; 
                else if(startFlag <= endTimes[j] && endTimes[j] <= endFlag) cnt++; 
                else if(startFlag >= startTimes[j] && endTimes[j] >= endFlag) cnt++; 
            }
            answer = answer > cnt ? answer : cnt;
        }
        return answer;
    }

    public void getTimes(String[] lines, int[] startTimes, int[] endTimes){
        for(int i = 0; i < lines.length; i++){
            String[] flags = lines[i].split(" ");
            String[] times = flags[1].split(":");
            int processTime = (int)(Double.parseDouble(flags[2].substring(0, flags[2].length()-1))*1000);


            int endTime = Integer.parseInt(times[0])*60*60*1000;
            endTime += Integer.parseInt(times[1])*60*1000;
            endTime += (int)(Double.parseDouble(times[2]) * 1000);;

            int startTime = endTime - processTime + 1;

            startTimes[i] = startTime;
            endTimes[i] = endTime;              
        }
    }

}
