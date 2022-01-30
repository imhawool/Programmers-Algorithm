import java.util.Arrays;
class Solution {
  public String solution(int n, int t, int m, String[] timetable) {
      String answer = "";
      int[] times = new int[timetable.length];
      for(int i = 0; i < timetable.length; i++) {
          String[] timeAndMinute = timetable[i].split(":");
          times[i] = Integer.parseInt(timeAndMinute[0]) * 60 + Integer.parseInt(timeAndMinute[1]);
      }
      Arrays.sort(times);

      int busTimeLimit = 9 * 60, index = 0, person = 0;
      for(int i = 0; i < n; i++) {
          person = 0;
          for(int j = index; j < times.length; j++) {
              if(times[j] <= busTimeLimit) {
                  person++;
                  index++;
                  if(person == m) {
                      break;
                  }
              }
          }
          busTimeLimit += t;
      }
      int result = 0;
      if(person < m) {
          result = busTimeLimit - t;
      }else {
          result = times[index - 1] - 1;
      }
      answer = ((result / 60) < 10 ? "0" + (result / 60) : (result / 60)) + ":" + ((result % 60) < 10 ? "0" + (result % 60) : (result % 60));
      return answer;
  }
}
