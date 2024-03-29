class Solution {
    public int solution(String s) {
        for(int i = s.length(); i > 0; i--) { 
            for(int j = 0; j + i <= s.length(); j++) { 
                boolean isPalindrome = true;
                for(int k = 0; k < i / 2; k++) { 
                    if(s.charAt(j + k) != s.charAt(j + i - k - 1)) {
                        isPalindrome = false;
                        break;
                    }
                }
                if(isPalindrome) return i;
            }
        }
        return 1;
    }
}
