import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static List<Integer> nums = new ArrayList<Integer>();
	private static int T;
	private static int N;
	private static long sum;
	
	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		getResult();
		System.out.println(sb);
	}
	
	static void getResult() throws IOException {
		
		int num;
		int count = T;
		
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				num = Integer.parseInt(st.nextToken());
				nums.add(num);
			}
			
			sum = 0;
			sb.append("#" + (count-T) + " ");
			getMaxProfit(0);
			sb.append(sum + "\n");
			nums.clear();
		}
	}
	
	static void getMaxProfit(int index) {
		int biggest = nums.get(index);
		int biggestIndex = index;
		boolean isRemain = false;
		
		//가장 높은 수의 인덱스 찾기
		for(int i=index; i<nums.size(); i++) {
			if(biggest < nums.get(i)) {
				biggest = nums.get(i);
				biggestIndex = i;
				isRemain = true;
			}
		}
		
		if(isRemain) {
			for(int i=index; i<biggestIndex; i++) {
				int result = nums.get(biggestIndex) - nums.get(i);
				if(result > 0) {
					sum += result;
				}
			}
		}
		if(biggestIndex != N-1)
		{
			getMaxProfit(biggestIndex + 1);
		}
	}
}