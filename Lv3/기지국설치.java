class Solution{ 
    public int solution(int n, int[] stations, int w){ 
        int cnt=0
        int sIdx=0; 		
        for(int i=1; i <= n ; i++){
         	if(sIdx < stations.length && stations[sIdx] - w <= i){ 
			i = stations[sIdx++] + w; 			
                }else{ 
			cnt++; 		
      		        i += (w * 2); 
		} 		
          } 		
          return cnt; 
     } 
 }
