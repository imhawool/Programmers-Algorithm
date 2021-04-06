import java.util.HashSet;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
		int len = nums.length;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < len; i++){
			set.add(nums[i]);		
		}
		if(set.size() < len/2) answer = set.size();
		else answer = len/2;
        return answer;
    }
}
