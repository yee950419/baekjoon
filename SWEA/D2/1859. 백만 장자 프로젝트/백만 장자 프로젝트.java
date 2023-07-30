import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int T, N;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		
		T = Integer.parseInt(br.readLine());
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			sb.append("#" + testCase + " ");
			
			inputDatas();
			getMaxProfit();
		}
	}
	
	static void inputDatas() throws IOException {
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			nums[i] = num;
		}
	}
	
	static void getMaxProfit() {
		
		int sellNum = nums[N-1];
		long profit = 0;
		for(int i=1; i<N; i++) {
			if(nums[N-i-1] > sellNum) {
				sellNum = nums[N-i-1];
			}
			else {
				profit += sellNum - nums[N-i-1];
			}
		}
		
		sb.append(profit + "\n");
	}
}