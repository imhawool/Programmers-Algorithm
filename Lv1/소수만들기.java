class Solution {
    int answer = 0;

    public int solution(int[] nums) {

        int size = nums.length;
        boolean[] visited = new boolean[size];
        combination(nums, visited, 0, size, 3);

        return answer;
    }

    // 조합(순서는 고려하지 않고, n개 중에 r개를 뽑는다)
    private void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sum += arr[i];
                }
            }
            if (isPrime(sum)) answer++;
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    // 소수판별
    private boolean isPrime(int num) {
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
