class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i=0; i<numbers.length; i++){
            String BinaryString =  Long.toBinaryString(numbers[i]);
            if(numbers[i]%2==0){
                answer[i] = numbers[i]+1;
            }else{
                int lastindex =  BinaryString.lastIndexOf("0");
                int firstindex = BinaryString.indexOf("1",lastindex);
                if(lastindex==-1){
                    numbers[i]+=1;
                    BinaryString =  Long.toBinaryString(numbers[i]);
                    BinaryString = BinaryString.substring(0,2)+
                            BinaryString.substring(2,BinaryString.length()).replace("0","1");

                }else{
                    BinaryString = BinaryString.substring(0,lastindex)+"1"+
                            BinaryString.substring(lastindex+1,firstindex)+"0"+
                            BinaryString.substring(firstindex+1,BinaryString.length());
                }
                answer[i] = Long.parseLong(BinaryString,2);
            }
        }
        return answer;
    }
}
