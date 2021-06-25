import java.util.*;
class Solution {
    int answer = 0;
	String table[][];
	ArrayList<HashSet<Integer>> candidateKey;
    public int solution(String[][] relation) {
        candidateKey = new ArrayList<HashSet<Integer>>();
		table = relation;
		int len = relation[0].length;
		int[] arr = new int[len];
		for(int i = 0; i < len; i++){
			arr[i] = i;
		}
		boolean[] visited = new boolean[arr.length];

		for(int i = 1; i <= relation[0].length; i++){
			comb(arr, visited, 0, i);
		}
        return answer;
    }
    
    public void comb(int[] arr, boolean[] visited, int start, int r) {
        if(r == 0) {
        	HashSet<Integer> set = new HashSet<Integer>();
        	for(int i = 0; i < arr.length; i++) {
                if(visited[i] == true){
                	set.add(arr[i]);
                }               
            }
        	
        	if(chk(set)) {
        		for(HashSet<Integer> key: candidateKey) { 
        			if(set.containsAll(key)) {
        				return;
        			}
        		}
        		candidateKey.add(set);    		
        		answer++;
        	}
            return;
        } else {
            for(int i = start; i < arr.length; i++) {
                visited[i] = true;
                comb(arr, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }
    
    public boolean chk(HashSet<Integer> set) {
		ArrayList<String> list = new ArrayList<String>();
    	for(int i = 0; i < table.length; i++) {
    		String temp = "";
    		for(int index: set) {
    			temp+= table[i][index];
    		}
    		if(!list.contains(temp)) {
    			list.add(temp);
    		}else {
    			return false;
    		}
    	}
    	return true;
    }
}
