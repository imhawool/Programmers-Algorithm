import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        int n = s.length;
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            int m = s[i].length();
            List<Character> a = new ArrayList<>();
            int c = 0;
            for (int j = 0; j < m; j++) {
                a.add(s[i].charAt(j));
                int l = a.size();
                while (l > 2 && a.get(l - 3) == '1' && a.get(l - 2) == '1' && a.get(l - 1) == '0') {
                    c++;
                    a.remove(l - 1);
                    a.remove(l - 2);
                    a.remove(l - 3);
                    l -= 3;
                }
            }
            if (c > 0) {
                char [] x = new char[m];
                int o = 0;
                int r = a.size();
                while (r > 0 && a.get(r - 1) == '1') {
                    r--;
                }
                for (int j = 0; j < r; j++) {
                    x[o++] = a.get(j);
                }
                for (int j = 0; j < c; j++) {
                    x[o++] = '1';
                    x[o++] = '1';
                    x[o++] = '0';
                }
                while (r < a.size()) {
                    x[o++] = a.get(r++);
                }
                answer[i] = new String(x);
            } else {
                answer[i] = s[i];
            }
        }
        return answer;
    }
}
