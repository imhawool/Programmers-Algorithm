import java.util.Stack;

class Solution {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stk = new Stack<>();
        while(n > 0) {
            int rest = n % k;
            stk.push(rest);
            n /= k;
        }
        while(!stk.isEmpty()) {
            sb.append(stk.pop());
        }

        String converted = sb.toString();
        String[] splited = converted.split("0+");
        int ans = 0;
        for (String s : splited) {
            if(isPrime(Long.parseLong(s))) {
                ++ans;
            }
        }

        return ans;
    }

    public boolean isPrime(long num) {
        if(num == 1) {
            return false;
        } else if(num == 2) {
            return true;
        }

        int limit = (int) Math.sqrt(num);
        for(int i=2; i<=limit; ++i) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
