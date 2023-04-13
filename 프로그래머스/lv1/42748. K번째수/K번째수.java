import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] tempArray;
        
        for(int commandsNum=0; commandsNum<commands.length; commandsNum++){
            
            int startIndex = commands[commandsNum][0]-1;
            int endIndex = commands[commandsNum][1];
            int getIndex = commands[commandsNum][2]-1;
            int tempIndex = 0;
            tempArray = new int[endIndex - startIndex];
            
            //sort 할 원소만 tempArray에 저장
            for(int i=startIndex; i<endIndex; i++){
                
                tempArray[tempIndex] = array[i];
                tempIndex++;
            }
            
            Arrays.sort(tempArray);
            answer[commandsNum] = tempArray[getIndex];
        }
        return answer;
    }
}