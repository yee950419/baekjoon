import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int count = 0;
        
        Map<String, Integer> participantMap = new HashMap<>();
        Map<String, Integer> completionMap = new HashMap<>();
        
        for(int i=0; i<participant.length; i++){
            
            //동일 이름이 있을 시, count 증가
            if(participantMap.containsKey(participant[i])) {
                
                count = participantMap.get(participant[i]);
                participantMap.put(participant[i], ++count);
            }
            //동일 이름이 없을 시, count 1
            else{
                participantMap.put(participant[i], 1);
            }
        }
        
        count=0;
        for(int i=0; i<completion.length; i++){
            
            //동일 이름이 있을 시, count 증가
            if(completionMap.containsKey(completion[i])) {
                
                count = completionMap.get(completion[i]);
                completionMap.put(completion[i], ++count);
            }
            //동일 이름이 없을 시, count 1
            else{
                completionMap.put(completion[i], 1);
            }
        }
        
        
        for(int i=0; i<participant.length; i++){
            
            boolean isContain = completionMap.containsKey(participant[i]);
            
            if(!isContain){
                answer = participant[i];
                break;
            }
            
            int completionCount = completionMap.get(participant[i]);
            int participantCount = participantMap.get(participant[i]);
            if(completionCount != participantCount){
                answer = participant[i];
                break;
            }
        }
        
        return answer;
    }
}