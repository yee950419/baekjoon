import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int THROW = 3;

	public static void main(String[] args) throws IOException {
		
		int[] nums = new int[THROW];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<THROW; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		int tempCount = 1;			// 임시 카운트
		int maxSameCount = 1;		// 가장 많은 카운트
		int maxCountNum = nums[THROW-1];	// 가장 많은 카운트의 주사위 숫자
		for(int i=1; i<THROW; i++) {
			if(nums[i] == nums[i-1]) {
				tempCount++;
				maxSameCount = maxSameCount < tempCount ? tempCount : maxSameCount;
				maxCountNum = nums[i];
			}
			else {
				tempCount = 1;
			}
		}
		
		int result = 0;
		if(maxSameCount == 3) {
			result = 10000 + maxCountNum*1000;
		}
		else if(maxSameCount == 2) {
			result = 1000 + maxCountNum*100;
		}
		else if(maxSameCount == 1) {
			result = maxCountNum * 100;
		}
		
		System.out.println(result);
	}
}
