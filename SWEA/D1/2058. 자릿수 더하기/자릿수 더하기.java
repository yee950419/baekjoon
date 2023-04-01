import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    private static int N;
 
    public static void main(String[] args) throws Exception {
   
        N = Integer.parseInt(br.readLine());
        
        int result = getResult();
        System.out.println(result);
    }
    
    static int getResult() {
    	int sum = 0;
    	
    	while(N > 0) {
    		sum += (N % 10);
    		N /= 10;
    	}
    	
    	return sum;
    }
}