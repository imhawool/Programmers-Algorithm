class Solution {
    int[] answer = new int[2];
    public int[] solution(String s) {
		
		while(!"1".equals(s)){
			int cnt = 0;
			cnt = (int) s.chars()
					.filter(c -> c == '0')
					.count();
			
			s = toBinary(s.length() - cnt);
			answer[1] += cnt;
			answer[0]++;
		}
        return answer;
    }
    public String toBinary(int num){
		String str = Integer.toBinaryString(num);
		return str;
	}
}
