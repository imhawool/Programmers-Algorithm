import java.util.*;
class Solution {
	public long answer = Long.MIN_VALUE;
	
	public ArrayList<Long> numList = new ArrayList<>();  
	public ArrayList<String> operList = new ArrayList<>(); 
	
	public String[] oper = {"+", "-", "*"};
	public String[] output = new String[3];  
	public boolean[] visited = new boolean[3]; 
    
    public long solution(String expression) {
		String n = "";
		for(int i = 0; i < expression.length(); i++) {
			char exp = expression.charAt(i);
			if(exp == '+' || exp == '-' || exp == '*') {
				operList.add(exp + "");
				numList.add(Long.parseLong(n));
				n = "";
			} else {
				n += exp;
			}
		}  
		numList.add(Long.parseLong(n));
		per(0, oper.length);
		
		return answer;
	}

	public void per(int depth, int r) {
		if(depth == r) {
			solve(); 
		
			return;
		}

		for(int i = 0; i < oper.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = oper[i];
				per(depth + 1, r);  
				visited[i] = false;
			}
		}
	}
    
	public void solve() { 
		ArrayList<String> oper = new ArrayList<String>();
		oper.addAll(operList);
		
		ArrayList<Long> num = new ArrayList<Long>();
		num.addAll(numList);
		
		for(int i = 0; i < output.length; i++) {
			String curOper = output[i];  
			
			for(int j = 0; j < oper.size(); j++) {
				
				if(oper.get(j).equals(curOper)) {  
					long n1 = num.get(j);
					long n2 = num.get(j+1);
					long res = cal(n1, n2, curOper);
					
					num.remove(j+1);  
					num.remove(j);
					oper.remove(j);  
	
					num.add(j, res);  
					j--; 
				}
			}
		}
		
		answer = Math.max(answer, Math.abs(num.get(0)));
	}
	
	public long cal(long n1, long n2, String o) {
		long res = 0;
		switch(o) {
		case "+" :
			res = n1 + n2;
			break;
		case "-" :
			res = n1 -n2;
			break;
		case "*" :
			res = n1 * n2;
			break;
		}		
		return res;
	}

}
