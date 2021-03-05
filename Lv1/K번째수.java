import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int size = commands.length;
		int[] answers = new int[size];	
		
		for (int i = 0; i < commands.length ; i++){
			int[] splitArray = Arrays.copyOfRange(array, commands[i][0]-1,commands[i][1]);
			Arrays.sort(splitArray);
			answers[i] = splitArray[(commands[i][2]) - 1];
		}
        return answers;
    }
}
