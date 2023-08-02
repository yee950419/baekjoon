import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static final int N = 9;
	static final int M = 7;
	static int[] datas = new int[N];
	static int[] nums = new int[M];
	static int totalNum;
	
	public static void main(String[] args) throws IOException {
		
		for(int i=0; i<N; i++) {
			datas[i] = Integer.parseInt(br.readLine());
		}
		totalNum = 0;
		combi(0, 0);
		System.out.println(sb);
	}
	
	static boolean combi(int depth, int start) {

		if(depth == M) {
			if(totalNum == 100) {
				for(int n : nums) {
					sb.append(n + "\n");
				}
				return true;
			}
			return false;
		}
		
		for(int i=start; i<N; i++) {
			nums[depth] = datas[i];
			totalNum += datas[i];
			if(combi(depth+1, i+1)) {
				break;
			}
			totalNum -= datas[i];
		}
		
		return false;
	}
}